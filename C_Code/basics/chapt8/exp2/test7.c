/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 7 计算平均值
 * @Author: WEI.ZHOU
 * @Date: 2020-12-13 10:51:25
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0

float average(int* pa, int n) {
    int i;
    float avg = 0.0;
    for (i = 0; i < n; i++)
        avg = avg + *(pa + i);
    avg = avg / n;
    return avg;
}

int main() {
    int i, a[5] = {2, 4, 6, 8, 10};
    float m;
    m = average(a, 5);
    printf("m=%f\n", m);
    return OPERATION_SUCCESS;
}