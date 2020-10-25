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
 * @Date: 2020-10-25 15:08:39
 * @Version: V1.0
 * @LastEditTime: 2020-10-25 15:19:43
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(void) {
    int i, j;
    i = 8;
    j = 10;
    printf("%d,%d,%d,%d",i,j,i++,j++);
    return 0;
}

// int main() {
//     int i, j, m = 0, n = 0;
//     i = 8;
//     j = 10;
//     m += i++;
//     n -= --j;
//     printf("i = %d, j = %d, m = %d, n = %d",i,j,m,n);
//     return 0;
// }