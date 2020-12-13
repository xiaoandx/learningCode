/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 5
 * @Author: WEI.ZHOU
 * @Date: 2020-12-13 10:51:25
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0

void fun(int* s, int n1, int n2) {
    int i, j, t;
    i = n1;
    j = n2;
    while (i < j) {
        t = *(s + i);
        *(s + i) = *(s + j);
        *(s + j) = t;
        i++;
        j--;
    }
}
int main() {
    int a[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, i, *p = a;
    fun(p, 0, 3);
    fun(p, 4, 9);
    for (i = 0; i < 10; i++)
        printf("%d", *(a + i));
    printf("\n");
    return OPERATION_SUCCESS;
}