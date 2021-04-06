<template>
  <div>
      <h1>关于我的页面组件</h1>
      <p>性别：{{sex}}</p>
  </div>
</template>

<script>
export default {
  name: 'About',
  data() {
    return {
      sex:'男'
    }
  }
}
</script>

<style  scoped>

</style>
