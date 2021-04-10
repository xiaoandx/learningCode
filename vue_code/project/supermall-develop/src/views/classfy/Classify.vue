<template>
    <div id="classify">
        <nav-bar class="home-nav">
            <template v-slot:center>分类</template>
        </nav-bar>
        <div class="content">
            <classify-title class="classifyTitle"
                            @getCategoryContent="getCategoryContent" />
            <classify-content class="classifyContent"
                              :content-list="contentList"
                              ref="content" />
        </div>
    </div>
</template>

<script>
    import NavBar from "../../components/common/navbar/NavBar";
    import ClassifyTitle from "./classifychildren/ClassifyTitle";
    import ClassifyContent from "./classifychildren/ClassifyContent";
    import {getSubcategory} from '../../network/category'

    export default {
        name: "Classfy",
        data() {
            return {
                contentList: []
            }
        },
        components: {
            NavBar,
            ClassifyTitle,
            ClassifyContent
        },
        mounted() {
            // getSubcategory(3627).then(res => {
            //     this.contentList = res.data.data.list
            // })
        },
        methods: {
            getCategoryContent(maitKey) {
                getSubcategory(maitKey).then(res => {
                    this.contentList = res.data.data.list
                    this.$refs.content.$emit('backTop')
                })

            }
        }
    }
</script>

<style scoped>
    .content {
        display: flex;
    }

    .classifyTitle {
        width: 30%;
    }

    .classifyContent {
        width: 70%;
    }
</style>