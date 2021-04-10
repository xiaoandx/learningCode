import Vue from 'vue'
import Vuex from 'vuex'

import mutations from './mutations'
import actions from "./actions"
import getters from "./getters";

Vue.use(Vuex)

const state = {
    cartLists: [
        {
            checked: false,
            count: 1,
            desc: "2018秋季新款韩版百搭格子长袖衬衫+前短后长针织气质开衫外套+高腰直筒九分牛仔裤三件套装",
            iid: "1m70y5k",
            image: "//s11.mogucdn.com/mlcdn/c45406/180808_600abce0g8dc8i4f6ic7k27i7837l_640x960.jpg",
            price: "59.00",
            title: "2018秋季新款韩版百搭格子长袖衬衫+前短后长针织气质开衫外套+高腰直筒九分牛仔裤三件套装"
        },
        {
            checked: false,
            count: 1,
            desc: "你的运动套装，也可以一起承包了~棉混纺的连帽卫衣，版型虽宽松，但因为有罗纹收口，穿起来立体挺括，能遮住多余的腰腹和双臂肉肉，展现青春活力.下半身搭配浅色直筒牛仔裤，向来是竹竿腿的助攻，翻边上的亮粉字母数字，和上衣一个调调，闪闪地时尚别致.清清爽爽的运动风其实也很拉好感der~",
            iid: "1m745k0",
            image: "//s11.mogucdn.com/mlcdn/c45406/180811_1k5hfa6d803575df3lkb6j67l5j3c_640x960.jpg",
            price: "68.00",
            title: "2018秋季新款韩版女装字母印花宽松连帽休闲卫衣搭配松紧腰九分牛仔裤两件套女时尚运动套装潮"
        }
    ],
    profileInfo: [
        {
            title: '我的余额',
            num: '0.00',
            unit: '元'
        },
        {
            title: '我的优惠券',
            num: '0',
            unit: '张'
        },
        {
            title: '我的积分',
            num: '0',
            unit: '分'
        }
    ]
}

const store = new Vuex.Store({
    state,
    mutations,
    actions,
    getters

})

export default store