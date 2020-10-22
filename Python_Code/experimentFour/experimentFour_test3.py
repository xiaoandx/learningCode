# 输入一个大于二的自然是
number = int(input("输入一个大于2的自然数："));
result = list();

# 判断输入自然数是否满足添加
if number <= 2:
    print("输入自然数错误重新输入");
    number = int(input("输入一个大于2的自然数："));


# 方法（求素数的方法）
def prime(number):
    for i in range(2, number):
        if number % i == 0:
            return False;
    return True;


# 循环判断数是否满足
for index in range(2, number, 1):
    if prime(index) == True:
        result.append(index);

# 打印输出
print("0 - {} 之间的素数有: ".format(number), end=" ");
print(",".join(str(i) for i in result));
