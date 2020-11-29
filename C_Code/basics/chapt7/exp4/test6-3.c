/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 编写程序实现一维数组a中的元素为：1,4,2,7,3,12,5,34,5,9。求一维数组a中的最大元素及其下标
 * @Author: WEI.ZHOU
 * @Date: 2020-11-29 18:12:43
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>
#include <stdlib.h>

#define OPERATION_SUCCESS 1
#define ARRAY_SIZE 10
#define ZERO 0
#define ONE 1
#define TWO 2

/**
 * @brief   获取数组中最大值与其位置
 * @Date    2020-11-29 18:37:00
 * @param   int N[] 需要操作的数组
 * @return  {int *} 结果
 */
int * findArrayMax(int N[]);

int main() {
    int a[ARRAY_SIZE] = {1,4,2,7,3,12,5,34,5,9};
    int *result;
    result = findArrayMax(a);
    printf("The max is: %d,position is: %d",result[ZERO],result[ONE]);
    return OPERATION_SUCCESS;
}

int * findArrayMax(int N[]){
    int m,p,i;
    int *succ;
    succ = (int*)malloc(TWO *sizeof(int));
    succ[ZERO] = N[ZERO];
    for(i = 1; i<ARRAY_SIZE; i++){
        if(N[i] > succ[ZERO]){
            succ[ZERO] = N[i];
            succ[ONE] = i;
        }
    }
    return succ;
}