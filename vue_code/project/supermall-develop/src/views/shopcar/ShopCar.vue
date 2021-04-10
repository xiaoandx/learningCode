<template>
    <div id="shopcar">
        <nav-bar class="home-nav">
            <template v-slot:center>购物车<span v-show="length > 0">({{length}})</span></template>
        </nav-bar>
        <scroll class="content" ref="scroll">
            <cart-list :cart-list="list"/>
            <div class="hint" v-show="length === 0">
                <img src="../../assets/img/cart/cartnull.png">
                购物车空空的，去
                <span class="toHome" @click="toHome">逛逛</span>
                吧~
            </div>
        </scroll>
        <cart-bottom/>
    </div>
</template>

<script>
    import NavBar from "../../components/common/navbar/NavBar";
    import Scroll from "../../components/common/scroll/Scroll";
    import CartList from "./shopcarchildren/CartList";
    import CartBottom from "./shopcarchildren/CartBottom";
    import {mapGetters} from 'vuex'

    export default {
        name: "ShopCar",
        data() {
            return {}
        },
        components: {
            NavBar,
            Scroll,
            CartList,
            CartBottom
        },
        methods: {
            toHome() {
                this.$router.push('/home')
            }
        },
        computed: {
            // 两种语法 语法一
            // ...mapGetters['getCartListLength','getCartLists']
            // 语法二
            ...mapGetters({
                length: 'getCartListLength',
                list: 'getCartLists'
            })
        },
        mounted() {
        },
        activated() {
            this.$refs.scroll.refresh()
        }
    }
</script>

<style scoped>
    #shopcar {
        position: relative;
        height: 100vh;
    }

    .content {
        overflow: hidden;
        position: absolute;
        top: 49px;
        bottom: 89px;
        left: 0;
        right: 0;
        background-color: white;
    }

    .hint {
        text-align: center;
        position: relative;
        /*top: 100px;*/
        font-size: 18px;
        color: gray;
        /*background-color: red;*/
    }

    .hint img {
        width: 100%;
    }

    .toHome {
        color: blue;
        border-bottom: 1px solid;
    }

</style>