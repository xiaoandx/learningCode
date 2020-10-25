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
 * @Date: 2020-10-25 14:56:30
 * @Version: V1.0
 * @LastEditTime: 2020-10-25 15:06:08
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(){
    int a,b;
    unsigned c,d;
    long e,f;
    a=65580;
    b=-40000;
    e=65535;
    f=65580;
    c=a;
    d=b;
    printf("%d,%d\n",a,b);
    printf("%u,%u\n",a,b);
    printf("%u,%u\n",c,d);
    c=a=e;
    d=b=f;
    printf("%d,%d\n",a,b);
    printf("%u,%u\n",c,d);
    return 0;
}