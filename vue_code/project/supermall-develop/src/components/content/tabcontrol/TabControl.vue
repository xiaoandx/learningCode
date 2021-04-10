<template>
    <div id="tab-control">
        <div v-for="(item ,index) in titles" :key="index"
             class="tab-control-item"
             :class="{active:index === currentIndex}"
             @click="changeItem(index)">
            <span class="stitle">{{item}}</span>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TabControl",
        data() {
            return {
                currentIndex: 0
            }
        },
        props: {
            titles: {
                type: Array,
                default() {
                    return []
                }
            }
        },
        methods: {
            changeItem(index) {
                this.currentIndex = index
                this.$emit("tabControlClick", index)
            }
        }
    }
</script>

<style scoped>
    #tab-control {
        display: flex;
        background-color: white;
    }

    .tab-control-item {
        flex: 1;

        text-align: center;
        font-size: 16px;
    }

    .active {
        color: hotpink;
    }

    .active span {
        padding: 5px;
        border-bottom: 3px solid hotpink;
    }
</style>