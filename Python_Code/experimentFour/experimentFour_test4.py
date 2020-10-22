# 创建一个保存满足水仙花数的列表
numberList = list();

# 循环判断每个数是否满足
for number in range(100, 1000, 1):
    a = number // 100;
    b = (number // 10) % 10;
    c = (number % 100) % 10;
    if a ** 3 + b ** 3 + c ** 3 == number:
        numberList.append(number);

# 按照格式输出满足的数
print("所有的3位水仙花数:", end=" ");
print(", ".join(str(i) for i in numberList));
