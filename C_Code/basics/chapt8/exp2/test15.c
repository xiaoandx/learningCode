/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 思考题4
 * @Author: WEI.ZHOU
 * @Date: 2020-12-13 10:51:25
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0

int f(int x, int y) {
    return x * y;
}

int main() {
    int i, j, (*fun)(int, int);  //定义指向函数的指针变量fun
    fun = f;                     //使fun指向f函数
    for (i = 1; i < 4; i++) {
        switch (i) {
            case 1:
            case 2:
                j = (*fun)(i, i + 1);
                break;  //通过指针变量调用f函数
            case 3:
                j = (*fun)(i - 1, i + 2);
                break;
        }
        printf("j=%d\n", j);
    }
    return OPERATION_SUCCESS;
}