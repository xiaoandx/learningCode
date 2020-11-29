/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 定义一个函数：求输入的“字符串”（非汉字）是否是回文，比如  "abcdcba"是回文
 * @Author: WEI.ZHOU
 * @Date: 2020-11-28 14:27:42
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ARRAY_SIZE 10
#define ZERO 0
#define ONE 1
#define TWO 2
#define END '\0'

/**
 * @brief   判断输入字符是否为回文
 * @Date    2020-11-28 14:30:25
 * @param   char* N 字符串
 * @return  {int} 1->满足；0->不满足
 */
int isPalindrome(char* N);

int main(){
    char str[ARRAY_SIZE];
    int status;
    printf("输入非汉字的字符串 < 10 :");
    gets(str);
    status = isPalindrome(str);
    if(ZERO == status){
        printf(" %s 不是回文",str);
    }else{
        printf(" %s 是回文",str);
    } 
    return OPERATION_SUCCESS;
}

int isPalindrome(char* N) {
    int i = ZERO, j = ZERO;
    while (N[i] != END){
        i++;
    }
    for (; j <= i / TWO; j++) {
        if (N[j] == N[i - j - ONE]) {
            if (j == (i - ONE) / TWO) {
                return OPERATION_SUCCESS;
            }
        } else {
            return OPERATION_ERROR;
        }
    }
    return OPERATION_ERROR;
}
