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
# 反弹球经过的距离
sumLenght = 0
# 反弹距离
hightLenght = 100

# 下落反弹循环
for i in range(0, 10):
    sumLenght = hightLenght + hightLenght/2 + sumLenght
    hightLenght /= 2

sumLenght -= hightLenght

print("在第10次落地时，共经过{}米，第10次反弹{}米".format(sumLenght, hightLenght))
