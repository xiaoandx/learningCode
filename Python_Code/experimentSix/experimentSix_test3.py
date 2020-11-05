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
for i in range(1, 1000):
    listY = []
    # 求数的所以因子
    for j in range(1, i):
        if i % j == 0:
            listY.append(j)
    # 判断因子的和是否等于
    if i == sum(listY):
        print("{} =".format(i), end=" ")
        print('+'.join(map(str, listY)))
