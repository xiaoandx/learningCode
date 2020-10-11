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
*  Description: 判断输入的括号是否匹配成对                                                              
*  Others:   
*           测试实例：
*           1. {{}}         return true
*           2. {[()]}       return true
*           3. {[           return false 
*           3. {[()}]       return false                                                                                                                           
**********************************************************************************************************/

#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR  0
#define OPERATION_GET_VALUE_ERROR -1
#define CHANGE_VALUE_ONE 1
#define WHILE_VALUE_ZERO 0
#define WHILE_VALUE_ONE 1
#define ARRAY_NULL_VALUE '\0'
#define LEFT_SMALL_BRACKET '('
#define RIGHT_SMALL_BRACKET ')'
#define LEFT_CENTRE_BRACKET '['
#define RIGHT_CENTRE_BRACKET ']'
#define LEFT_BIG_BRACKET '{'
#define RIGHT_BIG_BRACKET '}'
#define STACK_INIT_SIZE 20
#define STACK_INCREMENT 5


// 声明定义结构体
typedef struct {
    char *base;
    char *top;
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
int push(sequenceStack &s,char data);

/**
 * @brief 遍历输出栈内的数据
 * @param sequenceStack 需要操作的数据结构变量
*/
void TraverStack(sequenceStack s);

/**
 * @brief 出栈
 * @param sequenceStack 需要操作的数据结构变量
 * @return int 返回出栈数据；返回-1则出栈失败
*/
char pop(sequenceStack &s);

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
char getStckTopValue(sequenceStack s);

/**
 * @brief 比对符号是否配对
 * @param data[] 需要比对字符数组
 * @return int 1->成功；0->不成功
*/
int charComparison(char data[]);

int main(){
    char str[100];
	cout<<"输入匹配判断的符号字符如 {()}[] :";
	cin>>str;
	cout<<str<<endl;
	cout<<"匹配结果:"<<(charComparison(str) ? "输入符号配对":"输入符号不配对")<<endl;
    return 0;
}

int initStack(sequenceStack &s){
    s.base = (char *)malloc(STACK_INIT_SIZE*sizeof(char));
	if(!s.base){return OPERATION_ERROR;}
	s.top = s.base;
	s.stackSize = STACK_INIT_SIZE;
	return OPERATION_SUCCESS;
}

int push(sequenceStack &s,char data){
    if((s.top-s.base)>=s.stackSize){
		s.base=(char *)realloc(s.base,(s.stackSize + STACK_INCREMENT)*sizeof(char));
		if(!s.base){return OPERATION_ERROR;}
		s.top = s.base + s.stackSize;
		s.stackSize += STACK_INCREMENT;
	}
	*(s.top) = data;
	s.top ++;
	return OPERATION_SUCCESS;
}

void TraverStack(sequenceStack s){
    char *p;
	p = s.base;
	while(p != s.top){
		cout<<*p<<" ";
		p++;
	}
    cout<<endl;
}

char pop(sequenceStack &s){
   if(s.top == s.base){return OPERATION_GET_VALUE_ERROR;}
   char var = *(s.top - CHANGE_VALUE_ONE);
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

char getStckTopValue(sequenceStack s){
    if(s.top == s.base){return OPERATION_GET_VALUE_ERROR;}
    return *(s.top - CHANGE_VALUE_ONE);
}

int charComparison(char data[]){
    sequenceStack s;
    char *link = data;
    char var;
    int comparisonStats = 1;
    int stats = initStack(s);
    if(WHILE_VALUE_ZERO != stats){
        while (*link != ARRAY_NULL_VALUE){
            switch (*link){
            case LEFT_SMALL_BRACKET: push(s, *link ); break;
            case LEFT_CENTRE_BRACKET: push(s, *link ); break;
            case LEFT_BIG_BRACKET: push(s, *link ); break;
            case RIGHT_SMALL_BRACKET: 
                var = getStckTopValue(s);
                if(stackEmpty(s) != WHILE_VALUE_ONE && var == LEFT_SMALL_BRACKET){ pop(s);
                }else{ comparisonStats = 0; break; } 
                break;
            case RIGHT_CENTRE_BRACKET: 
                var = getStckTopValue(s);
                if(stackEmpty(s) != WHILE_VALUE_ONE && var == LEFT_CENTRE_BRACKET){ pop(s);
                }else{ comparisonStats = 0; break; } 
                break;
            case RIGHT_BIG_BRACKET: 
                var = getStckTopValue(s);
                if(stackEmpty(s) != WHILE_VALUE_ONE && var == LEFT_BIG_BRACKET){ pop(s);
                }else{ comparisonStats = 0; break; } 
                break;
            default:
                comparisonStats = 0;
                break;
            } 
            link += CHANGE_VALUE_ONE;
        }
    }else{ return OPERATION_ERROR;}
    if(WHILE_VALUE_ONE == comparisonStats && stackEmpty(s)){ return OPERATION_SUCCESS; }
    return OPERATION_ERROR;
}
