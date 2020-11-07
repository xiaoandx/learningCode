/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 16:02:37
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 17:09:15
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>
int main(){ 
   int i,j,k,x=0;
   for(i=0;i<2;i++){ 
       x++;
       for(j=0;j<3;j++){ 
           if(j%2){
               continue;
           }  
           x++;
	   }
       x++;
   }
   k=i+j;
   printf("k=%d,x=%d\n",k,x);
   return 0;
}