<template>
    <div class="nav-bar">
        <div class="left">
            <slot name="left"></slot>
        </div>
        <div class="center">
            <slot name="center"></slot>
        </div>
        <div class="right">
            <slot name="right"></slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: "NavBar"
    }
</script>

<style scoped>
    .nav-bar {
        display: flex;
        height: 47px;
        line-height: 47px;
        text-align: center;
        box-shadow: 0 4px 4px rgba(100, 100, 100, .1);
        background-color: #BDBCF0;
        color: white;
        font-size: 22px;
        /*在使用浏览器原生滚动时，为了让导航不跟随一起滚动*/
        /*position: fixed;*/
        /*left: 0;*/
        /*right: 0;*/
        /*top: 0;*/
        /*z-index: 9;*/
    }

    .left {
        height: 56px;
        line-height: 56px;
    }

    .left, .right {
        width: 60px;
    }

    .center {
        flex: 1;
    }
</style>