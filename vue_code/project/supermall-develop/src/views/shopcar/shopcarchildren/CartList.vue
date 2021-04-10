<template>
    <div id="cart-list" v-if="cartList.length > 0">
        <cart-list-item v-for="(item,index) in cartList"
                        :key="index"
                        :cart-list-item="item"/>
    </div>
</template>

<script>
    import CartListItem from "./CartListItem";

    export default {
        props: {
            cartList: {
                type: Array,
                default() {
                    return []
                }
            }
        },
        name: "CartList",
        components: {
            CartListItem
        },
        methods: {},
        mounted() {
        }
    }
</script>

<style scoped>

</style>