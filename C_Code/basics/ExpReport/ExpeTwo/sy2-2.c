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
 * @Date: 2020-10-25 13:52:43
 * @Version: V1.0
 * @LastEditTime: 2020-10-25 13:59:26
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(){
    float p0 = 1000, r1 = 0.0036, r2 = 0.0225, r3 = 0.0198;
    float p1,p2,p3;
    p1 = p0 * (1 + r1);
    p2 = p0 * (1 + r2);
    p3 = p0 * (1 + r3/2) * (1 + r3/2);
    printf("%d\n%d\n%d\n%d\n",p0,p1,p2,p3);
    return 0;
}