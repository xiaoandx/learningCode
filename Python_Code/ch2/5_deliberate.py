'''
Copyright (c) 2020 WEI.ZHOU. All rights reserved.                           

The following code snippets are only used for circulation and cannot be used for business.      

If the code is used, no consent is required, but the author has nothing to do with any problems and consequences.                                                                                   

In case of code problems, feedback can be made through the following email address.         

                                 <xiaoandx@gmail.com>

    a = 0.1
    b = 0.2
    c = 0.63
    d = 0.6
    print(a+b)
    print(c-d)
    
    0.1 + 0.2 = 0.30000000000000004
    0.63 - 0.6 = 0.030000000000000027

    出现计算机运算结果与实际不符，原因如下：
        1.浮点数为什么缺乏精确性的问题，
          是因为实数的无限精度跟计算机的有限内存之间是有矛盾的。
        2.底层 CPU 和IEEE 754 标准通过自己的浮点单位去执行
          算术时的特征，看似有穷的小数, 在计算机的二进制表示里却是无穷的

    解决办法：
         引入Decimal 模块，该模块的高精度数字用字符串来做展示和中转

'''

import decimal

num1 = decimal.Decimal('0.1')
num2 = decimal.Decimal('0.2')
num3 = decimal.Decimal('0.63')
num4 = decimal.Decimal('0.6')

print(num1 + num2)
print(num3 - num4)
