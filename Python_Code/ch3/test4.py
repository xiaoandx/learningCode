# ID = input("请输入一段字符串：")
strs = "hello,Python,hello,c"

# 默认使用空格做分配符，strs中无空格，列表中只有一个元素
print(strs.split())

# 使用逗号做分配符
print(strs.split(","))

# 使用逗号做分配符，限制分割2次
print(strs.split(",",2))

# 使用join 将列表与字符连接成字符串
strList = ['hello', 'Python', 'hello', 'c! ']
strs2 = " "
print(strs2.join(strList))

