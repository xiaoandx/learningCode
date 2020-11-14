/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:字符串连接
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 * @Others: 自定义方法
 */
#include <stdio.h>
#include <string.h>
#define N 80

/**
 * @brief   合并字符串
 * @Date    2020-11-14 14:56:35
 * @param   char T[] 被添加的字符串
 * @param   char V[] 复制的字符串
 */
void appenString(char T[], char V[]);

int main() {
    char str1[N] = "This Is a ", str2[N] = "c Program";
    printf("String1 is: %s\n", str1);
    printf("String2 is: %s\n", str2);
    appenString(str1,str2);
    printf("Result is: %s\n", str1);
    return 1;
}

void appenString(char T[], char V[]){
    int Tlen = strlen(T), Vlen = strlen(V);
    for(int i = 0; i < Vlen; i++,Tlen++){
        T[Tlen] = V[i];
    } 
}
