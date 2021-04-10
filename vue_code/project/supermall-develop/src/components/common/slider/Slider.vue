<template>
    <div id="slider">
        <yd-slider :autoplay="autoplay">
            <yd-slider-item v-for="(item,index) in banners" :key="index">
                <a :href="item.link">
                    <img :src="item.image || item">
                </a>
            </yd-slider-item>
        </yd-slider>
    </div>
</template>

<script>
    export default {
        name: "slider",
        props: {
            autoplay: {
                type: Number,
                default() {
                    return 0
                }
            },
            banners: {
                type: Array,
                default() {
                    return [];
                }
            }
        }
    }
</script>

<style scoped>

</style>