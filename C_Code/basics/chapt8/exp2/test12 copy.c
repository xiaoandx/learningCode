/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 思考题1
 * @Author: WEI.ZHOU
 * @Date: 2020-12-13 10:51:25
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0

int main() {
    static int a[3][2] = {{12}, {14, 16}, {1, 2}};
    int* p = a[1];  //列指针,指向a[1][0]
    printf("%d\n", *(p + 1));
    printf("%d\n", *(p + 3));
    return OPERATION_SUCCESS;
}