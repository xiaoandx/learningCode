import {requestNPS} from "./request";

export function getCategoryTitle() {
    return requestNPS({
        url: '/category'
    })
}


export function getSubcategory(maitKey) {
    return requestNPS({
        url: 'subcategory',
        params: {
            maitKey
        }
    })
}
