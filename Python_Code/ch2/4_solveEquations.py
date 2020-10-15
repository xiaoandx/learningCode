
'''
Copyright (c) 2020 WEI.ZHOU. All rights reserved.                           

The following code snippets are only used for circulation and cannot be used for business.      

If the code is used, no consent is required, but the author has nothing to do with any problems and consequences.                                                                                   

In case of code problems, feedback can be made through the following email address.         

                                   <xiaoandx@gmail.com>


    使用克拉默法则解二元线性方程组
    
    1.先输入第一个方程组的3个变量a b c 用空格分开
    2.在输入第二个方程组的3个变量d e f 用空格分开

'''
import math

a,b,c = map(float,input("先输入第一个方程组的3个变量a b c 用空格分开:").split())
d,e,f = map(float,input("在输入第二个方程组的3个变量d e f 用空格分开:").split())
             
D = a * e - b *d

if D!=0 :
    Dx = c * e - b * f

    Dy = a * f - c * d

    x1 = Dx/D
    x2 = Dy/D

    if x1 == x2 :
        print("二元线性方程组的解为：",x1)
    
    print("二元线性方程组的第一个解为%.2f, 第二个解为%.2f" % (x1,x2))
else:
    print("error")




