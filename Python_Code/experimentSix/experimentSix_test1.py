"""
Copyright (c) 2020 WEI.ZHOU. All rights reserved.
The following code snippets are only used for circulation and cannot be used for business.
If the code is used, no consent is required, but the author has nothing to do with any problems
and consequences.
In case of code problems, feedback can be made through the following email address.
                                   <xiaoandx@gmail.com>
@author: WEI.ZHOU
@data:2020-11-06
"""
number1 = int(input("请输入第一个数字："))
number2 = int(input("请输入第二个数字："))
x = number1
y = number2
if x < y:
    x, y = y, x
    r = x % y
    while r != 0:
        x = y
        y = r
        r = x % y
    print(number1, number2, "的最大公约数是", y)