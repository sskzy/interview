import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/css/normalize.css'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './utils/directives.js'
import axios from 'axios'
import utils from "@/utils/utils.js"
import request from "@/utils/interceptors.js"
import './mock/mock.js'

// 注册element UI库
Vue.use(ElementUI);
Vue.prototype.$axios = request;

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

