

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
 * @Date: 2020-11-01 13:45:13
 * @Version: V1.0
 * @LastEditTime: 2020-11-01 15:41:44
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include "stdio.h"
int main() {
    float x, y;
    //定义变量;
    scanf("%f", &x);
    if(x<1){
        y=x;
    }else if(x>=1 && x<10){
        y=2*x-1;
    }else{
        y=3*x-11;
    }
    printf("y=%f\n", y);
    return 0;
}