#!/usr/bin/env python
# -*- coding: UTF-8 -*-
"""
 Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 The following code snippets are only used for circulation and cannot be used for business.
 If the code is used, no consent is required, but the author has nothing to do with any problems and
 -consequences.

 In case of code problems, feedback can be made through the following email address.
                         <xiaoandx@gmail.com>

 @Description: 准备一个GIF动图，编写程序，使用扩展库pillow将其拆分为多个静态图片。
 @File: experimentTest3.py
 @Author: WEI.ZHOU
 @Date: 2020-12-10 14:40:48
 @Version: V1.0
 @Others:  Running test instructions
"""
import uuid
import os
from PIL import Image
from pylab import *

def splicingImg(imgPath):
    """
    拼接等尺寸图片（准备多个模式和尺寸都一样的图片，编写程序将这些图片拼接为长图。）
    :param imgPath: 图片所在的文件夹
    :return:
    """
    im_list = []
    for fn in os.listdir(imgPath):
        if fn.endswith('.jpg'):
            im_list.append(Image.open(imgPath + os.sep + fn))
    width = 0
    height = 0
    for img in im_list:
        w, h = img.size
        height += h
        width = max(width, w)

    # 创建空白长图
    result = Image.new(im_list[0].mode, (width, height), 0xffffff)
    # 拼接图片
    height = 0
    for img in im_list:
        w, h = img.size
        result.paste(img, box=(round(width / 2 - w / 2), height))
        height += h

    result.save(imgPath + '拼接长图.jpg')
    result.show()
    result.close()
    pass


def gifToImgs(gifURL):
    """
    gif动图转帧图片
    :param gifURL:  gif图片地址
    :return:
    """
    img = Image.open(gifURL)
    pngDir = gifURL[:-4] + ' - GIF To IMG'

    if not os.path.exists(pngDir):
        os.mkdir(pngDir)

    try:
        while True:
            current = img.tell()
            img.save(pngDir + '\\' + str(current) + '.png')
            img.seek(current + 1)
    except EOFError:
        pass
    finally:
        img.close()


def main():
    """
    运行说明：需要一个方法一个进行运行，可以同时运行不过不建议
    :return:
    """
    gifURL = r'.\\temp\\img\\gif\\1.gif'
    gifToImgs(gifURL)


if __name__ == '__main__':
    main()
