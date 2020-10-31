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
 * @Date: 2020-DEF_ONE0-3DEF_ONE DEF_ONE4:4DEF_ONE:27
 * @Version: VDEF_ONE.0
 * @LastEditTime: 2020-10-31 15:10:34
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>

#define INIT_STRAND_SIZE 255
#define DEF_ONE 1
#define DEF_ZERO 0

/**
 * @brief   获取星期几（根据输入单词的首字母与第二个字母进行判断）
 * @date    2020-10-31 15:07:24
 * @param   char T[]  需要进行判断的单词 
 */
void getWeek(char T[]);

int main(){
    char strs[INIT_STRAND_SIZE];
    printf("请输入单词：");
    scanf("%s",&strs);
    getWeek(strs);
}

void getWeek(char T[]){
    switch (T[DEF_ZERO]){
        case 'M':
        case 'm':
            printf("星期一\n");
            break;
        case 'T':
        case 't':
            if('u' == T[DEF_ONE] || 'U' == T[DEF_ONE]){ printf("星期二\n");}
            else if('h' == T[DEF_ONE] || 'H' == T[DEF_ONE]){printf("星期四\n");}
            else{printf("输入错误无法判断星期几\n");}
            break;
        case 'W':
        case 'w':
            printf("星期三\n");
            break;
        case 'F':
        case 'f':
            printf("星期五\n");
            break;
        case 'S':
        case 's':
            if('u' == T[DEF_ONE] || 'U' == T[DEF_ONE]){ printf("星期日\n");}
            else if('a' == T[DEF_ONE] || 'A' == T[DEF_ONE]){printf("星期六\n");}
            else{printf("输入错误无法判断星期几\n");}
            break;
        default:
            printf("输入错误无法判断星期几\n");
            break;
    }
}