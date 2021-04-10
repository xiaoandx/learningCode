import {debounce} from "./util";

//混入
export const mixinImgItemLoad = {
    data() {
        return {
            imgItemLoad: null,
            refresh: null
        }
    },
    mounted() {
        //1.加载图片
        this.refresh = debounce(this.$refs.scroll.refresh, 50)
        this.imgItemLoad = () => {
            this.refresh()
        }
        this.$bus.$on("imgItemLoad", this.imgItemLoad)
    }
}