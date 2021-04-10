<template>
    <div id="classifyTitle">
        <scroll class="content">
            <div class="left">
                <div v-for="(item,index) in titleLists"
                     :key="item.maitKey"
                     class="classifyTitle"
                     :class="{classifyTitleBefore : index === currentIndex}"
                     @click="getCategoryContent(item,index)">{{item.title}}
                </div>
            </div>

        </scroll>
    </div>
</template>

<script>
    import {getCategoryTitle} from '../../../network/category'
    import Scroll from "../../../components/common/scroll/Scroll";

    export default {
        name: "ClassifyTitle",
        data() {
            return {
                titleLists: [],
                currentIndex: 0
            }
        },
        components: {
            Scroll
        },
        created() {
            this.getCategoryTitle()
        },
        methods: {
            getCategoryTitle() {
                getCategoryTitle().then(res => {
                    this.titleLists = res.data.data.category.list
                    this.getCategoryContent(this.titleLists[0], 0)
                    console.log(res.data.data.category.list);
                })
            },
            getCategoryContent(item, index) {
                this.currentIndex = index
                this.$emit('getCategoryContent', item.maitKey)
            }
        },
        mounted() {
            // console.log(this.titleLists);
            // this.getCategoryContent(this.titleLists[0],0)
        }
    }
</script>

<style scoped>
    .left {
        width: 100%;
        text-align: center;
    }

    .classifyTitle {
        height: 38px;
        line-height: 38px;
        font-size: 20px;
    }

    .classifyTitleBefore {
        color: red;
        border-left: 3px solid;
        font-weight: 600;
        background-color: white;
    }

    .content {
        overflow: hidden;
        height: calc(100vh - 97px);
    }
</style>