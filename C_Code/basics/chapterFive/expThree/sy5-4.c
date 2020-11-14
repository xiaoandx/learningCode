/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:求二维数组a中的最大值和最小值
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
#define N 3
int main() {
    int i,j;
    int a[N][N]={{4,4,34},{37,3,12},{5,6,5}};
    int max = 0, min = a[0][0];
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++){
            if(a[i][j] < min){
                min = a[i][j];
            }
            if(a[i][j] > max){
                max = a[i][j];
            }
        }
    }
    printf("The max is:%d \n", max);
    printf("The min is:%d \n", min);
    return 0;
}