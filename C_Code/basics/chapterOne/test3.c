#include <stdio.h>
//主函数体开始
int main(){           
    //定义变量a,b               
	int a,b; 
    //定义平均值c
    float c = 0.0;
	printf("请输入两个任意整数，并用空格隔开:");
    //输入变量a,b的值
	scanf("%d%d",&a,&b);  
    c=(a+b)/2.0;
    //输出c的值          
	printf("两者平均数为%0.2f",c);
	return 0;                  
}