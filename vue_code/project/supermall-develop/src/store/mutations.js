export default {
    addCartCount(state, payload) {
        payload.count++
    },
    addCartType(state, payload) {
        payload.count = 1
        payload.checked = false
        state.cartLists.push(payload)
    },
    deleteCart(state, payload) {
        state.cartLists = state.cartLists.filter(item => item.iid !== payload)
    }
}