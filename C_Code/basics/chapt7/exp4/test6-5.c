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
 * @Date: 2020-11-29 18:45:21
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ARRAY_SIZE 20
#define ZERO 0
#define ONE 1
#define TWO 2
#define LF '\n'

/**
 * @brief   转换后字符串的长度
 */
int N = ZERO;

/**
 * @brief   字符串规则转换
 * @Date    2020-11-29 18:58:44
 * @param   char str1[] 主字符串
 * @param   char str2[] 转换得到的新字符串
 */
void  transformation(char str1[] , char str2[]);

int main(){
    char str1[ARRAY_SIZE] = "This Is a c Program";
    char str2[ARRAY_SIZE];
    transformation(str1,str2);
    int i;
    for(i=ZERO; i<N; i++){
    	printf("%c",str2[i]);

    }
    return OPERATION_SUCCESS;
}

void  transformation(char str1[] , char str2[]){
    int i;
    for(i = 0;i<ARRAY_SIZE;i++){
        if(((i+ONE) % TWO != ZERO)){
            str2[N++] = str1[i];
        }
    }
}