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
 * @Date: 2020-11-07 18:02:42
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 18:09:14
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include "stdio.h"
int main() {
    int x, y, t, i;
    printf("输入两个整数逗号（英文）分隔: ");
    scanf("%d,%d", &x, &y);
    if (x > y) { t = x; x = y; y = t;}
    for (i=x; i>0; i--){
        if (x % i == 0 && y % i == 0){break;}
    }
    printf("%d与%d的最大公约数为：%d\n", x,y,i);
    return 0;
}