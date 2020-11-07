/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 编程求 1！+2！+3！+……+20! 的值
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 17:33:49
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 18:01:44
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(){
    int i;
    long p, sum = 0;
    for(i = 1;i<=20;i++){
        p = 1;
        for(int j = 1; j<=i;j++){
            p = p * j;
        }
        sum = sum + p;
    }
    printf("1!+2!+3!+…+20 != %d\n",sum);
    return 0;
}