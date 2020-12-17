#!/usr/bin/env python
# -*- coding: UTF-8 -*-
"""
 Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 The following code snippets are only used for circulation and cannot be used for business.
 If the code is used, no consent is required, but the author has nothing to do with any problems and
 -consequences.

 In case of code problems, feedback can be made through the following email address.
                         <xiaoandx@gmail.com>

 @Description: 读取Word文件中所有段落文本，然后输出其中所有红色的文本和加粗的文本以及同时具有这两种属性的文本
 @File: experimentTest1.py
 @Author: WEI.ZHOU
 @Date: 2020-12-17 13:10:48
 @Version: V1.0
 @Others:  Running test instructions
"""
import docx

from docx.shared import RGBColor


def searchBydocx(file):
    """
    查询满足 红色的文本和加粗的文本以及同时具有这两种属性的文本
    :param file: docx文件
    :return:
    """
    boldList = []
    redTxtList = []
    # 输出原文
    for para in file.paragraphs:
        for i in para.runs:
            if i.bold:
                boldList.append(i.text)
            if i.font.color.rgb == RGBColor(255, 0, 0):
                redTxtList.append(i.text)
    meanwhileList = set(boldList) & set(redTxtList)
    return {"bold": boldList, "redText": redTxtList, "meanwhile": meanwhileList}


def printData(searchData):
    """
    输出查询匹配结果
    :param searchData:
    :return:
    """
    for key in searchData.keys():
        print("=" * 20 + key + "=" * 20)
        for data in searchData[key]:
            print(data, end=" ")
        print("\n")


def main():
    # docx路径
    fileUrl = ".\\temp\\test.docx"
    # docx文本对象
    file = docx.Document(fileUrl)
    searchData = searchBydocx(file)
    printData(searchData)


if __name__ == '__main__':
    main()
