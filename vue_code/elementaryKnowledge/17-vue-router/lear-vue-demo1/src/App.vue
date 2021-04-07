<!--
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
-->
<template>
  <div id="app">
    <!-- 属性补充  
    1.type;2.replace(不可以返回)；3.action-class 设置样式
    type='button' -->
    <router-link to="/home">首页</router-link>
    <router-link to="/about">关于</router-link>
    <router-link :to="'/user/'+userId">用户</router-link>
    <router-link :to="{ path: '/profile', query: { name: 'zty', age: 24, height: 177 } }">个人信息</router-link>
    <keep-alive>
      <router-view />
    </keep-alive>
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
