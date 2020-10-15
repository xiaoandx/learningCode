# 判断这个字符串中有多少个字符、数字、空格、特殊字符
# 首先定义一个字符串
str1 = input("请输入一个字符串:")

# 初始化字符、数字、空格、特殊字符的计数
strSum = 0
digitSum = 0
spaceSum = 0
otherSum = 0

for strs in str1:
        # 初始化字符串有字符，那么字符的数量+1
    if strs.isalpha():
        strSum += 1
    elif strs.isdigit():
        digitSum += 1
    elif strs == ' ':
        spaceSum += 1
else:
    otherSum += 1

print("输入的字符串的字符有：",strSum)
print("输入的数字的字符有：",digitSum)
print("输入的空格的字符有：",spaceSum)
print("输入的特殊字符的字符有：",otherSum)
