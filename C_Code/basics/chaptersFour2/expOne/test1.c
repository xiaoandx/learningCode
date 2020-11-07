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
 * @Date: 2020-11-07 16:02:37
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 16:04:45
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>
int main() {
    int i, s = 1;
    //因为到第十天还剩一个，所以循环9次
    for (i = 0; i < 9; i++){   
        //倒序求出每天的数量
        s = (s + 1) * 2;  
    }
    //输出结果
    printf("第一天共摘了%d多少桃子\n", s);  
    return 0;
}