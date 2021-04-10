<template>
    <div class="shopInfo">
        <div class="shopDetail">
            <img :src="shop.logo" alt=""/>
            <span>{{ shop.name }}</span>
        </div>
        <div class="shopMessge">
            <div class="number">
                <div class="sells">
                    <p>{{ shop.sells }}</p>
                    <p>总销量</p>
                </div>
                <div class="count">
                    <p>{{ shop.goodsCount }}</p>
                    <p>全部宝贝</p>
                </div>
            </div>
            <div class="assess">
                <div
                        v-for="(item, index) in shop.score"
                        :key="index"
                        class="assessItem"
                >
                    <span>{{ item.name }}</span>
                    <span :class="{ low: item.isBetter == false }">{{ item.score }}</span>
                    <span :class="{ lower: item.isBetter == false }">{{
            item.isBetter ? "高" : "低"
          }}</span>
                </div>
            </div>
        </div>
        <div class="btn">进店逛逛</div>
    </div>
</template>

<script>
    export default {
        props: {
            shop: {
                type: Object,
                default() {
                    return {};
                },
            },
        },
    };
</script>

<style scoped>
    .shopInfo {
        padding: 15px;
    }

    .shopDetail {
        display: flex;
        align-items: center;
        height: 50px;
        margin-bottom: 10px;
    }

    .shopDetail img {
        height: 50px;
        width: 50px;
        border-radius: 50%;
        margin-right: 30px;
    }

    .shopDetail span {
        flex: 1;
        font-size: 22px;
    }

    .shopMessge {
        display: flex;
    }

    .number {
        flex: 1;
        display: flex;
        justify-content: space-evenly;
        text-align: center;
        border-right: 1px solid #ccc;
    }

    .number .sells p:nth-child(1),
    .number .count p:nth-child(1) {
        font-size: 22px;
        margin-bottom: 20px;
    }

    .number .sells p:nth-child(2),
    .number .count p:nth-child(2) {
        font-size: 14px;
    }

    .assess {
        flex: 1;
        font-size: 14px;
    }

    .assessItem {
        display: flex;
        margin-bottom: 15px;
    }

    .assessItem span:nth-child(1) {
        flex: 5;
        padding-left: 10px;
    }

    .assessItem span:nth-child(2) {
        flex: 3;
        color: #E95371;
    }

    .assessItem span:nth-child(3) {
        flex: 1;
        background-color: #E95371;
        text-align: center;
        color: #fff;
    }

    .assess .assessItem .low {
        color: green;
    }

    .assess .assessItem .lower {
        background-color: green;
    }

    .btn {
        width: 150px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        color: #fff;
        background-color: rgb(216, 208, 208);
        margin: 0 auto;
        margin-top: 20px;
        border-radius: 10px;
    }
</style>