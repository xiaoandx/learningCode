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
 * @Date: 2020-12-16 10:37:01
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <iostream>
#include <string.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ONE 1
#define TWO 2
#define ZERO 0
#define LF '\n'
#define END '\0'
#define N 80

/**
 * @brief   输入字符函数
 * @Date: 2020-12-16 11:23:42
 * @param   char *T 保存输入字符的地址
 */
void inputStr(char *T);

/**
 * @brief   复制输入字符中奇数位置字符得到新字符
 * @Date: 2020-12-16 11:24:10
 * @param   char *T 输入字符地址
 * @param   char *V 保存新字符地址
 * @return  {int} 1->success; 0->error
 */
int copyStringOddNumber(char *T, char *V);

/**
 * @brief   转换小写为大写
 * @Date:   2020-12-16 11:25:35
 * @param   char *T 需要转换的字符地址
 * @return {int} 1->success; 0->error
 */
int letterConversion(char *T);

/**
 * @brief   获取指定位置的字符输出
 * @Date: 2020-12-16 11:26:11
 * @param   char *T 需要获取的字符地址
 * @param   int pos 起始位置
 * @param   int end 截止位置
 * @return  {int} 1->success; 0->error
 */
int getString(char *T, int pos, int end);

/**
 * @brief   输出字符串
 * @Date: 2020-12-16 11:27:33
 * @param   char *T 需要输出的字符地址
 */
void output(char *T);

int main(){
    char str_one[N];
    char str_Two[N];
    inputStr(str_one);
    std::cout<<"输入的字符串为：";
    output(str_one);
    std::cout<<"将输入的字符串奇数字符复制到str2中，得到str2：";
    copyStringOddNumber(str_one, str_Two);
    output(str_Two);
    std::cout<<"将str2中的小写字母全部转大写：";
    letterConversion(str_Two);
    output(str_Two);
    std::cout<<"获取输入字符中的3-7位置的字符为：";
    getString(str_one,3,7);
    return OPERATION_SUCCESS;
}

void inputStr(char *T){
    std::cout<<"input string, Tip:lenght<80 :";
    char str;
    int i =ZERO;
    while ((str = getchar()) != '\n'){
        T[i++] = str;
    }
}

int copyStringOddNumber(char *T, char *V){
    int i, j=ZERO;
    for(i = ZERO;T[i] != END;i++){
        if(i%TWO != ZERO){
            V[j++] = T[i];
        }
    }
    V[j] = END;
    return OPERATION_SUCCESS;
}

int letterConversion(char* T) {
    int i;
    for (i = ZERO; T[i] != END; i++) {
        if (T[i] >= 'a' && T[i] <= 'z') {
            T[i] -= 32;
        }
    }
    return OPERATION_SUCCESS;
}

void output(char* T) {
    int i;
    for (i = ZERO; T[i] != END; i++) {
        std::cout<<T[i];
    }
    std::cout<<LF;
}

int getString(char *T, int pos, int end){
    if(pos<ZERO ||pos>=N ||end<ZERO ||end>=N){
        return OPERATION_ERROR;
    }
    int i;
    for (i = (pos-ONE); i <= end; i++) {
        std::cout<<T[i]<<"";
    }
    return OPERATION_SUCCESS;
}