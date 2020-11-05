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
number = int(input("请输入四位需要加密的整数："))


# 加密

def change(T):
    x1 = T % 10;
    x2 = T // 10 % 10;
    x3 = T // 100 % 10;
    x4 = T // 1000
    x1 = (x1 + 5) % 10;
    x2 = (x2 + 5) % 10;
    x3 = (x3 + 5) % 10;
    x4 = (x4 + 5) % 10;
    temp = x1
    x1 = x4
    x4 = temp
    temp = x2
    x2 = x3
    x3 = temp
    return str(x4) + str(x3) + str(x2) + str(x1)


# 解密

def decipher(T):
    x1 = T % 10;
    x2 = T // 10 % 10;
    x3 = T // 100 % 10;
    x4 = T // 1000
    temp = x1
    x1 = x4
    x4 = temp
    temp = x2
    x2 = x3
    x3 = temp
    return str(x4 - 5) + str(x3 - 5) + str(x2 - 5) + str(x1 - 5)


print("传输需要加密数据{}，加密得到{} \n".format(number, change(number)))
print("加密后的数据{}，解密得到原数据{}".format(change(number), decipher(int(change(number)))))
