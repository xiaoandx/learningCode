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
 * @Date: 2020-10-25 13:20:50
 * @Version: V1.0
 * @LastEditTime: 2020-10-25 13:43:13
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(){
    float f,c;
    printf("请输入华氏温度：\n");
    scanf("%f",&f);
    c = (5.0/9)*(f - 32);
    printf("%f华氏温度 = %f摄氏温度\n c = %f\n",f,c);
    return 0;
}