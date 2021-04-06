<template>
  <div>
      <h1>我是Home组件</h1>
      <p>Home组件中的内容 作者：{{name}}</p>
      <router-link to="/home/news">新闻</router-link>
      <router-link to="/home/message">消息</router-link>
      <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {
      name:'周巍'
    }
  }
}
</script>

<style  scoped>

</style>
