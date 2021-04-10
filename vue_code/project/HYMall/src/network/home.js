import {requestNPS} from './axios'

export const BANNER = 'banner'
export const RECOMMEND = 'recommend'

export function getHomeMultidata() {
  return requestNPS({
    url: '/home/multidata'
  })
}

export function getHomeData(type, page) {
  return requestNPS({
    url: '/home/data',
    params: {
      type,
      page
    }
  })
}
