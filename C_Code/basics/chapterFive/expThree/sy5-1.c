/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:为一维数组a中的元素赋值，并按照逆序输出
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
int main() {
    /* 定义循环变量i和一维数组a */
    int i, a[10]; 
    for (i = 0; i <= 9; i++)
        scanf("%d", &a[i]);
    for (i = 9; i >= 0; i--)           
        /* 按照逆序输出 */         
        printf("%d  ", a[i]); 
    printf("\n");

    return 0;
}
