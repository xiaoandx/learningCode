/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:找二维数组a的最大元素及其下标
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
int main() {
    int a[4][4] = {{1, 2, 3, 4}, {3, 4, 5, 6}, {5, 6, 7, 8}, {7, 8, 9, 10}};
    /* max存放最大值，row、col分别存放行和列的下标 */
    int i, j, max, row, col; 
    max = a[0][0];
    for (i = 0; i < 4; i++)
        for (j = 0; j < 4; j++)
            if (max < a[i][j]) {
                max = a[i][j];
                row = i;
                col = j;
            }
    printf("max=%d,row=%d,col=%d%\n", max, row, col);
    return 0;
}