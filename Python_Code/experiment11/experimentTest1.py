#!/usr/bin/env python
# -*- coding: UTF-8 -*-
"""
 Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 The following code snippets are only used for circulation and cannot be used for business.
 If the code is used, no consent is required, but the author has nothing to do with any problems and
 -consequences.

 In case of code problems, feedback can be made through the following email address.
                         <xiaoandx@gmail.com>

 @Description: 编写一个程序demo.py，要求运行该程序后，生成demo_new.py文件，
 其中内容与demo.py一样，只是在每一行的后面加上行号。要求行号以#开始，并且所有行的#垂直对齐。
 @File: experimentTest1.py
 @Author: WEI.ZHOU
 @Date: 2020-12-17 13:10:48
 @Version: V1.0
 @Others:  Running test instructions
"""

def saveNewFile(fileURL):
    """
    解析文件，在每行末尾加行号
    :param fileURL: 文件路径
    :return:
    """
    with open(fileURL, 'r', encoding="utf-8")as fp:
        lines = fp.readlines()
    maxLength = len(max(lines, key=len))
    linesTxt = []
    for index, line in enumerate(lines):
        line = line.rstrip().ljust(maxLength) + "#" + str(index + 1) + '\n'
        linesTxt.append(line)

    with open(fileURL[:-3] + '_new.py', 'w', encoding="utf-8") as fp:
        fp.writelines(linesTxt)
    pass


def main():
    # py路径
    fileUrl = ".\\temp\\dome.py"
    # py文本对象
    saveNewFile(fileUrl)
    pass


if __name__ == '__main__':
    main()
