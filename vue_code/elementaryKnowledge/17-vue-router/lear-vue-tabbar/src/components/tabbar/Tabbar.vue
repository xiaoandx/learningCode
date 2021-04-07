<template>
  <div id="app">
    <div id="tab-bar">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Tabbar'
}
</script>

<style>
  #tab-bar{
    display: flex;
    background-color: antiquewhite;
    position: fixed;
    left: 0;
    right: 0;
    bottom: 0;
    box-shadow: 0 -1px  1px rgba(100, 100, 100, .2);
  }

</style>
