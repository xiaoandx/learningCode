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
 * @Date: 2021-04-06 12:28:03
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
-->
<template>
  <div>
    <h1>我是用户界面</h1>
    <p>用户信息展示:{{userId}}</p>
  </div>
</template>

<script>
export default {
  name: 'User',
  data () {
    return {
    }
  },
  computed: {
    userId(){
      return this.$route.params.userId
    }
  }
}
</script>

<style  scoped>

</style>

