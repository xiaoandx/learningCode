'''
Copyright (c) 2020 WEI.ZHOU. All rights reserved.
The following code snippets are only used for circulation and cannot be used for business.
If the code is used, no consent is required, but the author has nothing to do with any problems and
-consequences.

In case of code problems, feedback can be made through the following email address.
                                       <xiaoandx@gmail.com>
'''

centigrade = input("输入需要转换的摄氏温度：")

fahrenheit = (float(centigrade) * 1.8) + 32

print('1.摄氏温度等于 %0.2f 华氏温度' %fahrenheit)
print('2.转换后的华氏温度等于：' + str(fahrenheit))
print('3.{}摄氏温度等于 {} 华氏温度'.format(centigrade,fahrenheit))




