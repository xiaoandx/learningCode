<template>
    <div class="tab-bar-item">
        <div :style="isActiveColor" @click="changePath">
            <slot name="icon-text"></slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TabBarItem",
        props: {
            path: String,
            activeColor: {
                type: String,
                default: 'red'
            },
        },

        data() {
            return {
                // isActive:false
            }
        },
        methods: {
            changePath() {
                this.$router.push(this.path)
            }
        },
        computed: {
            isActive() {
                return this.$route.path.indexOf(this.path) !== -1
            },
            isActiveColor() {
                return this.isActive ? {color: this.activeColor} : {}
            }
        }
    }
</script>

<style scoped>
    .tab-bar-item {
        flex: 1;
        text-align: center;
        font-size: 23px;
        line-height: 2
    }
</style>