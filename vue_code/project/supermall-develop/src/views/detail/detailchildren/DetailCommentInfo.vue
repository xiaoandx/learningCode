<template>
    <div id="detailcommentinfo">
        <div class="comment" v-if="Object.keys(commentInfo).length > 0">
            <div class="title">
                <span>用户评价</span>
                <span>更多</span>
            </div>
            <div class="userInfo">
                <img :src="commentInfo.user.avatar" alt=""/>
                <span>{{ commentInfo.user.uname }}</span>
            </div>
            <div class="content">{{ commentInfo.content }}</div>
            <div class="commentDetail">
                <span>{{ commentInfo.created | showTime }}</span>
                <span>{{ commentInfo.style }}</span>
            </div>
            <div class="imageShow" v-if="commentInfo.images">
                <img :src="item" alt="" v-for="(item,index) in commentInfo.images" :key="index"/>
            </div>
        </div>
        <div v-else class="noComment">暂无评论</div>
    </div>
</template>

<script>
    import {dateFormat} from "../../../common/util"

    export default {
        name: "DetailCommentInfo",
        props: {
            commentInfo: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
        filters: {
            showTime(value) {
                const date = new Date(value * 1000)
                return dateFormat(date, "yyyy-MM-dd hh:mm")
            }
        }
    }
</script>

<style scoped>
    .comment,
    .noComment {
        padding: 15px;
        border-bottom: 3px solid rgb(236, 232, 232);
        margin-bottom: 15px;
    }

    .title {
        display: flex;
        padding: 0 10px;
        justify-content: space-between;
        align-items: center;
        height: 60px;
        border-bottom: 2px solid #ccc;
    }

    .userInfo {
        display: flex;
        align-items: center;
        height: 50px;
        margin-top: 10px;
    }

    .userInfo img {
        height: 50px;
        width: 50px;
        border-radius: 50%;
        margin-right: 15px;
    }

    .content {
        font-size: 18px;
        margin: 10px 0;
    }

    .commentDateil {
        margin: 10px 0;
    }

    .commentDetail span:nth-child(1) {
        margin-right: 15px;
    }

    .commentDetail span {
        font-size: 14px;
        color: gray;
    }

    .imageShow {
        height: 100px;
    }

    .imageShow img {
        width: 100px;
        height: 100px;
    }
</style>