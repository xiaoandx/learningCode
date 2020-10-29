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

# 根据公式计算值
import math
C = 50
H = 30
value = []
values= input("请输入一组数字：")
values = values.split(',')
for D in values:
    s = str(int(round(math.sqrt(2 * C * float(D) / H))))
    value.append(s)
print(','.join(value))