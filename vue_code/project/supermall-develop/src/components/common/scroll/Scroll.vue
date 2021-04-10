<template>
    <div class="wrapper" ref="wrapper">
        <div class="content">
            <slot></slot>
        </div>
    </div>
</template>

<script>
    import BScroll from "@better-scroll/core"
    import ObserveDOM from '@better-scroll/observe-dom'
    import Pullup from '@better-scroll/pull-up'

    BScroll.use(ObserveDOM)
    BScroll.use(Pullup)
    export default {
        name: "Scroll",
        props: {
            probeType: {
                type: Number,
                default: 0
            },
            pullUpLoad: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                scroll: null

            }
        },
        mounted() {
            //1.创建scroll对象
            this.scroll = new BScroll(this.$refs.wrapper, {
                observeDOM: true,
                click: true,
                probeType: this.probeType,
                pullUpLoad: this.pullUpLoad
            })
            //2.监听滚动的位置，方便进行backTop
            if (this.probeType === 2 || this.probeType === 3) {
                this.scroll.on('scroll', position => {
                    this.$emit("scroll", position)
                })
            }
            //3.监听scroll是否滚到底部
            if (this.pullUpLoad) {
                this.scroll.on("pullingUp", () => {
                    this.$emit("pullingUp")
                })
            }
        },
        methods: {
            refresh() {
                this.scroll && this.scroll.refresh()
            },
            getY() {
                return this.scroll ? this.scroll.y : 0
            }
        }
    }
</script>

<style scoped>
    /*.wrapper{*/
    /*    height: 614px;*/
    /*    overflow: scroll;*/
    /*}*/
</style>