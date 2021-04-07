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
 * @Date: 2021-04-07 15:16:41
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
-->
<template>
  <div>
    <tab-bar>
      <tab-bar-item path="/home">
        <img slot="item-icon" src="@/assets/img/tabbar/home.png" alt="">
        <img slot="item-icon-active" src="@/assets/img/tabbar/home_active.png" alt="">
        <div slot="item-text">首页</div>
      </tab-bar-item>
      <tab-bar-item path="/categories">
        <img slot="item-icon" src="@/assets/img/tabbar/categories.png" alt="">
        <img slot="item-icon-active" src="@/assets/img/tabbar/categories_active.png" alt="">
        <div slot="item-text">分类</div>
      </tab-bar-item>
      <tab-bar-item path="/shop">
        <img slot="item-icon" src="@/assets/img/tabbar/shopcart.png" alt="">
        <img slot="item-icon-active" src="@/assets/img/tabbar/shopcart_active.png" alt="">
        <div slot="item-text">购物车</div>
      </tab-bar-item>
     <tab-bar-item path="/profile">
        <img slot="item-icon" src="@/assets/img/tabbar/profile.png" alt="">
        <img slot="item-icon-active" src="@/assets/img/tabbar/profile_active.png" alt="">
        <div slot="item-text">我的</div>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>

<script>
import TabBar from './tabbar/Tabbar'
import TabBarItem from './tabbar/TabbarItem'
export default {
  name: 'MainTabbar',
  components: {
    TabBar,
    TabBarItem
  }
}
</script>

<style  scoped>

</style>

