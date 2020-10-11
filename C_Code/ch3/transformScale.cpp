/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <xiaoandx@gmail.com>                                                 
*                                                                                                        
*  FileName:  sequenceStack                                                                         
*  Author:  WEI.ZHOU                                                                                     
*  Version:  1.0                                                                                         
*  Date:  2020-10-10                                                                                     
*  Description: 进制转换                                                              
*  Others:      代码测试：1348 转为8进制 取得结果应该为：2504                                                                                                                                       
**********************************************************************************************************/

#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define OPERATION_GET_VALUE_ERROR -1
#define CHANGE_VALUE_ONE 1
#define WHILE_VALUE_ZERO 0
#define STACK_INIT_SIZE 20
#define STACK_INCREMENT 5

// 声明定义结构体
typedef struct {
    int *base;
    int *top;
    int stackSize;
}sequenceStack;

/**
 * @brief 初始化栈
 * @param sequenceStack 需要初始化的结构体变量
 * @return int 返回操作状态，1成功；0失败
*/
int initStack(sequenceStack &s);

/**
 * @brief 入栈
 * @param sequenceStack 需要操作的数据结构变量
 * @param int 入栈的数据
 * @return int 返回操作状态，1成功；0失败
*/
int push(sequenceStack &s,int data);

/**
 * @brief 出栈
 * @param sequenceStack 需要操作的数据结构变量
 * @return int 返回出栈数据；返回-1则出栈失败
*/
int pop(sequenceStack &s);

/**
 * @brief 判断栈是否为空
 * @param sequenceStack 需要操作的数据结构变量
 * @return int 1->空；0->不为空
*/
int stackEmpty(sequenceStack s);

/**
 * @brief 进制转换
 * @param data 需要转换的十进制数
 * @param N 需要转换的进制为
 * @return int 1->成功；0->失败
*/
int conversion(int data, int N);

int main(){
    conversion(1348,8);
}

int initStack(sequenceStack &s){
    s.base = (int *)malloc(STACK_INIT_SIZE*sizeof(int));
	if(!s.base){return OPERATION_ERROR;}
	s.top = s.base;
	s.stackSize = STACK_INIT_SIZE;
	return OPERATION_SUCCESS;
}

int push(sequenceStack &s,int data){
    if((s.top-s.base)>=s.stackSize){
		s.base=(int *)realloc(s.base,(s.stackSize + STACK_INCREMENT)*sizeof(int));
		if(!s.base){return OPERATION_ERROR;}
		s.top = s.base + s.stackSize;
		s.stackSize += STACK_INCREMENT;
	}
	*(s.top) = data;
	s.top ++;
	return OPERATION_SUCCESS;
}

int pop(sequenceStack &s){
    if(s.top == s.base){return OPERATION_GET_VALUE_ERROR;}
    int var = *(s.top - CHANGE_VALUE_ONE);
    s.top -= CHANGE_VALUE_ONE;
    return var;	
}

int stackEmpty(sequenceStack s){
    if(s.top == s.base){return OPERATION_SUCCESS;}
	return OPERATION_ERROR;
}

int conversion(int data, int N){
    int dividend = data;
    sequenceStack s;
    int stats = initStack(s);
    if(WHILE_VALUE_ZERO != stats){
        while (dividend != WHILE_VALUE_ZERO){
            push(s, dividend % N);
            dividend /= N;
        }
    }else{ return OPERATION_ERROR;}

    while (!stackEmpty(s)){cout<<pop(s);}
    cout<<endl;    
    return OPERATION_SUCCESS;
}
