#!/usr/bin/env python
# -*- coding: UTF-8 -*-
"""
 Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 The following code snippets are only used for circulation and cannot be used for business.
 If the code is used, no consent is required, but the author has nothing to do with any problems and
 -consequences.

 In case of code problems, feedback can be made through the following email address.
                         <xiaoandx@gmail.com>

 @Description: 使用Pillow模块 完成图片操作
 @File: experimentTest3.py
 @Author: WEI.ZHOU
 @Date: 2020-12-10 14:40:48
 @Version: V1.0
 @Others:  Running test instructions
"""
import uuid

from PIL import Image, ImageGrab, ImageFilter, ImageEnhance
from matplotlib.font_manager import FontProperties
from pylab import *

imgFolderPath = './temp/'

class runError(Exception):
    def __init__(self, value='运行错误，检查文件路径'):
        self.value = value

    def __str__(self):
        return repr(self.value)


class MyGaussianBlur(ImageFilter.Filter):
    """
    重写高斯模糊
    """
    name = "GaussianBlur"

    def __init__(self, radius=2, bounds=None):
        self.radius = radius
        self.bounds = bounds

    def filter(self, image):
        if self.bounds:
            clips = image.crop(self.bounds).gaussian_blur(self.radius)
            image.paste(clips, self.bounds)
            return image
        else:
            return image.gaussian_blur(self.radius)


def getImgObject(imgURL):
    return Image.open(imgURL)


def showImg(imgURL):
    """
    显示图片
    :param imgURL:图片地址
    :return:NULL
    """
    img = getImgObject(imgURL)
    img.show()
    img.close()


def getImgMassage(imgURL):
    """
    获取图片信息大小，类型
    :param imgURL:图片地址
    :return:NULL
    """
    img = getImgObject(imgURL)
    print("图片格式为：", img.format)  # 显示图像格式
    print("图像大小:", img.size)  # 显示图像大小
    print("图片的高度：", img.height, "图片的宽度：", img.width)
    img.close()
    pass


def showHistogram(imgURL):
    """
    查看图片直方图
    :param imgURL:图片地址
    :return:
    """
    font = FontProperties(fname=r"c:\windows\fonts\SimSun.ttc", size=14)
    imgObject = getImgObject(imgURL)
    img = array(imgObject.convert('L'))  # 打开图像，并转成灰度图像

    figure()
    subplot(121)
    gray()
    contour(img, origin="image")
    axis("equal")
    axis("off")
    title(u"图像轮廓", fontproperties=font)

    subplot(122)
    hist(img.flatten(), 128)
    title(u"图像直方图", fontproperties=font)
    plt.xlim([0, imgObject.width])
    plt.ylim([0, imgObject.height])

    show()

    img.close()

def saveNewImg(imgURL):
    """
    保存图片
    :param imgURL:图片地址
    :param saveImgURL:保存图片新地址
    :return:
    """
    fileName = 'saveNewImg-' + str(uuid.uuid1())
    try:
        getImgObject(imgURL).save(imgFolderPath + fileName + '.png')
    except runError as run:
        print("save error", run.value)
    pass


def zoomImg(imgURL):
    """
    缩放图片
    :param imgURL:图片地址
    :return:
    """
    fileName = 'zoomImg-' + str(uuid.uuid1())
    img = getImgObject(imgURL)
    width = int(img.width) * 10
    height = int(img.height) * 10
    img = img.resize((width, height), Image.ANTIALIAS)
    img.save(imgFolderPath + fileName + '.png')
    img.show()
    img.close()
    pass


def rotateImg(imgURL, degrees=180):
    """

    :param imgURL:图片地址
    :param degrees:旋转度数 默认旋转180度
    :return:
    """
    fileName = 'rotateImg-' + str(uuid.uuid1())
    img = getImgObject(imgURL)
    img2 = img.rotate(degrees)  # 自定义旋转度数
    img2 = img2.resize((200, 200))  # 改变图片尺寸
    img2.save(imgFolderPath + fileName + '.png')
    img2.show()
    img.close()
    pass


def shearImg(imgURL, width=100, height=100):
    """
    裁剪图片
    :param imgURL: 需要裁剪图片地址
    :param width: 宽 默认：100
    :param height: 高 默认：100
    :return:
    """
    fileName = 'shearImg-' + str(uuid.uuid1())
    img = getImgObject(imgURL)
    img = img.resize((width, height), Image.ANTIALIAS)
    img.save(imgFolderPath + fileName + '.png')
    img.show()
    img.close()
    pass


def stImg(imgURL):
    """
    制作略缩图
    :param imgURL:图片地址
    :return:
    """
    size = 100, 100
    fileName = 'stImg-' + str(uuid.uuid1())
    img = getImgObject(imgURL)
    img.thumbnail(size, Image.ANTIALIAS)  # 等比例缩放
    img.save(imgFolderPath + fileName + '.png')
    img.show()
    img.close()
    pass


def screenshot():
    """
    全屏截图
    :return:
    """
    fileName = 'screenshot-' + str(uuid.uuid1())
    im = ImageGrab.grab()
    im.save(imgFolderPath + fileName, "PNG")
    im.show()
    img.close()
    pass


def gaussianBlur(imgURL, degree=10):
    """
    图片高斯模糊
    :param imgURL: 图片地址
    :param degree: 高斯模糊程度 默认：10
    :return:
    """
    fileName = 'gaussianBlur-' + str(uuid.uuid1())
    img = getImgObject(imgURL)
    img = img.filter(MyGaussianBlur(radius=degree))
    img.save(imgFolderPath + fileName + '.png')
    img.show()
    img.close()
    pass


def adjustImgColor(imgURL, color=[1, 1, 0]):
    """
    图像冷暖色和对比度调整
    :param imgURL:图片地址
    :param color:红，绿，蓝变化倍数 默认：[1, 1, 0]
    :return:
    """
    fileName = 'adjustImgColor-' + str(uuid.uuid1())
    img = getImgObject(imgURL)
    r, g, b, c = img.split()
    r = r.point(lambda i: i * color[0])
    g = g.point(lambda i: i * color[1])
    b = b.point(lambda i: color[2])
    img = Image.merge("RGB", (r, g, b))
    img.save(imgFolderPath + fileName + '.png')
    img.show()
    img.close()
    pass


def contrastImg(imgURL, degree=2):
    """
    改变图片对不度
    :param imgURL: 图片地址
    :param degree: 对比度改变倍数，默认两倍
    :return:
    """
    fileName = 'contrastImg-' + str(uuid.uuid1())
    img = getImgObject(imgURL)
    img = ImageEnhance.Contrast(img)
    img = img.enhance(degree)
    img.save(imgFolderPath + fileName + '.png')
    img.show()
    img.close()
    pass


def main():
    """
    运行说明：需要一个方法一个进行运行，可以同时运行不过不建议
    :return:
    """
    imgURL = r'.\\temp\\result.png'

    # showImg(imgURL)
    # getImgMassage(imgURL)
    # showHistogram(imgURL)
    # saveNewImg(imgURL)
    # zoomImg(imgURL)
    # rotateImg(imgURL, 180)
    # shearImg(imgURL, 100, 30)
    # stImg(imgURL)
    # screenshot()
    # gaussianBlur(imgURL, 10)
    # adjustImgColor(imgURL, [1.3, 0.5, 0])
    # contrastImg(imgURL, 3)


if __name__ == '__main__':
    main()
