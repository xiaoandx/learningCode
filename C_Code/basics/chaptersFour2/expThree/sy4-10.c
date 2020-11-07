/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 编程输出所有的“水仙花数”，所谓“水仙花数”是指一个3位数，
 * 其各位数字立方和等于该数本身。例如，153是水仙花数，153=13+53+33
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 17:56:15
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 18:01:07
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(){
    int i, a = 0, b = 0, c = 0;
    printf("三位数的水仙花数有: ");
    for (i = 100; i <= 999; i++){
        a = i % 10;
        b = (i / 10) % 10;
        c = i / 100;
        if (i == a * a * a + b * b * b + c * c * c){
            printf("%d  ", i);
        }
    }
    return 0;
}