<template>
    <div id="home-recommend">
        <div class="recommend">
            <div class="recommend-item" v-for="(item,index) in recommends" :key="index">
                <a :href="item.link">
                    <img v-lazy="item.image">
                </a>
                <div>{{item.title}}</div>
            </div>
        </div>
        <a href="https://act.mogujie.com/zzlx67">
            <img class="reimg" src="../../../assets/img/home/recommend_bg.jpg">
        </a>
    </div>
</template>

<script>
    export default {
        name: "HomeRecommend",
        props: {
            recommends: {
                type: Array,
                default() {
                    return []
                }
            }
        }
    }
</script>

<style scoped>
    .recommend {
        display: flex;
        width: 100%;
        text-align: center;
        font-size: 16px;
        padding: 10px 0 20px;
        border-bottom: 8px solid #eee;
        background-color: white;
    }

    .recommend-item {
        flex: 1;
    }

    .reimg {
        width: 100%;
    }

    .recommend-item img {
        width: 80px;
        height: 80px;
        margin-top: 10px;
    }
</style>