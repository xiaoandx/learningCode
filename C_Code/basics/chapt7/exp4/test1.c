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
 * @Date: 2020-11-29 11:00:35
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ZERO 0
#define ONE 1

int fun(int a);

int main(){
    int a = 3;
    fun(a);
    printf("%d\n", a);
    return OPERATION_SUCCESS;
}
int fun(int a) {
    a = a + 3;
   return a;
}