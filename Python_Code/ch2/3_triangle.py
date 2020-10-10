
'''
Copyright (c) 2020 WEI.ZHOU. All rights reserved.                           

The following code snippets are only used for circulation and cannot be used for business.      

If the code is used, no consent is required, but the author has nothing to do with any problems and consequences.                                                                                   

In case of code problems, feedback can be made through the following email address.         

                                 <xiaoandx@gmail.com>
'''
import math

#计算三角形面积的面积和周长
a=float(input('a= '))
b=float(input('b= '))
c=float(input('c= '))

if a+b>c and a+c>b and b+c>a:
    perimeter = a+b+c
    halfPerimeter = (a+b+c)/2
    area = math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c))
    
    print ('三角形的周长为：' + str(perimeter))
    print ('三角形的面积为：%.2f' % area)
else:
    print('三条边的长度不能构成第三边')
