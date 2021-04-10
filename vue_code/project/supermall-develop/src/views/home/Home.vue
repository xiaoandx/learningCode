<template>
    <div id="home">
        <nav-bar class="home-nav">
            <template v-slot:center>首页</template>
        </nav-bar>
        <scroll class="content"
                ref="scroll"
                :probe-type="3"
                @scroll="controlScroll"
                @pullingUp="loadMore"
                :pull-up-load="true">
            <slider :autoplay="3000" :banners="results.banners"/>
            <home-recommend :recommends="results.recommends"/>
            <TabControl class="tab-control"
                        :titles="titles"
                        @tabControlClick="tabCClick"
                        ref="tabControl"/>
            <goods-list :goods="showGoods"/>
        </scroll>
        <back-top @click.native="backClick" v-show="isShowBackTop"/>
    </div>
</template>

<script>
    import NavBar from "../../components/common/navbar/NavBar";
    import GoodsList from "../../components/common/goods/GoodsList"
    import Scroll from "../../components/common/scroll/Scroll";
    import BackTop from "../../components/common/backtop/BackTop";

    import TabControl from "../../components/content/tabcontrol/TabControl";
    import Slider from "../../components/common/slider/Slider";
    import HomeRecommend from "./homechildren/HomeRecommend";
    import {mixinImgItemLoad} from "../../common/mixin";

    import {
        getHomeMutidata,
        getNpsData
    } from "../../network/Home";

    export default {
        name: "Home",
        data() {
            return {
                results: {
                    banners: [],
                    recommends: [],
                    dKeyWords: [],
                    keywords: [],
                    goods: {
                        pop: {page: 0, list: []},
                        sell: {page: 0, list: []},
                        new: {page: 0, list: []}
                    }
                },
                images: [
                    'https://img.yzcdn.cn/vant/apple-1.jpg',
                    'https://img.yzcdn.cn/vant/apple-2.jpg',
                ],
                currentType: 'pop',
                isShowBackTop: false,
                tabOffSetTop: 0,
                saveY: 0,
                titles: ['流行', '热销', '新款'],
                imgItemLoad: null
            }
        },
        computed: {
            showGoods() {
                return this.results.goods[this.currentType].list
            }
        },
        created() {
            this.getHomeMutidata()
            this.getNPSData('pop')
            this.getNPSData('new')
            this.getNPSData('sell')
        },
        mixins: [mixinImgItemLoad],
        mounted() {
        },
        methods: {
            tabCClick(index) {
                switch (index) {
                    case 0:
                        this.currentType = "pop"
                        break
                    case 1:
                        this.currentType = "new"
                        break
                    case 2:
                        this.currentType = "sell"
                        break
                }
            },
            controlScroll(position) {
                this.isShowBackTop = position.y < -1000
            },
            loadMore() {
                this.getNPSData(this.currentType)

            },
            getHomeMutidata() {
                getHomeMutidata().then(res => {
                    this.results.banners = res.data.data.banner.list
                    this.results.recommends = res.data.data.recommend.list
                })
            },
            getNPSData(type) {
                const page = this.results.goods[type].page + 1
                getNpsData(type, page).then(res => {
                    this.results.goods[type].list.push(...res.data.data.list)
                    this.results.goods[type].page += 1
                    this.$refs.scroll.scroll.finishPullUp()
                })
            },
            backClick() {
                this.$refs.scroll.scroll.scrollTo(0, 0, 500)
            }
        },
        components: {
            NavBar,
            TabControl,
            GoodsList,
            Scroll,
            BackTop,
            Slider,
            HomeRecommend
        },
        // 生命周期函数中处理滑动bug
        activated() {
            this.$refs.scroll.refresh()
            this.$refs.scroll.scroll.scrollTo(0, this.saveY, 0)

        },
        deactivated() {
            this.saveY = this.$refs.scroll.getY()

            this.$bus.$off('imgItemLoad', this.imgItemLoad)
        }

    }
</script>

<style scoped>
    #home {
        position: relative;
        /*padding-top: 44px;*/
        height: 100vh;
    }

    /*
        吸顶
    */
    /*.tab-control{*/
    /*    position: sticky;*/
    /*    top: 44px;*/
    /*    z-index: 9;*/
    /*}*/
    .tab-control {
        height: 40px;
        line-height: 40px;
    }

    .content {
        overflow: hidden;
        position: absolute;
        top: 44px;
        bottom: 49px;
        left: 0;
        right: 0;
    }

    /*.content {*/
    /*    height: calc(100% - 93px);*/
    /*    overflow: hidden;*/
    /*    margin-top: 44px;*/

    /*}*/

</style>