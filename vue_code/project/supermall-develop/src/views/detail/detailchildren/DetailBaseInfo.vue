<template>
    <div class="baseInfo" v-if="Object.keys(goods).length > 0">
        <div class="title">{{ goods.title }}</div>
        <div class="price">
            <span class="newPrice">{{ goods.newPrice }}</span>
            <span class="oldPrice">{{ goods.oldPrice }}</span>
            <span class="discount">{{ goods.discount }}</span>
        </div>
        <div class="columns">
            <span>{{goods.columns[0]}}</span>
            <span>{{goods.columns[1]}}</span>
            <span>{{goods.services[0].name}}</span>
        </div>
        <div class="services">
            <div class="servicesItem" v-for="(item,index) in goods.services" :key="index">
                <img :src="item.icon" alt="" class="icon"/>
                <span class="name">{{ item.name }}</span>
            </div>
        </div>

    </div>
</template>

<script>
    export default {
        props: {
            goods: {
                type: Object,
                default() {
                    return {};
                },
            },
        },
    };
</script>

<style scoped>
    .baseInfo {
        padding: 15px;
        border-bottom: 5px solid rgb(240, 236, 236);
    }

    .baseInfo .title {
        font-size: 18px;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
    }

    .baseInfo .price {
        height: 40px;
        line-height: 40px;
        margin: 5px 0;
    }

    .baseInfo .price .newPrice {
        font-size: 24px;
        color: #E95371;
        margin-right: 10px;
    }

    .baseInfo .price .oldPrice {
        text-decoration: line-through;
        margin-right: 10px;
        font-size: 16px;
    }

    .baseInfo .price .discount {
        position: relative;
        top: -5px;
        padding: 5px;
        background-color: hotpink;
        border-radius: 10px;
        color: #fff;
    }

    .baseInfo .columns {
        font-size: 14px;
        display: flex;
        padding-bottom: 15px;
        border-bottom: 1px solid #ccc;
    }

    .baseInfo .columns span {
        flex: 1;
    }

    .services {
        display: flex;
        flex-wrap: wrap;
    }

    .servicesItem {
        width: 50%;
        margin: 8px 0;
        height: 30px;
        line-height: 30px;
        font-size: 14px;
    }

    .servicesItem img {
        width: 16px;
        height: 16px;
        margin-right: 5px;

    }
</style>