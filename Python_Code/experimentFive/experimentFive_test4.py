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

# 九九乘法表
for j in range(1, 10):
    for k in range(1, j+1):
        print(k, "*", j, "=", j*k, " ", end="")
    print("")