/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 16:23:35
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 16:27:34
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>

int main(){
    int i, j, k, count=0;
    printf("\n");
    // 以下为三重循环
    for (i = 1; i < 5; i++) {  
        for (j = 1; j < 5; j++) {
            for (k = 1; k < 5; k++) {
                // 确保i、j、k三位互不相同  
                if (i != k && i != j && j != k) {
                    printf("%d,%d,%d\n", i, j, k);
                    count+=1;
                }
            }
        }
    }
    printf("\n\n 1、2、3、4 个数字，能组成%d 个互不相同且无重复数字的三位数",count);
}