/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 8 输入n（不大于20）个单精度数存入一维数组，
 * 用指针变量处理数组元素的方式将其逆序存放后输出。n从键盘输入。
 * @Author: WEI.ZHOU
 * @Date: 2020-12-13 10:51:25
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0

int main() {
    int i, n;
    float *p_s, *p_e;
    float a[20], t;
    printf("input n:");
    scanf("%d", &n);
    printf("input value:");
    for (i = 0; i < n; i++)
        scanf("%f", &a[i]);
    p_s = a;
    p_e = a + i - 1;
    for (; p_s < p_e; p_s++, p_e--) {
        float t = *p_s;
        *p_s = *p_e;
        *p_e = t;
    }
    printf("after reverse:");
    for (i = 0; i < n; i++)
        printf("%5.1f", a[i]);
    return OPERATION_SUCCESS;
}