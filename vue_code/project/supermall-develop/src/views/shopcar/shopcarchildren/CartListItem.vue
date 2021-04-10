<template>
    <div id="cart-list-item">
        <div class="list-item">
            <div class="checkbox">
                <van-checkbox v-model="cartListItem.checked"/>
            </div>
            <img :src="cartListItem.image" alt="" class="item-img">
            <div class="item-info">
                <div class="title">{{cartListItem.title}}</div>
                <div class="desc">{{cartListItem.desc}}</div>
                <div class="pac">
                    <div class="price">￥{{cartListItem.price}}</div>
                    <div class="count">×{{cartListItem.count}}</div>
                </div>
                <div class="delete" @click="deleteItem(cartListItem.iid)">删除</div>
            </div>
        </div>
    </div>
</template>

<script>
    import Vue from 'vue'
    import {Checkbox, CheckboxGroup} from 'vant';
    import {mapMutations} from 'vuex'

    Vue.use(Checkbox)
    Vue.use(CheckboxGroup)
    export default {
        name: "CartListItem",
        data() {
            return {}
        },
        props: {
            cartListItem: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
        methods: {
            ...mapMutations(['deleteCart']),
            deleteItem(iid) {
                this.deleteCart(iid)
            }
        },
        mounted() {
        }
    }
</script>

<style scoped>
    .checkbox {
        display: flex;
        padding-right: 7px;
    }

    .list-item {
        display: flex;
        padding: 7px;
        border-bottom: 2px solid rgb(231, 222, 222);
        padding-right: 19px;
    }

    .item-img {
        width: 24%;
        align-items: center;
        border: 8px;
        border-radius: 8px;
    }

    .item-info {
        width: 70%;
        height: 100px;
        padding-left: 10px;
    }

    .title, .desc {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        margin: 15px 0;
    }

    .title {
        font-size: 18px;
        font-weight: 600;
    }

    .desc {
        font-size: 16px;
        background-color: lightgray;
        color: gray;
    }

    .price {

        color: red;
    }

    .delete {
        font-size: 13px;
        float: right;
        margin-top: 8px;
        color: red;
        border-bottom: 1px solid;
    }

    .pac {
        display: flex;
        justify-content: space-between;
        font-size: 18px;
    }
</style>