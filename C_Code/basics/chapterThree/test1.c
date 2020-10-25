/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 从键盘输入大写字母，用小写字母输出（注意：用scanf和printf输入输出）
 * @Author: WEI.ZHOU
 * @Date: 2020-10-21 22:09:30
 * @Version: V1.0
 * @LastEditTime: 2020-10-24 10:09:59
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define CHANGE_LETTER_VALUE 32

/**
 * @brief   方法二大写转小写
 * @Date    2020-10-24 10:07:35
 * @param   char T 大写字母
 * @return  {int} 小写字母整数值
 */
int getLowerCase(char T);

int main(){
    char StrLetter;
    printf("请输入一个大写字母:");
    scanf("%s",&StrLetter);
    //方法一
    printf("输入大写的 %c 的小写为：%c",StrLetter,StrLetter + CHANGE_LETTER_VALUE);
    //方法二
    //printf("输入大写的 %c 的小写为：%c",StrLetter,getLowerCase(StrLetter));
    return OPERATION_SUCCESS;
}

int getLowerCase(char T){
    return T + CHANGE_LETTER_VALUE;
}