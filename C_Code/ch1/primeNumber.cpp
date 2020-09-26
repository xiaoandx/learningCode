/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     *
*  The following code snippets are only used for circulation and cannot be used for business.            *
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   *
*  -consequences.                                                                                        *
*                                                                                                        *
*  In case of code problems, feedback can be made through the following email address.                   *
*                                   <xiaoandx@gmail.com>                                                 *
*                                                                                                        *
*  FileName:  primeNumber                                                                                *
*  Author:  WEI.ZHOU                                                                                     *
*  Version:  1.0                                                                                         *
*  Date:  2020-09-24                                                                                     *
*  Description: 复数类型定义，表现，及实现具体操作                                                             *
*  Others:  NULL                                                                                         *                                                             
**********************************************************************************************************/
#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;

/*数据结构体声明*/
typedef struct com{
	float realpart;
	float imagpart;
}Complex;

void initComplex(Complex &z1, float x, float y);
void printComplex(Complex &z1); 
void addComplex(Complex z1, Complex z2, Complex &z3);
void subtractionComplex(Complex z1, Complex z2, Complex &z3);
void rideComplex(Complex z1, Complex z2, Complex &z3);
void exceptComplex(Complex z1, Complex z2, Complex &z3);
double getModuleLength(Complex &z1);
void operationComplex(Complex z1, Complex z2, Complex &z3, char x);

int main() {
	Complex z1,z2,z3;
	initComplex(z1, 12.3, 14.5);
	initComplex(z2, 18.5, 16.3); 
	//addComplex(z1,z2,z3); 
	//subtractionComplex(z1,z2,z3);
	//rideComplex(z1,z2,z3);
	//exceptComplex(z1,z2,z3);
	//cout<<getModuleLength(z1)<<endl;
	//operationComplex(z1,z2,z3,'+');
	printComplex(z3);


   system("pause");
	return 0;
}

/**
 * @brief 初始化复数，需要传递两个float数值，分别初始化实部和虚部
 * To initialize the complex number, we need to pass two float values 
 * to initialize the real part and the imaginary part respectively
 * @param Complex,float,float
 * @return void
 */ 
void initComplex(Complex &z1, float x, float y){
	z1.realpart = x;
	z1.imagpart = y;
}; 

/**
 * @brief 打印输出实现方法
 * @param Complex
 * @return void
 */ 
void printComplex(Complex &z1){
	cout<<z1.realpart<<"+"<<z1.imagpart<<"i"<<endl;
}; 

/**
 * @brief 复数相加
 * @param Complex,Complex,Complex
 * @return void
 */ 
void addComplex(Complex z1, Complex z2, Complex &z3){
	z3.realpart = z1.realpart + z2.realpart;
	z3.imagpart = z1.imagpart + z2.imagpart;
};

/**
 * @brief 复数相减
 * @param Complex,Complex,Complex
 * @return void
 */ 
void subtractionComplex(Complex z1, Complex z2, Complex &z3){
	z3.realpart = z1.realpart - z2.realpart;
	z3.imagpart = z1.imagpart - z2.imagpart;
};

/**
 * @brief 复数相乘
 * @param Complex,Complex,Complex
 * @return void
 */ 
void rideComplex(Complex z1, Complex z2, Complex &z3){
	z3.realpart = z1.realpart * z2.realpart;
	z3.imagpart = z1.imagpart * z2.imagpart;
};

/**
 * @brief 复数相除
 * @param Complex,Complex,Complex
 * @return void
 */ 
void exceptComplex(Complex z1, Complex z2, Complex &z3){
	z3.realpart = z1.realpart / z2.realpart;
	z3.imagpart = z1.imagpart / z2.imagpart;
};

/**
 * @brief 复数求模 
 * @param Complex
 * @return double 
 */
double getModuleLength(Complex &z1){
	return  sqrt(z1.realpart*z1.realpart + z1.imagpart*z1.imagpart); 
};

/**
 * @brief 复数操作判断
 * @param Complex,Complex,Complex,char
 * @return void
 */ 
void operationComplex(Complex z1, Complex z2, Complex &z3, char x){
	switch(x){
    case '+':
       addComplex(z1,z2,z3);
       break; 
    case '-':
      subtractionComplex(z1,z2,z3);
       break; 
    case '*':
      rideComplex(z1,z2,z3);
       break; 
    case '/':
      exceptComplex(z1,z2,z3);
       break; 
    
    default : 
       break;
	};
};
