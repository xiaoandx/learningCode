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
import copy

# 创建保持数据数组
listOne = []

# 根据试题判断数组有10个元素，所以循环10次
for i in range(1, 11):
    listOne.append(1)

    # 深复制
    listTwo = copy.deepcopy(listOne)
    # 打印数组
    for a in listTwo:
        print(a, end=' ')
    print(end='\n')
    for b in range(1, len(listTwo)):
        listOne[b] = listTwo[b - 1] + listTwo[b]
