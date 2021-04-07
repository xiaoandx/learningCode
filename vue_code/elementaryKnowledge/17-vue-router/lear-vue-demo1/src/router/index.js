/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 
 * @Author: WEI.ZHOU
 * @Date: 2021-04-06 10:19:49
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
// import About from '../components/About.vue'
// import User from '../components/User'

//  () => import('../components/About') // 懒加载（设置About组件懒加载）
const About = () => import('../components/About')
const User = () => import('../components/User')
const Profile = () => import('../components/Profile')
const HomeNews = () => import('../components/HomeNews')
const HomeMessage = () => import('../components/HomeMessage')

Vue.use(VueRouter)

// 路由列表必须 为routes变量
const routes = [
  {
    // 默认路径 redirect 重定向
    path:'',
    redirect: '/home'
  },
  {
    path:'/home',
    component:Home,
    meta:{
      title: "首页"
    },
    children:[
      {
        path: '',
        redirect:'news'
      },
      {
        path: 'news',
        component: HomeNews
      },
      {
        path: 'message',
        component: HomeMessage
      }
    ]
  },
  {
    path:'/about',
    component: About,
    meta:{
      title: "关于我们"
    },
  },
  {
    path:'/user/:userId',
    component:User,
    meta:{
      title: "用户"
    },
  },
  {
    path: '/profile',
    component: Profile,
    meta: {
      title: '档案'
    }
  }
]
const router = new VueRouter({
  //配置路由和组件之间的应用关系
  routes,
  mode: 'history',
  linkActiveClass: 'action'
})

/**
 *
 * 前置守卫：从from跳转到to
 * from 来的路由
 * to 要去的路由
 */
 router.beforeEach((to, from, next) => {
  document.title = to.matched[0].meta.title //给目标路由的页面的title赋值
  next()//必须调用，不调用不会跳转
})

/**
 * 后置钩子
 */
 router.afterEach((to, from) => {
  console.log('后置钩子调用了----')
})


export default router