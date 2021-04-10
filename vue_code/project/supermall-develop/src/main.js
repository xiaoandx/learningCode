import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'normalize.css/normalize.css'
import YDUI from 'vue-ydui'
import 'vue-ydui/dist/ydui.px.css'
import store from "./store"
import FastClick from 'fastclick'
import VueLazyload from "vue-lazyload";
// import 'vant/lib/index.css'
// import Vant from "vant"
Vue.config.productionTip = false
Vue.use(YDUI)
FastClick.attach(document.body)
Vue.use(VueLazyload)
// Vue.use(Vant)
Vue.prototype.$bus = new Vue()
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
