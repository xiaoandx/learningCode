/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description: 求一个3*3矩阵两条对角线元素之和
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 12:34:03
 * @Version: V1.0
 * @Others: Running test instructions
 *          1. 需要注意的是3x3存在一个相交数，只需求和一次
 *          2. 如果修改默认3x3的矩阵为任意矩阵，可进行修改宏定义#define N 3
 */
#include <stdio.h>
#define N 3
#define DEF_ONE 1
#define DEF_ZERO 0

int main() {
    /**
     * @brief   变量说明
     *  int i, j    for循环条件变量
     *  int a[N][N] NxN的举证
     *  int sum 矩阵对角线之和
    */
    int i, j, a[N][N], sum = DEF_ZERO;

    for (i = DEF_ZERO; i < N; i++) {
        printf("请输入第%d行矩阵，数据空格分开：", i + DEF_ONE);
        for (j = DEF_ZERO; j < N; j++) {
            scanf("%d", &a[i][j]);
        }
    }

    for (i = DEF_ZERO; i < N; i++) {
        if (DEF_ZERO == N % 2) {
            sum += a[i][i] + a[i][N - DEF_ONE - i];
        } else {
            if (i == (N - 1) / 2) {
                sum += a[i][i];
            } else {
                sum += a[i][i] + a[i][N - DEF_ONE - i];
            }
        }
    }
    printf("两对角线之和为：%d\n", sum);
    return DEF_ZERO;
}
