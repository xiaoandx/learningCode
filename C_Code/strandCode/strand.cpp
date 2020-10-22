/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 串的定义及操作
 * @Author: WEI.ZHOU
 * @Date: 2020-10-22 16:47:55
 * @Version: V1.0
 * @LastEditTime: 2020-10-22 18:20:37
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <iostream>
#include <string.h>
using namespace std;

#define INIT_STRAND_SIZE 255
#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define VALUE_ZERO 0
#define VALUE_NEGATIVE -1
#define CHANGE_VALUE_ONE 1
#define DEF_ONE 1
#define DEF_ZERO 0

typedef unsigned char Strings[INIT_STRAND_SIZE + CHANGE_VALUE_ONE];

/**
 * @brief   初始化字符串
 * @Date    2020-10-22 16:53:10
 * @param   Strings T 需要进行初始化的串变量
 * @param   char str[] 字符串常量
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int strAssign(Strings T,char str[]);

/**
 * @brief   输出串
 * @Date    2020-10-22 17:00:50
 * @param   Strings T 需要进行操作的串变量
 */
void strPrint(Strings T);

/**
 * @brief   复制串
 * @Date    2020-10-22 17:33:19
 * @param   Strings T 需要进行复制源串
 * @param   Strings V 给赋值的串
 */
void strCopy(Strings T,Strings V);

/**
 * @brief   串比较大小
 * @brief   比较串大小 1.先比较串的长度（T.length > S.length -> T>S）;2.在相同长度的情况下比较串的单一字符串
 * @Date    2020-10-22 17:39:48
 * @param   Strings T 需要进行比较的串
 * @param   Strings S 需要进行比较的串
 * @return  {int}>0  T>S; {int}<0 T<S; {int}=0 T=S
 */
int strCompare(Strings T,Strings S);

/**
 * @brief   合并两个串到新串
 * @Date    2020-10-22 18:01:59
 * @param   Strings T 合并后新串
 * @param   Strings S 需要进行合并的串
 * @param   Strings S2 需要进行合并的串
 * @return  {int} 返回操作状态，1->全部合并成功；0->部分合并
 */
int strConcat(Strings T, Strings S, Strings S2);

/**
 * @brief   从指定位置截取指定长度的串
 * @Date    2020-10-22 18:12:47
 * @param   Strings T 截取后返回的新串
 * @param   Strings S 被截取的串
 * @param   int origin 截取起始点
 * @param   int len 截取长度
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int subString(Strings T, Strings S,int origin, int len);

int main(){
    Strings s, s2, s3, s4;
    strAssign(s, (char*)"zhouwei");
    strAssign(s2, (char*)"zhouwei");
    cout<<"comp:"<<strCompare(s,s2)<<endl;;
    strConcat(s3, s, s2);
    subString(s4,s,2,3);
    return OPERATION_SUCCESS;
}

int strAssign(Strings T,char str[]){
    int countStr = strlen(str);
    if(countStr > INIT_STRAND_SIZE){ return OPERATION_ERROR;    }
    T[0] = countStr;
    for(int i = DEF_ONE; i<= T[DEF_ZERO]; i++){
        T[i] = str[i-DEF_ONE];
    }
    return OPERATION_SUCCESS;
}

void strPrint(Strings T){
    for(int i = DEF_ONE ; i <= T[DEF_ZERO]; i++){
        cout<<T[i];
    }
    cout<<endl;
}

void strCopy(Strings T,Strings V){
    V[DEF_ZERO] = T[DEF_ZERO];
    for(int i = DEF_ONE;i <= T[DEF_ZERO];i++){
        V[i] = T[i];
    }
}

int strCompare(Strings T,Strings S){
    if(T[DEF_ZERO] > S[DEF_ZERO]){ 
        return OPERATION_SUCCESS;
    }else if(T[DEF_ZERO] < S[DEF_ZERO]){
        return VALUE_NEGATIVE;
    }
    
    for(int i = DEF_ONE;i<=T[DEF_ZERO]&&i<=S[DEF_ZERO];i++){
        if(T[i] != S[i]){
            return T[i]-S[i];
        }
    }
    return VALUE_ZERO;
}

int strConcat(Strings T, Strings S, Strings S2){
    if((S[DEF_ZERO] + S2[DEF_ZERO]) <= INIT_STRAND_SIZE){
        for(int i=DEF_ONE;i<=S[DEF_ZERO];i++){
            T[i] = S[i];
        }
	    for(int i=DEF_ONE;i<=S2[DEF_ZERO];i++){
            T[i + S[DEF_ZERO]] = S2[i];
        }
	    T[DEF_ZERO] = S1[DEF_ZERO] + S2[DEF_ZERO];
        return OPERATION_SUCCESS;
    }else{
        for(int i=DEF_ONE;i<=S[DEF_ZERO];i++){
            T[i] = S[i];
        }

        for(int i=DEF_ONE;i<=INIT_STRAND_SIZE - S[DEF_ZERO];i++){
            T[i + S1[DEF_ZERO]] = S2[i];
        }
		T[DEF_ZERO] = INIT_STRAND_SIZE;
        return OPERATION_ERROR;
    }
}

int subString(Strings T, Strings S,int origin, int len){
    if(origin < 1 || origin > S[DEF_ZERO] || (origin + len - DEF_ONE) > S[DEF_ZERO]){
        return OPERATION_ERROR;
    }
    for(int i = origin; i < (origin + len); i++){
        T[i - origin + DEF_ONE] = S[i];
    }
    T[DEF_ZERO] = len;
    return OPERATION_SUCCESS;
}