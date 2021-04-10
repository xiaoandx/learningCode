<template>
    <div id="detail">
        <nav-bar class="detail-nav-bar">
            <template v-slot:left>
                <img src="../../assets/img/common/back.svg" @click="btnBack">
            </template>
            <template v-slot:center>
                <tab-control :titles=titles @tabControlClick="goIndex" ref="tabControl" />
            </template>
        </nav-bar>
        <scroll class="content" @scroll="controlScroll" ref="scroll" :probe-type="3">
            <slider :autoplay="3000" :banners="detailResults.detailSwipperImg" class="ydslider"/>
            <detail-base-info :goods="detailResults.goodsInfo"/>
            <detail-shop-info :shop="detailResults.shopInfo"/>
            <detail-goods-info :detail-info="detailResults.detailInfo" @detailImagesLoad="detailImagesLoad"/>
            <detail-param-info ref="param" :paramInfo="detailResults.paramInfo"/>
            <detail-comment-info ref="comment" :comment-info="detailResults.commentInfo"/>
            <div style="color: red;font-size: 14px">更多推荐</div>
            <goods-list ref="recommend" :goods="detailResults.recommends"/>
        </scroll>
        <back-top @click.native="backClick" v-show="isShowBackTop"/>
        <!--        <tab-bar class="detail-tab-bar">-->
        <!--            <tab-bar-item active-color="hotpink" path="">-->
        <!--                <template v-slot:icon-text><div class="height">客服</div></template>-->
        <!--            </tab-bar-item>-->
        <!--            <tab-bar-item active-color="black" path="">-->
        <!--                <template v-slot:icon-text><div class="height">店铺</div></template>-->
        <!--            </tab-bar-item>-->
        <!--            <tab-bar-item active-color="black" path="">-->
        <!--                <template v-slot:icon-text><div class="height">收藏</div></template>-->
        <!--            </tab-bar-item>-->
        <!--            <tab-bar-item active-color="white" path="" @click.native="addToShopCar">-->
        <!--                <template v-slot:icon-text><div class="cart height">加入购物车</div></template>-->
        <!--            </tab-bar-item>-->
        <!--            <tab-bar-item active-color="white" path="">-->
        <!--                <template v-slot:icon-text><div class="buy height">购买</div></template>-->
        <!--            </tab-bar-item>-->
        <!--        </tab-bar>-->
        <van-goods-action>
            <van-goods-action-icon icon="chat-o" text="客服" color="#ee0a24"/>
            <van-goods-action-icon icon="shop-o" text="店铺"/>
            <van-goods-action-icon icon="star" text="已收藏" color="#ff5000"/>
            <van-goods-action-button type="warning" text="加入购物车" @click.native="addToShopCar"/>
            <van-goods-action-button type="danger" text="立即购买"/>
        </van-goods-action>
    </div>
</template>

<script>
    import NavBar from "../../components/common/navbar/NavBar";
    import TabControl from "../../components/content/tabcontrol/TabControl";
    import Slider from "../../components/common/slider/Slider";
    import DetailShopInfo from "./detailchildren/DetailShopInfo";
    import DetailBaseInfo from "./detailchildren/DetailBaseInfo";
    import DetailParamInfo from "./detailchildren/DetailParamInfo";
    import DetailGoodsInfo from "./detailchildren/DetailGoodsInfo";
    import DetailCommentInfo from "./detailchildren/DetailCommentInfo";

    // import TabBar from "../../components/common/tabbar/TabBar";
    // import TabBarItem from "../../components/common/tabbar/TabBarItem";


    import Scroll from "../../components/common/scroll/Scroll";
    import BackTop from "../../components/common/backtop/BackTop";

    import {getDetail, getDetailRecommend} from "../../network/Detail";

    import {Goods, Shop, GoodsParam} from "../../network/Detail";
    import GoodsList from "../../components/common/goods/GoodsList";
    import {mixinImgItemLoad} from "../../common/mixin";
    import {debounce} from "../../common/util";

    import {Toast} from 'vant'

    import Vue from 'vue';
    import {GoodsAction, GoodsActionIcon, GoodsActionButton} from 'vant';

    Vue.use(GoodsAction);
    Vue.use(GoodsActionButton);
    Vue.use(GoodsActionIcon);
    export default {
        name: "Detail",
        data() {
            return {
                iid: null,
                detailResults: {
                    detailSwipperImg: [],
                    shopInfo: {},
                    goodsInfo: {},
                    detailInfo: {},
                    paramInfo: {},
                    commentInfo: {},
                    recommends: []
                },
                titles: ['商品', '参数', '评价', '推荐'],
                isShowBackTop: false,
                imgItemLoad: null,
                themeTopY: [],
                getThemeTopY: null,
                currentIndex: 0
            }
        },
        created() {
            this.iid = this.$route.params.iid
            getDetail(this.iid).then(res => {
                this.detailResults.detailSwipperImg = res.data.result.itemInfo.topImages
                this.detailResults.shopInfo = new Shop(res.data.result.shopInfo)
                this.detailResults.goodsInfo = new Goods(
                    res.data.result.itemInfo,
                    res.data.result.columns,
                    res.data.result.shopInfo.services)
                this.detailResults.detailInfo = res.data.result.detailInfo
                this.detailResults.paramInfo = new GoodsParam(
                    res.data.result.itemParams.info,
                    res.data.result.itemParams.rule)
                if (res.data.result.rate.cRate !== 0) {
                    this.detailResults.commentInfo = res.data.result.rate.list[0]
                }
            })
            getDetailRecommend().then(res => {
                this.detailResults.recommends = res.data.data.list
            })
            this.getThemeTopY = debounce(() => {
                this.themeTopY = []
                this.themeTopY.push(0)
                this.themeTopY.push(this.$refs.param.$el.offsetTop)
                this.themeTopY.push(this.$refs.comment.$el.offsetTop)
                this.themeTopY.push(this.$refs.recommend.$el.offsetTop)
                this.themeTopY.push(Number.MAX_VALUE)
            }, 100)
        },
        components: {
            GoodsList,
            // TabBar,
            NavBar,
            // TabBarItem,
            TabControl,
            DetailShopInfo,
            DetailBaseInfo,
            Scroll,
            DetailGoodsInfo,
            BackTop,
            DetailParamInfo,
            DetailCommentInfo,
            Slider
        },
        methods: {
            btnBack() {
                this.$router.back()
            },
            backClick() {
                this.$refs.scroll.scroll.scrollTo(0, 0, 500)
            },
            controlScroll(position) {
                this.isShowBackTop = position.y < -1000
                const y = -position.y
                let t = this.themeTopY
                let lenth = this.themeTopY.length
                //方式一：
                // for(let i = 0;i < lenth;i++){
                //     if(this.currentIndex !== i && ((i < lenth - 1 && y >= t[i] && y < t[i+1]) ||
                //         (i === lenth - 1 && y >= t[i]))){
                //         this.currentIndex = i
                //         this.$refs.tabControl.currentIndex = this.currentIndex
                //     }
                // }

                //方式二：
                for (let i = 0; i < lenth - 1; i++) {
                    if (this.currentIndex !== i && (y >= t[i] && y < t[i + 1])) {
                        this.currentIndex = i
                        this.$refs.tabControl.currentIndex = this.currentIndex
                    }
                }
            },
            detailImagesLoad() {
                this.refresh()
                this.getThemeTopY()
            },
            goIndex(index) {
                this.$refs.scroll.scroll.scrollTo(0, -this.themeTopY[index], 100)
            },
            addToShopCar() {
                const product = {}
                product.image = this.detailResults.detailSwipperImg[0]
                product.title = this.detailResults.goodsInfo.title
                product.desc = this.detailResults.goodsInfo.desc
                product.price = this.detailResults.goodsInfo.realPrice
                product.iid = this.iid
                this.$store.dispatch('addCart', product).then(res => {
                    Toast.success(res)
                })
            }
        },
        mixins: [mixinImgItemLoad],
        mounted() {
        },
        destroyed() {
            this.$bus.$off('imgItemLoad', this.imgItemLoad)
        }
    }
</script>

<style scoped>
    .detail-tab-bar {
        height: 49px;
    }

    .detail-tab-bar tab-bar-item {
        margin-top: 10px;
    }

    .content {
        overflow: hidden;
        position: absolute;
        top: 44px;
        bottom: 56px;
        left: 0;
        right: 0;
    }

    .cart {
        background-color: yellow;
        font-size: 3.8vw;
    }

    .buy {
        background-color: red;
        font-size: 20px;
    }

    .height {
        height: 49px;
        line-height: 49px;
    }

    .detail-nav-bar {
        background-color: white;
        color: black;
        height: 47px;
        line-height: 47px;
    }

    .ydslider {
        height: 300px;
        overflow: hidden;
    }

    #detail {
        position: relative;
        z-index: 9;
        background-color: #fff;
        height: 100vh;
    }
</style>