import Vue from 'vue'
import VueRouter from 'vue-router'

import Layout from '@/layout' //布局页



Vue.use(VueRouter)

// 通用页面, 这里的配置不需要权限
export const constRouter = [
  {
      path: '/login',
      component: () => import('@/views/login/Login'),
      hidden: true //导航菜单忽略选项
  },
  {
      path: '',
      component: Layout, //应用布局页
      redirect: '/index',
      hidden: true,
  },
  {
      path: '/index',
      component: Layout, //应用布局页
      name: 'index',
      meta:{
          title: "首页", //导航菜单项标题
          icon: 'el-icon-s-home' //导航菜单图标
      },
      children: [
        {
          path: '',
          component: () => import('@/views/index/index.vue'),
          name: 'indexs',
          meta: {
            title: "首页",
            icon: 'el-icon-s-home',
            roles: ['admin','jerry']
          }
        }
      ]
  }
]

// 动态路由 communication
export const asyncRoutes = [
  {
    path: '/goods',
    component: Layout,
    redirect: '/goods/index',
    meta:{
      title: "设备管理",
      icon: 'el-icon-s-goods',
      hidden: false,
    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/goods/Index.vue'),
        name: 'goodsindex',
        meta: {
          title: "我的设备",
          icon: 'el-icon-tickets',
          hidden: false,
          roles: ['admin','jerry']
        }
      },
      {
        path: 'map',
        component: () => import('@/views/goods/Index.vue'),
        name: 'goodsindex',
        meta: {
          title: "设备地图",
          icon: 'el-icon-tickets',
          hidden: false,
          roles: ['admin','jerry']
        }
      },
      {
        path: 'statistic',
        component: () => import('@/views/goods/Index.vue'),
        name: 'goodsindex',
        meta: {
          title: "统计信息",
          icon: 'el-icon-tickets',
          hidden: false,
          roles: ['admin','jerry']
        }
      },
      {
        path: 'fromgood',
        component: () => import('@/views/goods/FromGood.vue'),
        name: 'fromgood',
        meta: {
          title: "添加(编辑产品)",
          icon: 'el-icon-tickets',
          hidden: true,
          roles: ['admin','jerry'],
          
        }
      },
    ]
  },
  {
    path: '/home',
    component: Layout,
    redirect: '/home/index',
    meta:{
      title: "个人中心",
      icon: 'el-icon-user-solid',
      hidden: false,
    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/home/Index.vue'),
        name: 'homeindex',
        meta: {
          title: "个人设置",
          icon: 'el-icon-user-solid',
          hidden: false,
          roles: ['admin','jerry']
        }
      },
      {
        path: 'Informationall',
        component: () => import('@/views/home/Informationall.vue'),
        name: 'homeinformationall',
        meta: {
          title: "个人消息",
          icon: 'el-icon-message-solid',
          hidden: false,
          roles: ['admin','jerry']
        }
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes: constRouter
})

export default router

