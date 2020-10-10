
'''
Copyright (c) 2020 WEI.ZHOU. All rights reserved.                           

The following code snippets are only used for circulation and cannot be used for business.      

If the code is used, no consent is required, but the author has nothing to do with any problems and consequences.                                                                                   

In case of code problems, feedback can be made through the following email address.         

                                    <xiaoandx@gmail.com>
'''
#(1)小题
#二进制转为十进制
print('二进制10111100转为十进制',int("10111100",2));
print('二进制10111100转为十进制',eval("0b10111100"));
#八进制转为十进制
print('八进制756转为十进制',int("756",8));
print('八进制756转为十进制',eval("0o756"));
#十六进制进制转为十进制
print('十六进制efb368转为十进制',int("efb368",16));
print('十六进制efb368转为十进制',eval("0xefb368"));

#(2)小题
#十进制转为二进制
print("十进制118转为二进制",bin(118));
print('十进制118转为二进制',"{0:b}".format(118));
#十进制转为八进制
print('十进494制转为二进制',oct(494));
print('十进制494转为二进制',"{0:o}".format(30));
#十进制转为十六进制
print('十进15709032制转为十六进制',hex(15709032));
print('十进制15709032转为十六进制',"{0:x}".format(15709032));
