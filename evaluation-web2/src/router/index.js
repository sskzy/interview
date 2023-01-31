import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/layout'
import qsb from "@/router/modules/qsb";
import ceshi from "@/router/modules/ceshi";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '首页',
    component: Layout,
    children:[
        ...qsb,
        // ...ceshi
    ]
  },
]

const router = new VueRouter({
  routes
})

export default router
