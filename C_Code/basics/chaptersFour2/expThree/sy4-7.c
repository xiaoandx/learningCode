/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 下面程序的功能是：输出200以内同时能被3和7整除的所有整数
 * 请填空
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 17:29:02
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 18:01:52
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main()
{ 
  int i,j;
  for (i=1; i<=200;i++ )
  { 
     if (i%3!=0 || i%7!=0){
         continue; 
     }     
     printf ( "%d\t",i );
  }
   return 0;
}