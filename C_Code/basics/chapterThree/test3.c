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
 * @Date: 2020-10-21 22:28:37
 * @Version: V1.0
 * @LastEditTime: 2020-10-21 22:31:24
 * @LastEditors: WEI.ZHOU
 * @Others: 
 *  1.  c1=a,c2=b
 *      c1=97,c2=98
 *  2.  c1=,c2=
 *      c1=-59,c2=-58
 *  3.  c1=a,c2=b
 *      c1=97,c2=98
 */
#include <stdio.h>
int main() {
    int c1,c2;
    c1 = 97;
    c2 = 98;
    printf("c1=%c,c2=%c\n", c1, c2);
    printf("c1=%d,c2=%d\n", c1, c2);
    return 0;
}