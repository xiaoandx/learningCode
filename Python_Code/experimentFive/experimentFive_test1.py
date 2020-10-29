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

# 接受控制台以逗号分隔的数字序列，并生成包含每个数字的列表和元组
import re
values=input("请输入一组如下格式的文本 34岁,67年,55岁,33岁,12日,98年：")
k=re.findall(r'[0-9]+', values)
print(k)
print(tuple(k))