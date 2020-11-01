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
 * @Date: 2020-11-01 13:44:35
 * @Version: V1.0
 * @LastEditTime: 2020-11-01 13:46:27
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(){
    int a, m = 0, n = 0, k = 0;
    scanf("%d", &a);
    switch (a) {
        case 1:
            m++;
        case 2:
        case 3:
            n++;
        case 4:
        case 5:
            k++;
    }
    printf("%d,%d,%d\n", m, n, k);
    return 0;
}