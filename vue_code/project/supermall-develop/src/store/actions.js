export default {
    addCart(context, payload) {
        return new Promise((resolve) => {

            // 判断state.carLists中是否已经存在payload
            // 方法一：for循环
            // let oldProduct = null
            // for (let item of state.cartList) {
            //     if(item.iid === payload.iid) {
            //         oldProduct = item
            //     }
            // }
            // 方法二：find方法
            let oldProduct = context.state.cartLists.find(item => item.iid === payload.iid)
            if (oldProduct) {
                context.commit('addCartCount', oldProduct)
                resolve('添加成功，商品数量+1')
            } else {
                context.commit('addCartType', payload)
                resolve('添加成功，商品种类+1')
            }
        })
    }
}