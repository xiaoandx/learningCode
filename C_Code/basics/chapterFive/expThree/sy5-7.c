/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:求一个4×4矩阵的主对角线元素之和
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
int main() {
    int a[4][4] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {3, 9, 10, 2}, {4, 2, 9, 6}};
    int i, sum = 0;
    for (i = 0; i < 4; i++)
    /*把对角线元素的和放在变量sum中 */
        sum += a[i][i]; 
    printf("sum=%d\n", sum);
    return DEF_ZERO;
}
