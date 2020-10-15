/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <xiaoandx@gmail.com>                                                 
*                                                                                                        
*  FileName:  test1                                                                         
*  Author:  WEI.ZHOU                                                                                     
*  Version:  1.0                                                                                         
*  Date:  2020-10-15                                                                                     
*  Description: 输出指定字符                                                              
*  Others:                
*           测试输出用例：
*                   1.输出如下字符其中包括上下26个*号
*                      **************************
*                           I am very good!
*                      **************************                                                                                                    
**********************************************************************************************************/
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR  0
#define INPUT_VALUE_ZERO 0

/**
 * @brief 打印分割线
 * @param int number 需要输出的长度
 * @return int 返回操作状态，1成功；0失败
*/
int printLine(int number);

int main(){
    printLine(26);
    printf("    I am very good!\n");
    printLine(26);
    return OPERATION_SUCCESS;
}

int printLine(int number){
    if(number != INPUT_VALUE_ZERO){
        for(int i = 0;i < number; i++){
            printf("*");
        }
        printf("\n");
        return OPERATION_SUCCESS;
    }
    return OPERATION_ERROR;
}