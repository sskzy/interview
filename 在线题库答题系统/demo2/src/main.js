import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

/** element-ui 
 * npm i element-ui -S
 */
 import ElementUI from 'element-ui';
 import 'element-ui/lib/theme-chalk/index.css';
 
 Vue.use(ElementUI);
 
 
 /** axios 
  * npm install axios
  */
 import axios from 'axios'
 // axios.defaults.baseURL='http://localhost:5838/study'
 
 Vue.prototype.$axios = axios
 
/** mock 
 * npm install mockjs -g
 */
 import '@/mock/mock.js'

/** less
 * npm install -g less
 * 解析器: npm install less less-loader
 */
 import '@/assets/style/theme.less'

/** basic */
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
