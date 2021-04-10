/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 
 * @Author: WEI.ZHOU
 * @Date: 2021-04-10 13:32:08
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
import {requestNPS} from './axios'


export function getCategory() {
  return requestNPS({
    url: '/category'
  })
}

export function getSubcategory(maitKey) {
  return requestNPS({
    url: '/subcategory',
    params: {
      maitKey
    }
  })
}

export function getCategoryDetail(miniWallkey, type) {
  return requestNPS({
    url: '/subcategory/detail',
    params: {
      miniWallkey,
      type
    }
  })
}
