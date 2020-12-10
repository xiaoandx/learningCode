import re


def checkLength(pwd):
    """
    判断密码长度
    :param pwd: 用户密码
    :return: 1 -> TURE ; 0 -> FALSE:
    """
    return len(pwd) >= 8


def checkContainUpper(pwd):
    """
    判断是否包含大写字母
    :param pwd: 用户密码
    :return: 1 -> TURE ; 0 -> FALSE
    """
    pattern = re.compile('[A-Z]+')
    match = pattern.findall(pwd)
    if match:
        return 1
    else:
        return 0


def checkContainNum(pwd):
    """
    判断是否包含数字
    :param pwd: 用户密码
    :return: 1 -> TURE ; 0 -> FALSE
    """
    pattern = re.compile('[0-9]+')
    match = pattern.findall(pwd)
    if match:
        return 1
    else:
        return 0


def checkContainLower(pwd):
    """
    判断是否包含小写字母
    :param pwd: 用户密码
    :return: 1 -> TURE ; 0 -> FALSE
    """
    pattern = re.compile('[a-z]+')
    match = pattern.findall(pwd)
    if match:
        return 1
    else:
        return 0


def checkSymbol(pwd):
    """
    判断是否包含符号
    :param pwd: 用户密码
    :return: 1 -> TURE ; 0 -> FALSE
    """
    pattern = re.compile('([^a-z0-9A-Z])+')
    match = pattern.findall(pwd)
    if match:
        return 1
    else:
        return 0


def checkPassword(pwd):
    """
    密码判断
    :param pwd: 用户密码
    :return: 密码安全等级
    """
    upperOK = checkContainUpper(pwd)
    lowerOK = checkContainLower(pwd)
    numOK = checkContainNum(pwd)
    symbolOK = checkSymbol(pwd)
    if upperOK + lowerOK + numOK + symbolOK == 1:
        print('输入密码强度：弱')
    if upperOK + lowerOK + numOK + symbolOK == 2:
        print('输入密码强度：中低')
    if upperOK + lowerOK + numOK + symbolOK == 3:
        print('输入密码强度：中高')
    if upperOK + lowerOK + numOK + symbolOK == 4:
        print('输入密码强度：强')

    return upperOK + lowerOK + numOK + symbolOK


def test():
    status = True
    while status:
        password = input("请输入你的密码长度至少八位：")
        if checkLength(password):
            if checkPassword(password):
                status = False
            else:
                print('再想一个更难的密码吧！')
        else:
            print("输入密码错误")


if __name__ == '__main__':
    test()
