import axios from 'axios'
import {Message} from 'element-ui'
import store from '../store'

const CancelToken = axios.CancelToken;
const source = CancelToken.source();
const service = axios.create({
    // baseURL: process.env.VUE_APP_BASE_API,// url = base url + request url
    timeout: 5000,
    // withCredentials: true // send cookies when cross-domain requests
    cancelToken: source.token
})

// Request interceptors
service.interceptors.request.use(
    (config) => {
        if (store.state.userInfo.token) {
            // Add X-Access-Token header to every request, you can add other custom headers here
            config.headers['token'] = store.state.userInfo.token
        } else {
            source.cancel("取消请求")
        }

        return config
    },
    (error) => {
        Promise.reject(error)
    }
)

// Response interceptors
service.interceptors.response.use(
    (response) => {
        // Some example codes here:
        // code == 10000: success
        // code == 50001: invalid access token
        // code == 50002: already login in other place
        // code == 50003: access token expired
        // code == 50004: invalid user (user not exist)
        // code == 50005: username or password is incorrect
        // You can change this part for your own usage.
        const res = response.data
        if (res.status !== 200) {
            if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
                MessageBox.confirm(
                    '你已被登出，可以取消继续留在该页面，或者重新登录',
                    '确定登出',
                    {
                        confirmButtonText: '重新登录',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }
                ).then(() => {
                    // UserModule.ResetToken()
                    // location.reload() // To prevent bugs from vue-router
                })
            }
            // return Promise.reject(new Error(res.msg || 'Error'))
            return Promise.reject(res)

        } else {
            // console.log(response.config.url, response.data)
            return response.data
        }
    },
    (error) => {
        Message({
            message: error.msg,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)
export default service

