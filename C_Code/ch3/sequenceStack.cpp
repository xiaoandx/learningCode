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
*  Description: 顺序栈及其操作                                                              
*  Others:                                                                                                                                                    
**********************************************************************************************************/

#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define OPERATION_GET_VALUE_ERROR -1
#define CHANGE_VALUE_ONE 1
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
 * @brief 遍历输出栈内的数据
 * @param sequenceStack 需要操作的数据结构变量
*/
void traverStack(sequenceStack s);

/**
 * @brief 出栈
 * @param sequenceStack 需要操作的数据结构变量
 * @return int 返回出栈数据；返回-1则出栈失败
*/
int pop(sequenceStack &s);

/**
 * @brief 获取栈的长度
 * @param sequenceStack 需要操作的数据结构变量
 * @return int 返回栈的长度
*/
int stackLength(sequenceStack s);

/**
 * @brief 判断栈是否为空
 * @param sequenceStack 需要操作的数据结构变量
 * @return int 1->空；0->不为空
*/
int stackEmpty(sequenceStack s);

/**
 * @brief 获取栈顶的数据
 * @param sequenceStack 需要操作的数据结构变量
 * @return int 栈顶的数据（返回-1则查询失败）
*/
int getStckTopValue(sequenceStack s);

int main(){
    sequenceStack s;
    initStack(s);
    push(s,12);
    traverStack(s);
    return 0;
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

void traverStack(sequenceStack s){
    int *p;
	p = s.base;
	while(p != s.top){
		cout<<*p<<" ";
		p++;
	}
    cout<<endl;
}

int pop(sequenceStack &s){
   if(s.top == s.base){return OPERATION_GET_VALUE_ERROR;}
   int var = *(s.top - CHANGE_VALUE_ONE);
   s.top -= CHANGE_VALUE_ONE;
   return var;	
}

int stackLength(sequenceStack s){
    return s.top - s.base;
}

int stackEmpty(sequenceStack s){
    if(s.top == s.base){return OPERATION_SUCCESS;}
	return OPERATION_ERROR;
}

int getStckTopValue(sequenceStack s){
    if(s.top == s.base){return OPERATION_GET_VALUE_ERROR;}
    return *(s.top - CHANGE_VALUE_ONE);
}
