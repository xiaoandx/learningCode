/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:实现在一个字符串中查找指定的字符，
 * 并输出指定的字符在字符串中出现的次数及位置，如果该字符串中不包含指定的字符，请输出提示信息
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 * @Others: 
 */
#include <stdio.h>
#define N 100
#define DEF_ONE 1
#define DEF_TWO 2
#define DEF_ZERO 0

int main() {
    char T[N] = "hello word!";
    int cout = DEF_ZERO;
    char str;
    int place[N]={0}, pos=0;
    printf("请输入一个字符进行查找：");
    str = getchar();
    for(int i = DEF_ZERO; i<N; i++){
        if(str == T[i]){
            cout++;
            place[pos++] = i;
        }
    }
    if(DEF_ZERO == cout){
        printf("字符串%s中没有出现%c字符\n",T,str);
    }else{
        printf("输入的%c在字符串%s中共出现%d次,出现的位置分别是：", str, T, cout);
        for(int i = DEF_ZERO ;i<cout; i++){
            printf("%d ", place[i]);
        }
    }
    return DEF_ZERO;
}
