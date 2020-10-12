'''
Copyright (c) 2020 WEI.ZHOU. All rights reserved.

The following code snippets are only used for circulation and cannot be used for business.

If the code is used, no consent is required, but the author has nothing to do with any problems and consequences.

In case of code problems, feedback can be made through the following email address.

                                   <xiaoandx@gmail.com>
'''

'''
    1小题：
        注意事项：可以进行代码完善
        测试用例：
            1. 0
            2. 1
            3. -11

'''

number = int(input('输入一个整数： '))

var = "Hello World"

if number == 0:
    print(var)
elif number > 0:
    print("He\nll\no \nWo\nrl\nd")
else:
    print("\n".join(var))

'''
    2小题：
        注意事项： M和OP，OP与N之间需要空格，单不要求空格数量
        测试用例：
            1. 123  + 123
            2. 123 - 1
            3. 123  * 2
            4. 10 /  3
            5. 10  / 0
'''
# 读取字符串
userStr = input("请输入如下格式的字符串（M和N是任何数值，OP为（+，-，*，/）的操作）M OP N （如 321  +  123）：")
#拆分字符串
list = userStr.split()
#判断并进行运算
if list[1] == "+" :
    print("{} {} {} = {:.2f}".format(list[0],list[1],list[2],float(list[0]) + float(list[2])))
elif list[1] == "-" :
    print("{} {} {} = {:.2f}".format(list[0],list[1],list[2],float(list[0]) - float(list[2])))
elif list[1] == "*" :
    print("{} {} {} = {:.2f}".format(list[0],list[1],list[2],float(list[0]) * float(list[2])))
else:
    if int(list[2]) != 0 :
        print("{} {} {} = {:.2f}".format(list[0],list[1],list[2],float(list[0]) / float(list[2])))
    else:
        print("除数不能为0")