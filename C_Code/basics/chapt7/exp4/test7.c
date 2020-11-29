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
 * @Date: 2020-11-29 19:02:05
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1

void nzp(int v);

int main() {
    int a[5], i;
    printf("input 5 numbers\n");
    for (i = 0; i < 5; i++) {
        scanf("%d", &a[i]);
        nzp(a[i]);
    }
    return OPERATION_SUCCESS;
}

void nzp(int v) {
    int i = 0;
    if (v > 0)
        printf("%d \n new number: ", v);
    else
        printf("%d \n new number: ", i);
}