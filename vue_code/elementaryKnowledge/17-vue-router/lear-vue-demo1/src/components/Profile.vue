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
 * @Date: 2021-04-06 13:14:13
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
-->
<template>
  <div>
    <h2>这是档案界面</h2>
    <p>这里是档案页面的内容。</p>
    <p>档案的名字是: {{ profileInfo.name }}</p>
    <p>档案的年龄是: {{ profileInfo.age }}</p>
    <p>档案的身高是: {{ profileInfo.height }}</p>
  </div>
</template>

<script>
export default {
  name: 'Profile',
  computed: {
    profileInfo() {
      return this.$route.query
    }
  }
}
</script>

<style  scoped>

</style>

