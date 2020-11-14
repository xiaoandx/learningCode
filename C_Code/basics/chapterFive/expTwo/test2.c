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
 * @Others:
 */
#include <stdio.h>
#define N 3
#define DEF_ONE 1
#define DEF_ZERO 0

int main() {
    int i, j, a[N][N], sum = DEF_ZERO;

    for (i = DEF_ZERO; i < N; i++){
        printf("请输入第%d行矩阵，数据空格分开：",i + DEF_ONE);
        for (j = DEF_ZERO; j < N; j++){
            scanf("%d", &a[i][j]);
        }
    }
        
    for (i = DEF_ZERO; i < N; i++){
        sum += a[i][i] + a[i][N - DEF_ONE - i];
    }

    printf("两对角线之和为：%d\n", sum);
    return DEF_ZERO;
}
