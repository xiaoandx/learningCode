# 输入一个列表
listOne = eval(input("请输入一个列表用逗号(,)区分："));

# 将输入的列表进行降序重新赋值
listTwo = sorted(listOne, reverse=True);
# 输出排序后的新列表
print("将输入的列表降序后如下：");
print(listTwo);
