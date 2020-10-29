"""
Copyright (c) 2020 WEI.ZHOU. All rights reserved.
The following code snippets are only used for circulation and cannot be used for business.
If the code is used, no consent is required, but the author has nothing to do with any problems
and consequences.
In case of code problems, feedback can be made through the following email address.
                                   <xiaoandx@gmail.com>
@author: WEI.ZHOU
@data:2020-10-29
"""


# 求兔子方法

def getSum(months):
    if 1 == months or 2 == months:
        return 1
    return getSum(months - 1) + getSum(months - 2)


month = int(input("输入兔子养的月份："))

print("{}个月后兔子的数量为：{}".format(month, getSum(month)))
