<template>
  <div id="app">
    <!-- 属性补充  
    1.type;2.replace(不可以返回)；3.action-class 设置样式
    type='button' -->
    <router-link to="/home">首页</router-link>
    <router-link to="/about">关于</router-link>
    <router-link :to="'/user/'+userId">用户</router-link>
    <router-link :to="{ path: '/profile', query: { name: 'zty', age: 24, height: 177 } }">个人信息</router-link>
    <router-view />
  </div>
</template>

<script>
  export default {
    name: "App",
    data() {
      return {
        userId:123,
        profileInfo:{
          name: "zty",
          age: 24,
          height: 177
        }
      }
    },
    methods: {},
  };
</script>
  
<style>
  #app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  .active {
    color: red;
  }
</style>
