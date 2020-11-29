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
 * @Date: 2020-11-29 17:37:32
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ZERO 0
#define ONE 1
#define TWO 2
#define LF '\n'

double fun(int m) {
    float t = 1.0;
    int i;
    for (i = 2; i <= m; i++){
        t += 1.0/i;
    }
    return t;
}

int main(){
    int m;
    printf("\nPlease enter 1 integer number:");
    scanf("%d", &m);
    printf("The result is %.5lf",fun(m));
    return OPERATION_SUCCESS;
}
