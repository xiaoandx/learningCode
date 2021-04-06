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
    component: About
  },
  {
    path:'/user/:userId',
    component:User
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

export default router