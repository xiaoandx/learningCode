<template>
    <div class="goods-item">
        <img :src="showImg" alt="" @load="imgLoad" @click="goToDetail">
        <div class="goods-info">
            <p>{{goodsItem.title}}</p>
            <span class="price">￥{{goodsItem.price}}</span>
            <span class="collect">{{goodsItem.cfav}}</span>
        </div>
    </div>
</template>

<script>
    export default {
        name: "GoodsListItem",
        props: {
            goodsItem: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
        computed: {
            showImg() {
                return this.goodsItem.image || this.goodsItem.showLarge.img
            },
            getIID() {
                return this.goodsItem.item_id || this.goodsItem.iid
            }
        },
        methods: {
            imgLoad() {
                // 当详情页加载图片时，首页不需要调用加载方法
                // 方式一：
                // if(this.$route.path.indexOf("/home")){
                //     this.$bus.$emit("homeImgItemLoad")
                // } else if(this.$route.path.indexOf("/detail")){
                //     this.$bus.$emit("detailImgItemLoad")
                // }
                this.$bus.$emit("imgItemLoad")
            },
            goToDetail() {
                this.$router.push("/detail/" + this.getIID)
            }
        }
    }
</script>

<style scoped>
    .goods-item {
        padding-bottom: 40px;
        position: relative;

        width: 48%;
    }

    .goods-item img {
        width: 100%;
        border-radius: 5px;
        /*border:3px solid hotpink;*/
    }

    .goods-info {
        font-size: 15px;
        position: absolute;
        bottom: 5px;
        left: 0;
        right: 0;
        overflow: hidden;
        text-align: center;
    }

    .goods-info p {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        margin-bottom: 3px;
    }

    .goods-info .price {
        color: hotpink;
        margin-right: 20px;
    }

    .goods-info .collect {
        position: relative;
    }

    .goods-info .collect::before {
        content: '';
        position: absolute;
        left: -15px;
        top: -1px;
        width: 14px;
        height: 14px;
        background: url("../../../assets/img/common/collect.svg") 0 0/14px 14px;
    }
</style>