<template>
    <div id="cart-bottom">
        <div class="checkAll">
            <van-checkbox v-model="isCheckAll" @click.native="selectAll">全选</van-checkbox>
        </div>
        <div class="total">合计：{{totalPrice}}元</div>
        <button class="pay" @click="toPay">结算（{{totalNum}}）</button>
    </div>
</template>

<script>
    import Vue from 'vue'
    import {Checkbox} from 'vant';
    import {mapGetters} from 'vuex'
    import {Toast} from 'vant'

    Vue.use(Checkbox)
    export default {
        name: "CartBottom",
        data() {
            return {}
        },
        components: {},
        methods: {
            selectAll() {
                if (this.isCheckAll) {
                    this.getCartLists.forEach(item => item.checked = false)
                } else {
                    this.getCartLists.forEach(item => item.checked = true)
                }
            },
            toPay() {
                if (this.getCartLists.length === 0) {
                    Toast('请先选择商品加入购物车')
                    return
                }
                if (!this.getCartLists.filter(item => item.checked === true).length) {
                    Toast('请选择商品')
                }
            }
        },
        computed: {
            ...mapGetters(['getCartLists']),
            totalPrice() {
                return this.$store.state.cartLists.filter(item => {
                    return item.checked
                }).reduce((previousValue, item) => {
                    return previousValue + item.price * item.count
                }, 0).toFixed(2)
            },
            totalNum() {
                // return this.$store.state.cartLists.filter(item => {
                //     return item.checked
                // }).reduce((previousValue,item) => {
                //     return previousValue + item.count
                // },0)
                return this.getCartLists.filter(item => item.checked).length
            },
            isCheckAll: {
                get: function () {
                    if (this.getCartLists.length === 0) return false
                    // 使用find
                    return !this.getCartLists.find(item => !item.checked)
                    // 使用filter会遍历全部，性能可能较低
                    // return !(this.getCartLists.filter(item => !item.checked).length)
                    // 普通遍历
                    // for(let item of this.getCartLists){
                    //     if (!item,checked){
                    //         return false
                    //     }
                    // }
                    //     return true
                },
                set: function () {
                }
            }
        }
    }
</script>

<style scoped>
    #cart-bottom {
        position: absolute;
        bottom: 49px;
        height: 40px;
        width: 100%;
        display: flex;
        padding: 10px;
    }

    .checkAll {
        font-size: 16px;
    }

    .total {
        margin-left: 30px;
        font-size: 18px;
        color: orange;
    }

    .pay {
        background-color: red;
        font-size: 22px;
        /*height: 40px;*/
        /*line-height: 40px;*/
        color: white;
        position: absolute;
        right: 0;
        top: 0;
        padding: 8px;
        border-radius: 20px;
        border: none;
    }
</style>