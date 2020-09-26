centigrade = input("输入需要转换的摄氏温度：")

fahrenheit = (float(centigrade) * 1.8) + 32

print('1.摄氏温度等于 %0.2f 华氏温度' %fahrenheit)
print('2.转换后的华氏温度等于：' + str(fahrenheit))
print('3.{}摄氏温度等于 {} 华氏温度'.format(centigrade,fahrenheit))




