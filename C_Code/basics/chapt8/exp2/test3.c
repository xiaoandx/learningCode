/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 3
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
    char *p1="Speaking";
    char *p2="English";
    printf("%s\n",p1); 
    printf("%s\n",p2);
    printf("%c\n",*(p2+2));
    return OPERATION_SUCCESS;
}