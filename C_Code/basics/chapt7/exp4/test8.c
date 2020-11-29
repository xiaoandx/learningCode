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
 * @Date: 2020-11-29 19:07:35
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <conio.h>
#include <stdio.h>
int max;
int fun(int arr[], int n) {
    int pos, i;
    max = arr[0];
    pos = 0;
    for (i = 1; i < n; i++)
        if (max < arr[i]) {
            max = arr[i];
            pos = i;
        }
    return (pos);
}
int main() {
    int a[10] = {1, 4, 2, 7, 3, 12, 5, 34, 5, 9}, n;
    n = fun(a, 10);
    printf("The max is: %d ,pos is: %d\n", max, n);
    return 0;
}