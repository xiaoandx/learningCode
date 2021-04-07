<template>
  <div class="tab-bar-item"  @click="itemClick">
    <div v-if="!isActive">
      <slot name="item-icon"></slot>
    </div>
    <div v-else>
      <slot name="item-icon-active"></slot>
    </div>
    <div :style="activeStyle">
      <slot name="item-text"></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    path: String,
    activeColor: {
      type: String,
      default: "red",
    },
  },
  data() {
    return {};
  },
  computed: {
    isActive() {
      return this.$route.path.indexOf(this.path) !== -1;
    },
    activeStyle() {
      console.log(this.activeColor)
      return this.isActive ? { color: this.activeColor } : {};
    },
  },
  methods: {
    itemClick() {
      // console.log(this.path)
      this.$router.push(this.path);
    },
  },
};
</script>

<style  scoped>
.tab-bar-item {
  flex: 1;
  text-align: center;
  height: 49px;
  font-size: 10px;
}
.tab-bar-item img {
  width: 24px;
  height: 24px;
  margin-top: 6px;
  vertical-align: middle;
}
/* .action {
  color: red;
} */
</style>
