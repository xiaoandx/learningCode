/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 第一个数和最后一个数，第二个数与倒数第二个数交换的思想将十个数的数组逆序输出。
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 * @Others: 推荐使用方法二
 */
#include <stdio.h>
#define N 10
#define DEF_ONE 1
#define DEF_TWO 2
#define DEF_ZERO 0

/**
 * @brief   数组交换,采用数值交换的方式进行倒序
 * @Date    2020-11-14 09:08:00
 * @param   int T[] 需要交换的数组
 * @param   int N 数组的长度
 */
void exchangeArray(int T[], int V);

int main(){
    
    int i,j,num[N];
    printf("请输入十位数，用空格分隔：");
    for(i = DEF_ZERO; i<N; i++){
        scanf("%d",&num[i]);
    }

    // 方法一：直接倒叙输出
    // for(j = N - DEF_ONE; j>=DEF_ZERO; j--){
    //     printf("%d ",num[j]);
    // }


    // 方法二：采用数值交换的方式进行倒序
    exchangeArray(num,N);
    printf("\n数值逆序输出：");
    for(int i=0;i<N;i++){
        printf("%d ",num[i]);
    }

    return DEF_ZERO;
}

void exchangeArray(int T[], int V){
    int i,temp;
    for(i=DEF_ZERO; i<V/DEF_TWO; i++){
        temp = T[i];
        T[i] = T[(V-DEF_ONE)-i];
        T[(V-DEF_ONE)-i] = temp;
    }
}
