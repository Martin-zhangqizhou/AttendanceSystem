import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login/index.vue'
import Home from '@/views/home/index.vue'
import Layout from '@/views/layout/index.vue'
import PersonMan from '@/views/personMan/index.vue'
import Publish from '@/views/publish/index.vue'
import Image from '@/views/image/index.vue'
import Comment from '@/views/comment/index.vue'
import Settings from '@/views/settings/index.vue'
import Fans from '@/views/fans/index.vue'
import Worker from '@/views/worker/index.vue'
import workerLayout from '@/views/workerLayout/index.vue'


import NProgress from 'nprogress'


Vue.use(VueRouter)
// 路由配置表
const routes = [
  {
    path : '/login',
    name : 'login',
    component : Login
  },
  {
    path: '/worker',
    // 命名路由有一个默认子路由 这个名字没有意义
    // 正确的做法是 如果有默认子路由， 就不要给父路由器名字
    // name: 'layout',
    component: workerLayout,
    children : [
      {
        path: '', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'worker',
        component: Worker
      },
    ]
  },
  {
    path: '/',
    // 命名路由有一个默认子路由 这个名字没有意义
    // 正确的做法是 如果有默认子路由， 就不要给父路由器名字
    // name: 'layout',
    component: Layout,
    children : [
      {
        path: '', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'home',
        component: Home
      },
      {
        path: '/personMan', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'personMan',
        component: PersonMan
      },
      {
        path: '/publish', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'publish',
        component: Publish
      },
      {
        path: '/image', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'image',
        component: Image
      },
      {
        path: '/comment', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'comment',
        component: Comment
      },
      {
        path: '/settings', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'settings',
        component: Settings
      },
      {
        path: '/fans', // path 为空 会作为默认子路由s
        // 路由的名字是 为了在动态路由中 根据路由的名字 进行访问 不比=需要拼接
        name: 'fans',
        component: Fans
      }
    ]
  },
]


const router = new VueRouter({
  routes
})
// 路由导航守卫 所有页面的导航都会经过这里
// 守卫页面导航
// to：要去的路由信息
// from：来自哪里的路由信息
// next：放行方法
router.beforeEach((to, from, next) => {
  // 如果要访问的页面不是 /login，校验登录状态
  // 如果没有登录，则跳转到登录页面
  // 如果登录了，则允许通过
  // 允许通过
  // next()

  // 开启顶部导航进度条
  NProgress.start()
  // 停止导航
  // 我们可以在一些特殊情况下，停留在当前页面，中断当前导航
  // next(false)

  // 1. 如果访问的是登录页面，则直接放行
  if (to.path === '/login') {
    next()
    // 停止代码往后执行
    return
  }

  const user = JSON.parse(window.localStorage.getItem('user'))

  if (user){
    next()
  } else {
    // 2.3 没有，就跳转到登录页
    next('/login') // 跳转到指定路由
  }
})
router.afterEach((to, from) => {
  // 结束顶部的导航进度条
  NProgress.done();
});

export default router
