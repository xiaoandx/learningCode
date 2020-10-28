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
 * @LastEditTime: 2020-10-28 21:45:18
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <iostream>
#include <string.h>

#define INIT_STRAND_SIZE 255
#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define VALUE_NEGATIVE -1
#define DEF_ONE 1
#define DEF_ZERO 0
#define LF '\n'

typedef unsigned char Strings[INIT_STRAND_SIZE + DEF_ONE];

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

/**
 * @brief   判断串是否为空
 * @Date    2020-10-22 18:35:55
 * @param   Strings T 需要进行判断的串
 * @return  {int} 返回操作状态，1->不为空；0->为空
 */
int strEmpty(Strings T);

/**
 * @brief   清空串
 * @Date    2020-10-22 18:40:36
 * @param   Strings T 需要进行操作的串
 */
void strClear(Strings T);

/**
 * @brief   获取串的长度
 * @Date    2020-10-22 18:42:23
 * @param   Strings T 需要进行操作的串
 * @return  {int} 串的长度
 */
int getStrLength(Strings T);

/**
 * @brief   在主串T中寻找V串相同的内容，并返回第一次出现的位置
 * @Date    2020-10-26 14:26:19
 * @param   Strings T 需要进行操作的串（主串）
 * @param   int origin 需要进行比对的起始位置
 * @param   Strings V 需要进行比对的串
 * @return  {int} 返回第一次出现的位置（无则返回0）
 */
int strIndex(Strings T, int origin, Strings V);

/**
 * @brief   插入字符串
 * @Date    2020-10-26 22:14:20
 * @param   Strings T 需要进行插入的串
 * @param   int origin 需要进行插入的起始位置
 * @param   Strings V 具体插入的字符串
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int strInsert(Strings T, int origin, Strings V);

/**
 * @brief   字符串删除指定位置长度字符
 * @Date    2020-10-26 22:29:33
 * @param   Strings T 需要进行删除的串
 * @param   int origin 截取起始点
 * @param   int len 删除长度
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int strDelete(Strings T, int origin, int len);

/**
 * @brief   获取KMP模式匹配中需要生成的next匹配数组
 * @Date    2020-10-27 11:23:46
 * @param   Strings T 模式进行匹配的串
 * @param   int *next 存放模式匹配的位置数组
 */
void getNext(Strings T, int *next);

/**
 * @brief   字符串指定位置匹配查找(KMP)
 * @Date    2020-10-27 19:51:10
 * @param   Strings T 需要进行操作的串（主串）
 * @param   Strings V 需要进行比对的串
 * @param   int origin 需要进行比对的起始位置
 * @return  {int} 返回第一次出现的位置（无则返回0）
 */
int strIndexKmp(Strings S,int origin, Strings T);

int main(){
    Strings s, s2, s3, s4, s5;
    // cout<<"初始化s='zhouwei',s2='wei'"<<endl;
    // cout<<"初始化成功.................................."<<endl;
    strAssign(s, (char*)"zhouoowei");
    strAssign(s2, (char*)"wei");
    // cout<<endl;
    // cout<<"s=";
    // strPrint(s);
    // cout<<"s2=";
    // strPrint(s2);
    // cout<<endl;
    // cout<<"复制s到s3"<<endl;
    strCopy(s,s3);
    std::cout<<"s3=";
    strPrint(s3);
    // cout<<endl;
    // cout<<"s与s2的大小为（大于0 s>s2）：";
    // cout<<"comp:"<<strCompare(s,s2)<<endl;
    // cout<<endl;
    // cout<<"将s与s2合并的到s4：";
    // strConcat(s4,s,s2);
    // strPrint(s4);
    // cout<<endl;
    // cout<<"截取s的2起点截3个字符得到s5：";
    // subString(s5,s,2,3);
    // strPrint(s5);
    // cout<<endl;
    // cout<<"s是否为空："<<strEmpty(s)<<endl;
    // cout<<endl;
    // cout<<"s是的长度为："<<getStrLength(s)<<endl;
    // cout<<endl;
    // cout<<"在主串s中寻找s2串相同的内容，并返回第一次出现的位置"<<strIndex(s,s2,2)<<endl;
    // cout<<endl;
    // cout<<"清空s....................."<<endl;
    // strClear(s);
    // cout<<"s是的长度为："<<getStrLength(s)<<endl;
    // int next[4];
    // getNext(s2,next);
    //std::cout<<strIndex(s,2,s2)<<LF;
    //std::cout<<strIndexKmp(s,2,s2)<<LF;
    return OPERATION_SUCCESS;
}

int strAssign(Strings T,char str[]){
    int countStr = strlen(str);
    if(countStr > INIT_STRAND_SIZE){ return OPERATION_ERROR;    }
    T[DEF_ZERO] = countStr;
    for(int i = DEF_ONE; i<= T[DEF_ZERO]; i++){
        T[i] = str[i - DEF_ONE];
    }
    return OPERATION_SUCCESS;
}

void strPrint(Strings T){
    for(int i = DEF_ONE ; i <= T[DEF_ZERO]; i++){
        std::cout<<T[i];
    }
    std::cout<<LF;
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
    return DEF_ZERO;
}

int strConcat(Strings T, Strings S, Strings S2){
    if((S[DEF_ZERO] + S2[DEF_ZERO]) <= INIT_STRAND_SIZE){
        for(int i=DEF_ONE;i<=S[DEF_ZERO];i++){
            T[i] = S[i];
        }
	    for(int i=DEF_ONE;i<=S2[DEF_ZERO];i++){
            T[i + S[DEF_ZERO]] = S2[i];
        }
	    T[DEF_ZERO] = S[DEF_ZERO] + S2[DEF_ZERO];
        return OPERATION_SUCCESS;
    }else{
        for(int i=DEF_ONE;i<=S[DEF_ZERO];i++){
            T[i] = S[i];
        }

        for(int i=DEF_ONE;i<=INIT_STRAND_SIZE - S[DEF_ZERO];i++){
            T[i + S[DEF_ZERO]] = S2[i];
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

int strEmpty(Strings T){
    if(DEF_ZERO < T[DEF_ZERO]){ return OPERATION_SUCCESS;}
    return OPERATION_ERROR;
}

void strClear(Strings T){ T[DEF_ZERO] = DEF_ZERO; }

int getStrLength(Strings T){ return T[DEF_ZERO]; }

int strIndex(Strings T, int origin, Strings V){
    if(T[DEF_ZERO] < V[DEF_ZERO]){ return OPERATION_ERROR;}
    if(origin > T[DEF_ZERO] || origin < DEF_ONE){  return OPERATION_ERROR;}
    int i = origin, j = DEF_ONE;
    while(i <= T[DEF_ZERO] && j <= V[DEF_ZERO]){
        if(T[i] == V[j]){
            i += DEF_ONE;
            j += DEF_ONE;
        }else{
            i = i - j + (DEF_ONE + DEF_ONE);
            j = DEF_ONE;
        }
    }
    if(j >= V[DEF_ZERO]){
        return i - V[DEF_ZERO];
    }
    return OPERATION_ERROR;
}

int strInsert(Strings T, int origin, Strings V){
    if(DEF_ONE > origin || \
        origin > T[DEF_ZERO] || \
        (T[DEF_ZERO] + V[DEF_ZERO]) > INIT_STRAND_SIZE){ return OPERATION_ERROR;}
    // 移动需要插入的串，留出插入字符串的长度
    for(int i = T[DEF_ZERO];i>=origin;i--){
        T[i + V[DEF_ZERO]] = T[i];
    }
    //插入操作
    for(int i = origin;i<(origin+V[DEF_ZERO]-DEF_ONE);i++){
        T[i] = V[i - origin + DEF_ONE];
    }
    T[DEF_ZERO] += V[DEF_ZERO];
    return OPERATION_SUCCESS;
}

int strDelete(Strings T, int origin, int len){
    if(origin < DEF_ONE || \
        origin > T[DEF_ZERO] || \
        (origin + len - DEF_ONE) > T[DEF_ZERO] || \
        len < DEF_ZERO){ return OPERATION_ERROR;}
        
    for(int i = (origin + len); i <= T[DEF_ZERO]; i++){
        T[i - len] = T[i];
    }
    T[DEF_ZERO] -= len;
    return OPERATION_SUCCESS;
}

void getNext(Strings T, int next[]){
    /* j 前缀，i 后缀*/
    int j = DEF_ZERO ,i = DEF_ONE;
    next[DEF_ONE] = DEF_ZERO;
    while (i < T[DEF_ZERO]){
        if(DEF_ZERO == j || T[j] == T[i]){
            i++;j++;
            if(next[i] != next[j]){
                next[i] = j;
            }else{
                next[i] = next[j];
            }
        }else{
            j = next[j];
        }
    }
}

int strIndexKmp(Strings S, int origin, Strings T){
    if(S[DEF_ZERO] < T[DEF_ZERO]){ return OPERATION_ERROR;}
    if(origin > S[DEF_ZERO] || origin < DEF_ONE){  return OPERATION_ERROR;}
    int i = origin, j = DEF_ONE;
    int next[INIT_STRAND_SIZE];
    getNext(T,next);
    while(i <= S[DEF_ZERO] && j<= T[DEF_ZERO]){
        if(DEF_ZERO == j || S[i] == T[j]){
            i++; j++;
        }else{
            j = next[j];
        }
    }
    if(j > T[DEF_ZERO]){
        return i - T[DEF_ZERO];
    }
    return OPERATION_ERROR;
}