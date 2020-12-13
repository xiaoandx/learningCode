/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 1.交换a b数值(通过指针)
 * @Author: WEI.ZHOU
 * @Date: 2020-12-13 10:51:25
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0

void fun(int* a, int* b) {
    int k;
    k = *a;
    *a = *b;
    *b = k;
}

int main(){
    int a = 3, b = 6, *x = &a, *y = &b;
    fun(x, y);
    printf("%d,%d\n", a, b);
    return OPERATION_SUCCESS;
}
