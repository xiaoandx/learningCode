<template>

    <div id="nav">
        <keep-alive exclude="Detail">
            <router-view></router-view>
        </keep-alive>
        <tab-bar>
            <TabBarItem path="/home" active-color="#BDBCF0">
                <template v-slot:icon-text>首页</template>
            </TabBarItem>
            <TabBarItem path="/classify" active-color="#BDBCF0">
                <template v-slot:icon-text>分类</template>
            </TabBarItem>
            <TabBarItem path="/shopcar" active-color="#BDBCF0">
                <template v-slot:icon-text>购物车</template>
            </TabBarItem>
            <TabBarItem path="/profile" active-color="#BDBCF0">
                <template v-slot:icon-text>我的</template>
            </TabBarItem>

        </tab-bar>
    </div>
</template>
<script>
    import TabBar from "./components/common/tabbar/TabBar";
    import TabBarItem from "./components/common/tabbar/TabBarItem";

    export default {
        data() {
            return {
                tabList: [
                    {path: "/home", activeC: "blue", title: "首页"},
                    {path: "/classfy", activeC: "", title: "分类"},
                    {path: "/shopcar", activeC: "green", title: "购物车"},
                    {path: "/profile", activeC: "yellow", title: "我的"}
                ]
            }
        },

        components: {
            TabBar,
            TabBarItem
        },
        methods: {}
    }
</script>
<style>

</style>