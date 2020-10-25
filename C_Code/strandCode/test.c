#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <windows.h>

//宏定义区
#define M sizeof(struct User)            //用户表的大小
#define N sizeof(struct stapleFood)      //主食 表大小
#define P sizeof(struct non_stapleFood)  //副食表大小
#define Q sizeof(struct Drink_beverage)  //饮品表大小
#define X sizeof(struct Table)           //餐桌表大小
#define Y sizeof(struct Form)            //订单表大小

//结构体

struct User  //用户表
{
    char userName[10];    //用户名
    char passWord[18];    //密码
    int isVIP;            //会员标记
    int isAdministrator;  //管理员标记
    float money;          //余额
    struct User* next;    //指针域
};
typedef struct User user;
typedef user* pUser;

struct stapleFood  //主食
{
    char name[20];
    float price;
    struct stapleFood* next;
};
typedef struct stapleFood staple_food;
typedef staple_food* pStapleFood;

struct non_stapleFood  //副食
{
    char name[20];
    float price;
    struct non_stapleFood* next;
};
typedef struct non_stapleFood non_staple_food;
typedef non_staple_food* pNon_stapleFood;

struct Drink_beverage  //饮品
{
    char name[20];
    float price;
    struct Drink_beverage* next;
};
typedef struct Drink_beverage drinkBeverage;
typedef drinkBeverage* pDrinkBeverage;

struct Table  //餐桌
{
    int ID;             //餐桌编号
    int People;         //已坐人数
    int count;          //可容纳人数
    char Username[10];  //订餐人
    struct Table* next;
};
typedef struct Table table;
typedef table* pTable;

struct Form  //订单
{
    char name[20];
    float price;
    struct Form* next;
};
typedef struct Form orderForm;
typedef orderForm* pOrder;

//自定义函数区

//用户客户端

void Default();        //欢迎界面
void User_Login();     //用户登录界面
void Logon();          //注册界面
pUser readUserFile();  //从文件中读取用户信息，返回一个表头地址
void save_User(pUser p1);             //将用户信息保存到文件中
void User_Menu();                     //用户菜单
void User_Order();                    //点餐
void Order_StapleFood();              //主食
void Order_nonStapleFood();           //副食
void Order_DrinkBeverage();           //饮品
void Order_Form(int ID, int number);  //订单
void User_List_Table();               //餐桌列表
void Apply_VIP_Menu();                //会员办理菜单
void Add_money(pUser head);           //充值
void Updata_User(pUser head);         //更新用户表
void Apply_VIP(pUser head);           //办理会员
void User_Wallet();                   //我的钱包

//管理员客户端
void Administrator_Menu();                    //管理员菜单
void Administrator_Login();                   //管理员登录
void Check_User();                            //查看用户
void Find_User();                             //查找用户
void All_User();                              //查看所有用户
void All_VIP();                               //本店会员
void Setup_administrator();                   //设置管理员
void Food();                                  //菜品信息
void Add_Food();                              //添加菜单
void save_stapleFood(pStapleFood p);          //保存主食信息
void save_non_stapleFood(pNon_stapleFood p);  //保存副食信息
void save_drinkBeverage(pDrinkBeverage p);    //保存饮品信息
pStapleFood readStapleFoodFile();  //从主食文件中读取用户信息，返回一个表头地址
pNon_stapleFood
readNonStapleFoodFile();  //从副食文件中读取用户信息，返回一个表头地址
pDrinkBeverage
readDrinkBeverageFile();  //从饮品文件中读取用户信息，返回一个表头地址
void Table();             //餐桌管理
void Add_Table();           //添加餐桌
void save_Table(pTable p);  //保存餐桌信息
pTable readTableFile();  //从餐桌文件中读取用户信息，返回一个表头地址
void Clear_Table();               //清理餐桌
void Clear_oneTable();            //清理指定餐桌
void Clear_allTable();            //清理所有餐桌
void Updata_Table(pTable head);   //更新餐桌文件
void Administrator_List_Table();  //餐桌列表

//公共函数
void toxy(int x, int y);  //将光标移动到x，y坐标处
void HideCursor(int x);   //隐藏光标
char* HidePassword();     //隐藏密码
void Exit();              //退出系统
void Change();            //切换账号
void Amend_passWord();    //修改密码
void List_Food();         //菜单列表

//全局变量区
char _userName[10];
char _passWord[18];                  //记录当前用户
pOrder orderHead = NULL, p2 = NULL;  //记录当前用户的订单
int num = 0;

//函数实现区

void toxy(int x, int y)  //将光标移动到x，y坐标处
{
    COORD pos = {x, y};
    HANDLE Out = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(Out, pos);
}

void HideCursor(int x)  //隐藏光标 ,当x为0时，隐藏，为1时，显示
{
    CONSOLE_CURSOR_INFO cursor_info = {1, x};
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cursor_info);
}

void Default()  //欢迎界面
{
    char t;  //用于选择
    do {
        HideCursor(0);  //隐藏光标
        system("color 72");
        toxy(28, 8);
        printf(" 欢迎来到南航餐饮！ ");
        toxy(26, 9);
        printf("-----------------------------");
        toxy(27, 11);
        printf("1.登录 2.注册 3.管理员登录");
        while (1)  //死循环为防止其他按键干扰
        {
            t = getch();   //不回显函数
            if (t == '1')  //如果按1，则进入登录界面
                User_Login();
            else if (t == '2')  //如果按2，则进入注册界面
                Logon();
            else if (t == '3')
                Administrator_Login();
        }         //如果既不是1也不是2和3，则循环输入
    } while (1);  //永远为真
}

void User_Menu()  //用户菜单
{
    char t;  //用于选择菜单选项
    do {
        system("cls");
        HideCursor(0);  //隐藏光标
        system("color 74");
        toxy(32, 3);
        printf("南航餐饮点餐系统！");
        toxy(32, 4);
        printf("当前用户：%s", _userName);
        toxy(30, 5);
        printf("*********************");
        toxy(32, 7);
        printf("| 1.菜单列表 |");
        toxy(32, 9);
        printf("| 2.餐桌列表 |");
        toxy(32, 11);
        printf("| 3.会员办理 |");
        toxy(32, 13);
        printf("| 4.修改密码 |");
        toxy(32, 15);
        printf("| 5.我的钱包 |");
        toxy(32, 17);
        printf("| 6.切换账号 |");
        toxy(32, 19);
        printf("| 7.退出系统 |");
        t = getch();  //不回显函数，输入一个值
        switch (t) {
            case '1':
                User_Order();
                break;
            case '2':
                User_List_Table();
                break;
            case '3':
                Apply_VIP_Menu();
                break;
            case '4':
                Amend_passWord();
                break;
            case '5':
                User_Wallet();
                break;
            case '6':
                Change();
                break;
            case '7':
                Exit();
                break;
            default:
                break;
        }
    } while (1);  //永远 为真
}

char* HidePassword()  //隐藏密码
{
    char password[18];  //密码
    char* p;            //指向密码的指针
    int i = 0;          //记录密码位数
    char t;             //输入密码
    for (;;)            //此处为输入密码不回显操作
    {
        t = getch();    //输入k
        if (t == '\r')  //如果输入k为回车，则跳出循环
        {
            break;
        } else if (t == '\b')  //如果输入k为删除键
        {
            if (i > 0)  //如若密码还没完全删除
            {
                printf("\b");
                printf(" ");
                printf("\b");
                i--;
            }
        } else  //如果输入的k既不是删除键，也不是回车键
        {
            password[i] = t;  //把k的值赋给_password[i];
            printf("*");      //输出*号，保护用户隐私
            i++;              //密码位数加1
        }
    }
    password[i] = '\0';  //在数组末端加一个结束符
    p = password;        //让p指向该数组
    return p;            //返回一个指向密码的指针
}

pUser readUserFile()  //从文件中读取用户信息，返回一个表头地址
{
    FILE* fp;           //文件指针
    int n = 0;          //记录链表 的结点数
    pUser head = NULL;  //定义头指针
    pUser p2, p, pre;
    fp = fopen("User.txt", "a+");  //以只读的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    } else {
        while (!feof(fp))  //判断文件位置标志是否移动到文件末尾
        {
            n++;
            p = (pUser)malloc(M);  //向内存申请一段空间
            fread(p, M, 1, fp);    //将fp所指向的文件中的内容赋给p
            if (n == 1) {
                head = p;
                p2 = p;
            } else  //创建链表
            {
                pre = p2;
                p2->next = p;
                p2 = p;
            }
        }
        p2->next = NULL;
    }
    if (n <= 2)
        head->next = NULL;
    else
        pre->next = NULL;
    fclose(fp);   //关闭文件
    return head;  //返回头指针
}

void save_User(pUser p1)  //将p1所指向的内容存储到文件中
{
    FILE* fp;                      //文件指针
    fp = fopen("User.txt", "a+");  //以追加的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    }
    if (fwrite(p1, M, 1, fp) !=
        1)  //将p1所指向的1个大小为N的数据结构写入fp所指向的文件中
    {
        printf("file write error\n");
    }
    fclose(fp);  //关闭文件
}

void User_Login()  //登录页面
{
    char *q, t, c;  // q指针用于接收
                    // *HidePassword()函数返回的指向密码的指针，t和c均用于选择
    pUser p = readUserFile();  //从文件中读取用户信息，返回一个表头地址
    do {
        HideCursor(1);       //显示管光标
        system("cls");       //清屏
        system("color 73");  //设置颜色
        toxy(28, 8);
        printf("南航餐饮管理系统登录界面");
        toxy(26, 9);
        printf("-----------------------------");
        toxy(32, 11);
        printf("用户名:");
        toxy(32, 13);
        printf("密 码:");
        toxy(40, 11);
        scanf("%s", _userName);
        toxy(40, 13);
        q = HidePassword();    //输入密码
        strcpy(_passWord, q);  //将获得的密码复制给_passWord[]数组
        while (p != NULL && strcmp(p->userName, _userName) !=
                                0)  //遍历链表，寻找当前输入的账户的账号
        {
            p = p->next;
        }
        if (p != NULL)  //如果p不为空
        {
            if (strcmp(p->passWord, _passWord) == 0)  //如果输入的密码正确
            {
                toxy(32, 16);
                printf("正在登陆....");
                Sleep(500);  //暂停0.5秒
                system("cls");
                toxy(32, 10);
                printf("登陆成功！");
                break;  //跳出循环
            } else      //如果输入的密码错误
            {
                toxy(32, 16);
                printf("正在登陆....");
                Sleep(500);
                system("cls");
                toxy(30, 8);
                printf("-------------------------");
                toxy(30, 9);
                printf("|   |");
                toxy(30, 10);
                printf("| 密码错误！是否继续？ |");
                toxy(30, 12);
                printf("| 1.是  2.否 |");
                toxy(30, 13);
                printf("|   |");
                toxy(30, 14);
                printf("-------------------------");
                while (1)  //无限循环为防止其他按键干扰
                {
                    t = getch();  //输入t
                    if (t == '1') {
                        system("cls");  //清屏
                        break;
                    } else if (t == '2')  //如果输入t为n，进入开始界面
                    {
                        system("cls");  //清屏
                        Default();
                        break;
                    }
                }
            }
        } else  //如果p为空，即输入的账号不正确
        {
            toxy(32, 16);
            printf("正在登陆....");
            Sleep(500);
            system("cls");
            toxy(30, 8);
            printf("-------------------------");
            toxy(30, 9);
            printf("|   |");
            toxy(30, 10);
            printf("| 账号错误！是否继续？ |");
            toxy(30, 11);
            printf("|   |");
            toxy(30, 12);
            printf("| 1.是  2.否 |");
            toxy(30, 13);
            printf("|   |");
            toxy(30, 14);
            printf("-------------------------");
            while (1)  //死循环防止其他按键干扰
            {
                c = getch();
                if (c == '1') {
                    system("cls");
                    break;
                } else if (c == '2') {
                    system("cls");  //清屏
                    Default();
                }
            }
        }
    } while (1);
    Sleep(500);   //暂停0.5秒
    User_Menu();  //账号密码均正确，进入用户主菜单
}

void Logon()  //注册界面
{
    pUser p1;
    pUser p = readUserFile();  //从文件中读取用户信息，返回一个表头地址
    p1 = (pUser)malloc(M);  //向内存申请一段空间
    char *q1, *q2;  // q1，q2分别用于接收 *HidePassword()函数返回的值
    char userName[10], passWord[18], againPassword[18], c, k,
        t;  // c，k，t均用于选择
    do {
        system("cls");
        system("color 73");
        HideCursor(1);  //显示光标
        int flag = 0;   //标记信息库中是否存在要注册用户名
        toxy(28, 8);
        printf("南航餐饮管理系统注册界面");
        toxy(26, 9);
        printf("-----------------------------");
        toxy(32, 11);
        printf("用 户 名:");
        toxy(32, 13);
        printf("密 码:");
        toxy(32, 15);
        printf("确认密码:");
        toxy(42, 11);
        scanf("%s", userName);  //输入用户名
        toxy(42, 13);
        q1 = HidePassword();  //输入密码
        strcpy(passWord, q1);
        toxy(42, 15);
        q2 = HidePassword();  //输入确认密码
        strcpy(againPassword, q2);
        while (p != NULL)  //遍历链表，寻找当前输入的账户的账号
        {
            if (strcmp(p->userName, userName) == 0)  //如果信息库中存在该用户名
            {
                toxy(32, 17);
                printf("用户名已存在，请重新注册！");
                flag = 1;  // flag为1时表示用户名已存在
                break;     //跳出循环
            }
            p = p->next;
        }
        if (flag)  //如果用户名已存在
        {
            HideCursor(0);  //隐藏光标
            toxy(32, 19);
            printf("是否继续？");  //询问是否继续
            toxy(32, 21);
            printf("1.是\t2.否");
            while (1) {
                t = getch();
                if (t == '1')
                    break;
                else if (t == '2')
                    break;
            }
            if (t == '1')  //如果继续，则重新注册
                continue;
            else if (t == '2')  //如果不继续，则回到首页
            {
                system("cls");  //清屏
                Default();      //回到首页
            }
        }

        if (strcmp(passWord, againPassword) == 0)  //如果输入的两次密码均正确
        {
            strcpy(p1->userName, userName);
            strcpy(p1->passWord, passWord);
            strcpy(_userName, userName);
            strcpy(_passWord, passWord);
            p1->isVIP = 0;
            p1->money = 0;
            if (strcmp(userName, "root") == 0 && strcmp(passWord, "root") == 0)
                p1->isAdministrator = 1;
            else
                p1->isAdministrator = 0;
            toxy(32, 16);
            printf("正在注册....");
            Sleep(500);
            break;  //跳出循环
        } else      //如果输入的两次密码不同
        {
            toxy(32, 16);
            printf("正在注册....");
            Sleep(500);
            system("cls");
            toxy(30, 8);
            printf("------------------------------");
            toxy(30, 9);
            printf("|    |");
            toxy(30, 10);
            printf("|两次密码不一致!是否继续注册?|");
            toxy(30, 11);
            printf("|    |");
            toxy(30, 12);
            printf("| 1.是  2.否 |");
            toxy(30, 13);
            printf("|    |");
            toxy(30, 14);
            printf("------------------------------");
            while (1) {
                c = getch();
                if (c == '1') {
                    system("cls");
                    break;
                } else if (c == '2') {
                    system("cls");
                    Default();
                    break;
                }
            }
        }
    } while (1);
    save_User(p1);  //调用函数，将p1所指向的内容存储到文件中
    system("cls");
    toxy(32, 10);
    printf("注册成功！");
    Sleep(500);  //暂停0.5秒
    toxy(32, 12);
    printf("正在自动为您登陆....");
    Sleep(500);
    User_Menu();  //注册成功后进入主菜单
}

void User_Order()  //点餐
{
    char ch = '0';
    char t = '0';
    int ID;
    int number;
    do {
        while (1) {
            system("cls");
            HideCursor(1);
            int flag = 0;
            pTable T, Thead;
            Thead = readTableFile();
            T = Thead;
            int j = 11;
            toxy(12, 6);
            printf("餐桌列表(按任意键继续)");
            toxy(2, 8);
            printf("餐桌编号 | 可坐人数 | 已坐人数");
            toxy(0, 9);
            printf("--------------------------------------");
            while (T != NULL) {
                toxy(6, j);
                printf("%-10d%-10d%d", T->ID, T->count, T->People);
                j++;
                T = T->next;
            }
            toxy(38, 12);
            printf("请选择餐桌号：");
            scanf("%d", &ID);
            toxy(40, 14);
            printf("请选择人数：");
            scanf("%d", &number);
            T = Thead;
            while (T != NULL) {
                if (T->ID == ID) {
                    if ((T->count) - (T->People) >= number) {
                        toxy(38, 16);
                        printf("占座成功！按任意键继续点餐");
                        flag = 1;
                        break;
                    } else {
                        toxy(38, 16);
                        printf("占座失败！该餐桌座位不够");
                        flag = 0;
                        break;
                    }
                }
                T = T->next;
            }
            if (T == NULL && flag == 0) {
                toxy(38, 16);
                printf("该餐桌编号不存在，请重新输入");
                Sleep(1000);
                continue;
            } else if (T != NULL && flag == 0) {
                toxy(38, 17);
                printf("是否继续 1.是 2.否");
                while (1) {
                    ch = getch();
                    if (ch == '1' || ch == '2')
                        break;
                }
                if (ch == '1')
                    continue;
                else if (ch == '2')
                    break;
            } else if (flag)
                break;
        }
        if (ch == '2')
            break;
        getch();
        do {
            system("cls");
            toxy(32, 6);
            printf("点餐");
            toxy(24, 8);
            printf("-----------------");
            toxy(28, 10);
            printf("1) 主 食");
            toxy(28, 12);
            printf("2) 副 食");
            toxy(28, 14);
            printf("3) 饮 品");
            toxy(28, 16);
            printf("4）订 单");
            toxy(28, 18);
            printf("5）返 回");
            t = getch();
            switch (t) {
                case '1':
                    Order_StapleFood();
                    break;
                case '2':
                    Order_nonStapleFood();
                    break;
                case '3':
                    Order_DrinkBeverage();
                    break;
                case '4':
                    Order_Form(ID, number);
                    break;
                case '5':
                    break;
                default:
                    break;
            }
            if (t == '5')
                break;
        } while (1);
        if (t == '5')
            break;
    } while (1);
}

void Order_StapleFood()  //主食
{
    char t;
    do {
        system("cls");
        pStapleFood p, head = readStapleFoodFile();
        pOrder p1;
        p = head;
        char foodName[20];
        int i = 8;
        toxy(10, 4);
        printf("主食菜单");
        toxy(6, 6);
        printf("菜名\t\t\t价格");
        toxy(0, 7);
        printf("-----------------------------------");
        while (p != NULL) {
            toxy(6, i);
            printf("%-22s%.2f", p->name, p->price);
            i++;
            p = p->next;
        }
        toxy(40, 8);
        printf("请输入您要点的菜名:");
        scanf("%s", foodName);
        p = head;
        while (p != NULL && strcmp(p->name, foodName) != 0) {
            p = p->next;
        }
        if (p) {
            p1 = (pOrder)malloc(Y);
            strcpy(p1->name, foodName);
            p1->price = p->price;
            num++;
            if (num == 1) {
                orderHead = p1;
                p2 = p1;
            } else {
                p2->next = p1;
                p2 = p1;
            }
            p2->next = NULL;
            toxy(40, 10);
            printf("点餐成功！是否继续？1.是 2.否");
            while (1) {
                t = getch();
                if (t == '1')
                    break;
                else if (t == '2')
                    break;
            }
            if (t == '2')
                break;
        } else {
            toxy(36, 10);
            printf("没有找到这道菜，请检查您输入的菜名是否正确！");
            Sleep(1500);
        }
    } while (1);
}

void Order_nonStapleFood()  //副食
{
    char t;
    do {
        system("cls");
        pNon_stapleFood p, head = readNonStapleFoodFile();
        pOrder p1;
        p = head;
        char foodName[20];
        int i = 8;
        toxy(10, 4);
        printf("副食菜单");
        toxy(6, 6);
        printf("菜名\t\t\t价格");
        toxy(0, 7);
        printf("-----------------------------------");
        while (p != NULL) {
            toxy(6, i);
            printf("%-22s%.2f", p->name, p->price);
            i++;
            p = p->next;
        }
        toxy(40, 8);
        printf("请输入您要点的菜名:");
        scanf("%s", foodName);
        p = head;
        while (p != NULL && strcmp(p->name, foodName) != 0) {
            p = p->next;
        }
        if (p) {
            p1 = (pOrder)malloc(Y);
            strcpy(p1->name, foodName);
            p1->price = p->price;
            num++;
            if (num == 1) {
                orderHead = p1;
                p2 = p1;
            } else {
                p2->next = p1;
                p2 = p1;
            }
            p2->next = NULL;
            toxy(36, 10);
            printf("点餐成功！是否继续？1.是 2.否");
            while (1) {
                t = getch();
                if (t == '1')
                    break;
                else if (t == '2')
                    break;
            }
            if (t == '2')
                break;
        } else {
            toxy(36, 10);
            printf("没有找到这道菜，请检查您输入的菜名是否正确！");
            Sleep(1500);
        }
    } while (1);
}

void Order_DrinkBeverage()  //饮品
{
    char t;
    do {
        system("cls");
        pDrinkBeverage p, head = readDrinkBeverageFile();
        pOrder p1;
        p = head;
        char foodName[20];
        int i = 8;
        toxy(10, 4);
        printf("饮品菜单");
        toxy(6, 6);
        printf("菜名\t\t\t价格");
        toxy(0, 7);
        printf("-----------------------------------");
        while (p != NULL) {
            toxy(6, i);
            printf("%-22s%.2f", p->name, p->price);
            i++;
            p = p->next;
        }
        toxy(40, 8);
        printf("请输入您要点的菜名:");
        scanf("%s", foodName);
        p = head;
        while (p != NULL && strcmp(p->name, foodName) != 0) {
            p = p->next;
        }
        if (p) {
            p1 = (pOrder)malloc(Y);
            strcpy(p1->name, foodName);
            p1->price = p->price;
            num++;
            if (num == 1) {
                orderHead = p1;
                p2 = p1;
            } else {
                p2->next = p1;
                p2 = p1;
            }
            p2->next = NULL;
            toxy(36, 10);
            printf("点餐成功！是否继续？1.是 2.否");
            while (1) {
                t = getch();
                if (t == '1')
                    break;
                else if (t == '2')
                    break;
            }
            if (t == '2')
                break;
        } else {
            toxy(36, 10);
            printf("没有找到这道菜，请检查您输入的菜名是否正确！");
            Sleep(1500);
        }
    } while (1);
}

void Order_Form(int ID, int number)  //订单
{
    do {
        system("cls");
        int i = 10;
        char t;
        float totalPrice = 0;
        float actualPayment = 0;
        pOrder p = orderHead;
        pUser q, head;
        pTable T, Thead;
        q = head;
        if (orderHead == NULL) {
            toxy(26, 8);
            printf("您还没有点任何东西，赶紧去点吧！(按任意键返回)");
            getch();
            break;
        } else {
            toxy(26, 6);
            printf("我的订单");
            toxy(22, 8);
            printf("菜品名称\t\t价格");
            toxy(20, 9);
            printf("***************************");
            while (p != NULL) {
                toxy(22, i);
                printf("%-18s%.2f", p->name, p->price);
                i++;
                totalPrice += p->price;
                p = p->next;
            }
            head = readUserFile();
            q = head;
            toxy(20, i);
            printf("***************************");
            while (q != NULL && strcmp(q->userName, _userName) != 0) {
                q = q->next;
            }
            if (q) {
                toxy(24, ++i);
                printf("总价： %.2f", totalPrice);
                if (q->isVIP)
                    actualPayment = totalPrice * 0.85;
                else
                    actualPayment = totalPrice;
                toxy(24, ++i);
                printf("实付： %.2f", actualPayment);
            }
            toxy(22, ++i);
            printf("1.确认支付 2.取消订单 3.返回");
            while (1) {
                t = getch();
                if (t == '1' || t == '2' || t == '3')
                    break;
            }
            if (t == '1') {
                Thead = readTableFile();
                T = Thead;
                while (T != NULL && T->ID != ID) {
                    T = T->next;
                }
                toxy(24, ++i);
                printf("正在支付....");
                if (q->money >= actualPayment) {
                    q->money -= actualPayment;
                    T->People += number;
                    Updata_User(head);
                    Updata_Table(Thead);
                    Sleep(1500);
                    system("cls");
                    toxy(24, 10);
                    printf("支付成功！按任意键返回");
                    orderHead = NULL;
                    getch();
                    break;
                } else {
                    Sleep(1500);
                    system("cls");
                    toxy(24, 10);
                    printf("余额不足！按任意键返回");
                    getch();
                    break;
                }
            } else if (t == '2') {
                orderHead = NULL;
                break;
            } else if (t == '3')
                break;
        }
    } while (1);
}

void User_List_Table()  //餐桌列表
{
    system("cls");
    pTable p, head;
    head = readTableFile();
    p = head;
    int i = 11;
    toxy(32, 6);
    printf("餐桌列表(按任意键继续)");
    toxy(22, 8);
    printf("餐桌编号 | 可坐人数 | 已坐人数");
    toxy(20, 9);
    printf("--------------------------------------");
    while (p != NULL) {
        toxy(26, i);
        printf("%-10d%-10d%d", p->ID, p->count, p->People);
        i++;
        p = p->next;
    }
    getch();
}

void Apply_VIP_Menu()  //办理会员
{
    char t;  // t用于选择
    do {
        system("cls");
        system("color 75");
        HideCursor(0);
        pUser head = readUserFile();  //从文件中读取用户信息，返回一个表头地址
        toxy(32, 6);
        printf("会员办理");
        toxy(30, 8);
        printf("1) 充值 ");
        toxy(30, 10);
        printf("2) 办理会员");
        toxy(30, 12);
        printf("3) 返回");
        t = getch();
        switch (t) {
            case '1':
                Add_money(head);
                break;
            case '2':
                Apply_VIP(head);
                break;
            case '3':
                break;
            default:
                break;
        }
        if (t ==
            '3')  //如果输入3，则跳出循环，该函数生命周期结束，回到上一级菜单
            break;
    } while (1);
}

void Add_money(pUser head)  //充值
{
    float money;  //输入要充值的钱
    pUser p;
    p = head;  // head为从 上一级菜单传过来的参数，为用户信息链表的头结点
    while (p != NULL && strcmp(p->userName, _userName) !=
                            0)  //遍历链表，寻找当前登录账户的信息
    {
        p = p->next;
    }
    while (1) {
        system("cls");
        system("color 76");
        toxy(32, 6);
        printf("南航餐饮充值中心");
        if (p != NULL) {
            if (p->isVIP == 0)  //如果不是会员
            {
                toxy(20, 8);
                printf("对不起，您还不是会员，请先办理会员后再来充值！");
                toxy(32, 10);
                printf("请按任意键返回!");
                break;
            } else if (p->isVIP == 1)  //如果是会员
            {
                HideCursor(1);
                toxy(32, 8);
                printf("请输入充值金额（一次不少于200）：");
                scanf("%f", &money);
                if (money >= 200)  //如果充值金额大于200
                {
                    p->money += money;
                    toxy(32, 10);
                    printf("正在充值....");
                    Updata_User(head);  //更新用户表
                    toxy(32, 10);
                    printf("充值成功 ");
                    toxy(32, 12);
                    printf("请按任意键返回!");
                    break;
                } else  //如果充值金额小于200
                {
                    toxy(32, 10);
                    printf("一次至少充值200元！");
                    Sleep(1500);
                    continue;
                }
            }
        }
    }
    getch();
}

void Apply_VIP(pUser head)  //办理会员
{
    system("cls");
    system("color 76");
    pUser p = head;  // head为从 上一级菜单传过来的参数，为用户信息链表的头结点
    char t;
    float money;
    toxy(32, 6);
    printf("南航餐饮会员办理中心");
    while (p != NULL && strcmp(p->userName, _userName) !=
                            0)  //遍历链表，寻找当前登录账户的信息
    {
        p = p->next;
    }
    do {
        if (p != NULL) {
            if (p->isVIP == 1)  //如果已经是会员
            {
                toxy(20, 8);
                printf("您已是本店尊贵会员，无需再次办理！");
                toxy(32, 10);
                printf("请按任意键返回!");
                getch();
                break;
            } else if (p->isVIP == 0)  //如果还没办理会员
            {
                toxy(30, 8);
                printf("提示：");
                toxy(30, 9);
                printf("1.办理会员至少充值500");
                toxy(30, 10);
                printf("2.冲500送200，冲1000送500");
                toxy(32, 12);
                printf("是否确认办理会员？");
                toxy(32, 13);
                printf("1.是\t2.否");
                while (1) {
                    t = getch();
                    if (t == '1')
                        break;
                    else if (t == '2')
                        break;
                }
                if (t == '1') {
                    while (1) {
                        system("cls");
                        HideCursor(1);
                        toxy(32, 10);
                        printf("请输入充值金额：");
                        scanf("%f", &money);
                        if (money >= 500 && money < 1000) {
                            money += 200;
                            p->money += money;
                            p->isVIP = 1;
                            Updata_User(head);
                            toxy(32, 12);
                            printf("恭喜，您已成为本店尊贵会员！");
                            toxy(32, 14);
                            printf("请按任意键返回主菜单");
                            getch();
                            User_Menu();
                        } else if (money >= 1000) {
                            money += 500;
                            p->money += money;
                            p->isVIP = 1;
                            Updata_User(head);
                            toxy(32, 12);
                            printf("恭喜，您已成为本店尊贵会员！");
                            toxy(32, 14);
                            printf("请按任意键返回主菜单");
                            getch();
                            User_Menu();
                        } else {
                            toxy(32, 12);
                            printf("办理会员至少充值500");
                            Sleep(2000);
                        }
                    }
                } else if (t == '2')
                    break;
            }
        }
    } while (1);
}

void Updata_User(pUser head)  //更新文件
{
    FILE* fp;
    pUser p = head->next;  //使p指向第二个结点
    fp = fopen("User.txt", "w");  //先清空原文件内容再将修改后的信息写入文件
    if (fp == NULL) {
        printf("cannot open file\n");
    }
    if (fwrite(head, M, 1, fp) != 1)  //将head所指向的数据写入fp所指向的文件
    {
        printf("file write error\n");
    }
    fclose(fp);                   //关闭文件
    fp = fopen("User.txt", "a");  // 打开User.txt文件，方式为追加
    while (p != NULL)             // p不为空就执行循环体
    {
        if (fwrite(p, M, 1, fp) !=
            1)  //将p所指向的1个大小为N的数据结构写入fp所指向的文件
        {
            printf("file write error\n");
        }
        p = p->next;  //使p指向下一个结点
    }
    fclose(fp);  //关闭文件
}

void Amend_passWord()  //修改密码
{
    system("cls");  //清屏
    HideCursor(0);  //隐藏光标，看着更舒服
    pUser p, head;
    head = readUserFile();
    do {
        p = head;
        char password[18], newpassword[18], t, k, *q1, *q2;
        int i = 0;
        toxy(34, 5);  //将光标移动到坐标为（50，5）的位置
        printf("南航餐饮点餐系统");
        toxy(34, 8);
        printf("修改密码");
        toxy(32, 10);
        printf("请输入旧密码：");
        q1 = HidePassword();
        strcpy(password, q1);
        toxy(32, 12);
        printf("请输入新密码：");
        q2 = HidePassword();
        strcpy(newpassword, q2);
        while (p != NULL && strcmp(p->userName, _userName) !=
                                0)  //遍历链表，寻找当前登陆账户的账号
        {
            p = p->next;
        }
        if (p != NULL)  //如果p不为空
        {
            if (strcmp(p->passWord, password) == 0)  //如果旧密码输入正确
            {
                strcpy(p->passWord, newpassword);  //将旧密码改为新密码
                break;                             //跳出循环
            } else                                 //如果旧密码输入错误
            {
                system("cls");
                toxy(30, 8);
                printf("--------------------------");
                toxy(30, 9);
                printf("|   |");
                toxy(30, 10);
                printf("| 密码错误！是否继续？ |");
                toxy(30, 11);
                printf("|   |");
                toxy(30, 12);
                printf("| 1.是  2.否 |");
                toxy(30, 13);
                printf("|   |");
                toxy(30, 14);
                printf("--------------------------");
                while (1) {
                    t = getch();  //输入t
                    if (t == '1') {
                        system("cls");
                        break;
                    } else if (t == '2')
                        User_Menu();
                }
            }
        }
    } while (1);        //永远为真
    Updata_User(head);  //修改密码
    toxy(32, 14);
    printf("修改成功！正在跳转...");
    Sleep(500);  //暂停0.5秒
}

void User_Wallet()  //我的钱包
{
    system("cls");
    system("color 78");
    pUser p, head;
    head = readUserFile();
    p = head;
    while (p != NULL && strcmp(p->userName, _userName) != 0) {
        p = p->next;
    }
    if (p != NULL) {
        toxy(32, 10);
        printf("账户余额为：%.2f", p->money);
        toxy(32, 12);
        printf("请按任意键返回");
    }
    getch();
}

void Change()  //切换账号
{
    system("cls");
    Default();
}

void Exit()  //退出点餐系统
{
    char t;
    toxy(30, 10);
    printf("-----------------------");
    toxy(30, 11);
    printf("| 您确定要退出吗？ |");
    toxy(30, 13);
    printf("| 1.确定 2.取消 |");
    toxy(30, 14);
    printf("-----------------------");
    while (1) {
        t = getch();  //输入t
        switch (t) {
            case '1':
                system("cls");
                toxy(32, 10);
                printf("正在安全退出....");
                Sleep(1000);  //暂停1秒
                system("cls");
                toxy(32, 10);
                printf("已安全退出软件");
                toxy(32, 12);
                printf("谢谢使用！");
                toxy(32, 14);
                printf("by-by^_^");
                exit(0);
                break;  //终止程序
            case '2':
                break;  //调用函数，进入菜单
            default:
                break;
        }
        if (t == '2')
            break;
    }
}

void Administrator_Menu()  //管理员菜单
{
    char t;  //用于选择菜单选项
    do {
        system("cls");
        HideCursor(0);  //隐藏光标
        system("color 74");
        toxy(32, 3);
        printf("南航餐饮管理系统！");
        toxy(32, 4);
        printf("当前管理员：%s", _userName);
        toxy(30, 5);
        printf("*********************");
        toxy(32, 7);
        printf("| 1.菜品 信息 |");
        toxy(32, 9);
        printf("| 2.餐桌 管理 |");
        toxy(32, 11);
        printf("| 3.查看 用户 |");
        toxy(32, 13);
        printf("| 4.本店 会员 |");
        toxy(32, 15);
        printf("| 5.设置管理员 |");
        toxy(32, 17);
        printf("| 6.修改 密码 |");
        toxy(32, 19);
        printf("| 7.切换 账号 |");
        toxy(32, 21);
        printf("| 8.退出 系统 |");
        t = getch();  //不回显函数，输入一个值
        switch (t) {
            case '1':
                Food();
                break;
            case '2':
                Table();
                break;
            case '3':
                Check_User();
                break;
            case '4':
                All_VIP();
                break;
            case '5':
                Setup_administrator();
                break;
            case '6':
                Amend_passWord();
                break;
            case '7':
                Change();
                break;
            case '8':
                Exit();
                break;
            default:
                break;
        }
    } while (1);  //永远 为真
}

void Administrator_Login()  //管理员登录
{
    char *q, t, c;  // q指针用于接收
                    // *HidePassword()函数返回的指向密码的指针，t和c均用于选择
    pUser p = readUserFile();  //从文件中读取用户信息，返回一个表头地址
    do {
        HideCursor(1);       //显示管光标
        system("cls");       //清屏
        system("color 73");  //设置颜色
        toxy(28, 8);
        printf("南航餐饮管理员登录界面");
        toxy(26, 9);
        printf("-----------------------------");
        toxy(32, 11);
        printf("用户名:");
        toxy(32, 13);
        printf("密 码:");
        toxy(40, 11);
        scanf("%s", _userName);
        toxy(40, 13);
        q = HidePassword();    //输入密码
        strcpy(_passWord, q);  //将获得的密码复制给_passWord[]数组
        while (p != NULL && strcmp(p->userName, _userName) !=
                                0)  //遍历链表，寻找当前输入的账户的账号
        {
            p = p->next;
        }
        if (p != NULL)  //如果p不为空
        {
            if (strcmp(p->passWord, _passWord) == 0 &&
                p->isAdministrator == 1)  //如果输入的密码正确
            {
                toxy(32, 16);
                printf("正在登陆....");
                Sleep(500);  //暂停0.5秒
                system("cls");
                toxy(32, 10);
                printf("登陆成功！");
                break;  //跳出循环
            } else      //如果输入的密码错误
            {
                toxy(32, 16);
                printf("正在登陆....");
                Sleep(500);
                system("cls");
                toxy(30, 8);
                printf("-------------------------");
                toxy(30, 9);
                printf("|   |");
                toxy(30, 10);
                printf("| 密码错误！是否继续？ |");
                toxy(30, 12);
                printf("| 1.是  2.否 |");
                toxy(30, 13);
                printf("|   |");
                toxy(30, 14);
                printf("-------------------------");
                while (1)  //无限循环为防止其他按键干扰
                {
                    t = getch();  //输入t
                    if (t == '1') {
                        system("cls");  //清屏
                        break;
                    } else if (t == '2')  //如果输入t为n，进入开始界面
                    {
                        system("cls");  //清屏
                        Default();
                        break;
                    }
                }
            }
        } else  //如果p为空，即输入的账号不正确
        {
            toxy(32, 16);
            printf("正在登陆....");
            Sleep(500);
            system("cls");
            toxy(30, 8);
            printf("-------------------------");
            toxy(30, 9);
            printf("|   |");
            toxy(30, 10);
            printf("| 账号错误！是否继续？ |");
            toxy(30, 11);
            printf("|   |");
            toxy(30, 12);
            printf("| 1.是  2.否 |");
            toxy(30, 13);
            printf("|   |");
            toxy(30, 14);
            printf("-------------------------");
            while (1)  //死循环防止其他按键干扰
            {
                c = getch();
                if (c == '1') {
                    system("cls");
                    break;
                } else if (c == '2') {
                    system("cls");  //清屏
                    Default();
                }
            }
        }
    } while (1);
    Sleep(500);            //暂停0.5秒
    Administrator_Menu();  //账号密码均正确，进入管理员主菜单
}

void Food()  //菜品信息
{
    system("color 74");
    char t;
    do {
        system("cls");
        toxy(32, 6);
        printf("菜品信息");
        toxy(28, 7);
        printf("-----------------");
        toxy(30, 9);
        printf(" 1) 添加菜单");
        toxy(30, 11);
        printf(" 2) 菜单列表");
        toxy(30, 13);
        printf(" 3) 返回上一级");
        t = getch();
        switch (t) {
            case '1':
                Add_Food();
                break;
            case '2':
                List_Food();
                break;
            case '3':
                break;
            default:
                break;
        }
        if (t == '3')
            break;
    } while (1);
}

void save_stapleFood(pStapleFood p)  //保存主食信息
{
    FILE* fp;                            //文件指针
    fp = fopen("StapleFood.txt", "a+");  //以追加的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    }
    if (fwrite(p, N, 1, fp) !=
        1)  //将p1所指向的1个大小为N的数据结构写入fp所指向的文件中
    {
        printf("file write error\n");
    }
    fclose(fp);  //关闭文件
}

void save_non_stapleFood(pNon_stapleFood p)  //保存副食信息
{
    FILE* fp;                                //文件指针
    fp = fopen("non_StapleFood.txt", "a+");  //以追加的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    }
    if (fwrite(p, P, 1, fp) !=
        1)  //将p1所指向的1个大小为N的数据结构写入fp所指向的文件中
    {
        printf("file write error\n");
    }
    fclose(fp);  //关闭文件
}

void save_drinkBeverage(pDrinkBeverage p)  //保存饮品信息
{
    FILE* fp;                               //文件指针
    fp = fopen("DrinkBeverage.txt", "a+");  //以追加的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    }
    if (fwrite(p, Q, 1, fp) !=
        1)  //将p1所指向的1个大小为N的数据结构写入fp所指向的文件中
    {
        printf("file write error\n");
    }
    fclose(fp);  //关闭文件
}

pStapleFood readStapleFoodFile()  //从主食文件中读取用户信息，返回一个表头地址
{
    FILE* fp;                 //文件指针
    int n = 0;                //记录链表 的结点数
    pStapleFood head = NULL;  //定义头指针
    pStapleFood p2, p, pre;
    fp = fopen("StapleFood.txt", "a+");  //以只读的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    } else {
        while (!feof(fp))  //判断文件位置标志是否移动到文件末尾
        {
            n++;
            p = (pStapleFood)malloc(N);  //向内存申请一段空间
            fread(p, N, 1, fp);  //将fp所指向的文件中的内容赋给p
            if (n == 1) {
                head = p;
                p2 = p;
            } else  //创建链表
            {
                pre = p2;
                p2->next = p;
                p2 = p;
            }
        }
        p2->next = NULL;
    }
    if (n <= 2)
        head->next = NULL;
    else
        pre->next = NULL;
    fclose(fp);   //关闭文件
    return head;  //返回头指针
}

pNon_stapleFood
readNonStapleFoodFile()  //从副食文件中读取用户信息，返回一个表头地址
{
    FILE* fp;                     //文件指针
    int n = 0;                    //记录链表 的结点数
    pNon_stapleFood head = NULL;  //定义头指针
    pNon_stapleFood p2, p, pre;
    fp = fopen("non_StapleFood.txt", "a+");  //以只读的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    } else {
        while (!feof(fp))  //判断文件位置标志是否移动到文件末尾
        {
            n++;
            p = (pNon_stapleFood)malloc(P);  //向内存申请一段空间
            fread(p, P, 1, fp);  //将fp所指向的文件中的内容赋给p
            if (n == 1) {
                head = p;
                p2 = p;
            } else  //创建链表
            {
                pre = p2;
                p2->next = p;
                p2 = p;
            }
        }
        p2->next = NULL;
    }
    if (n <= 2)
        head->next = NULL;
    else
        pre->next = NULL;
    fclose(fp);   //关闭文件
    return head;  //返回头指针
}

pDrinkBeverage
readDrinkBeverageFile()  //从饮品文件中读取用户信息，返回一个表头地址
{
    FILE* fp;                    //文件指针
    int n = 0;                   //记录链表 的结点数
    pDrinkBeverage head = NULL;  //定义头指针
    pDrinkBeverage p2, p, pre;
    fp = fopen("DrinkBeverage.txt", "a+");  //以只读的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    } else {
        while (!feof(fp))  //判断文件位置标志是否移动到文件末尾
        {
            n++;
            p = (pDrinkBeverage)malloc(Q);  //向内存申请一段空间
            fread(p, Q, 1, fp);  //将fp所指向的文件中的内容赋给p
            if (n == 1) {
                head = p;
                p2 = p;
            } else  //创建链表
            {
                pre = p2;
                p2->next = p;
                p2 = p;
            }
        }
        p2->next = NULL;
    }
    if (n <= 2)
        head->next = NULL;
    else
        pre->next = NULL;
    fclose(fp);   //关闭文件
    return head;  //返回头指针
}

void Add_Food()  //添加菜单
{
    HideCursor(1);       //显示光标
    pStapleFood p1;      //主食
    pNon_stapleFood p2;  //副食
    pDrinkBeverage p3;   //饮品
    char name[20];
    float price = 0;
    int type = 1;
    char t;
    do {
        system("cls");
        p1 = (pStapleFood)malloc(N);
        p2 = (pNon_stapleFood)malloc(P);
        p3 = (pDrinkBeverage)malloc(Q);
        toxy(30, 6);
        printf("请输入菜名:");
        toxy(30, 8);
        printf("请输入价格:");
        toxy(30, 10);
        printf("请输入类型:");
        toxy(30, 12);
        printf("(1:主食 2.副食 3.饮品)");
        toxy(42, 6);
        scanf("%s", name);
        toxy(42, 8);
        scanf("%f", &price);
        toxy(42, 10);
        scanf("%d", &type);
        if (type == 1) {
            strcpy(p1->name, name);
            p1->price = price;
            save_stapleFood(p1);
        } else if (type == 2) {
            strcpy(p2->name, name);
            p2->price = price;
            save_non_stapleFood(p2);
        } else if (type == 3) {
            strcpy(p3->name, name);
            p3->price = price;
            save_drinkBeverage(p3);
        }
        toxy(28, 14);
        printf("添加成功！是否继续？(1.是 2.否)");
        while (1) {
            t = getch();
            if (t == '1')
                break;
            else if (t == '2')
                break;
        }
        if (t == '2')
            break;
    } while (1);
}

void List_Food()  //菜单列表
{
    system("cls");
    int i = 8;
    toxy(30, 4);
    printf("菜单列表(按任意键继续)");
    pStapleFood p1;      //主食
    pNon_stapleFood p2;  //副食
    pDrinkBeverage p3;   //饮品
    p1 = readStapleFoodFile();  //从主食文件中读取用户信息，返回一个表头地址
    p2 = readNonStapleFoodFile();  //从副食文件中读取用户信息，返回一个表头地址
    p3 = readDrinkBeverageFile();  //从饮品文件中读取用户信息，返回一个表头地址
    toxy(26, 6);
    printf("菜名\t\t\t价格");
    toxy(20, 7);
    printf("-----------------------------------");
    toxy(24, i);
    printf("主食：");
    i++;
    while (p1 != NULL) {
        toxy(26, i);
        printf("%-22s%.2f", p1->name, p1->price);
        i++;
        p1 = p1->next;
    }
    toxy(24, i);
    printf("副食：");
    i++;
    while (p2 != NULL) {
        toxy(26, i);
        printf("%-22s%.2f", p2->name, p2->price);
        i++;
        p2 = p2->next;
    }
    toxy(24, i);
    printf("饮品：");
    i++;
    while (p3 != NULL) {
        toxy(26, i);
        printf("%-22s%.2f", p3->name, p3->price);
        i++;
        p3 = p3->next;
    }
    getch();
}

void Table()  //餐桌管理
{
    char t;
    do {
        system("cls");
        HideCursor(0);
        toxy(32, 4);
        printf("餐桌管理");
        toxy(26, 5);
        printf("-------------------");
        toxy(30, 7);
        printf("1) 添加餐桌");
        toxy(30, 9);
        printf("2) 餐桌列表");
        toxy(30, 11);
        printf("3) 清理餐桌");
        toxy(30, 13);
        printf("4) 返回上一级");
        t = getch();
        switch (t) {
            case '1':
                Add_Table();
                break;
            case '2':
                Administrator_List_Table();
                break;
            case '3':
                Clear_Table();
                break;
            case '4':
                break;
            default:
                break;
        }
        if (t == '4')
            break;
    } while (1);
}

void save_Table(pTable p)  //保存餐桌信息
{
    FILE* fp;                       //文件指针
    fp = fopen("Table.txt", "a+");  //以追加的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    }
    if (fwrite(p, X, 1, fp) !=
        1)  //将p1所指向的1个大小为N的数据结构写入fp所指向的文件中
    {
        printf("file write error\n");
    }
    fclose(fp);  //关闭文件
}

pTable readTableFile()  //从餐桌文件中读取用户信息，返回一个表头地址
{
    FILE* fp;            //文件指针
    int n = 0;           //记录链表 的结点数
    pTable head = NULL;  //定义头指针
    pTable p2, p, pre;
    fp = fopen("Table.txt", "a+");  //以只读的方式打开文件
    if (fp == NULL) {
        printf("cannot open file\n");
    } else {
        while (!feof(fp))  //判断文件位置标志是否移动到文件末尾
        {
            n++;
            p = (pTable)malloc(X);  //向内存申请一段空间
            fread(p, X, 1, fp);     //将fp所指向的文件中的内容赋给p
            if (n == 1) {
                head = p;
                p2 = p;
            } else  //创建链表
            {
                pre = p2;
                p2->next = p;
                p2 = p;
            }
        }
        p2->next = NULL;
    }
    if (n <= 2)
        head->next = NULL;
    else
        pre->next = NULL;
    fclose(fp);   //关闭文件
    return head;  //返回头指针
}

void Add_Table()  //添加餐桌
{
    HideCursor(1);  //显示光标
    pTable p, p1;
    p1 = readTableFile();
    char t;
    int ID;
    int count;
    do {
        system("cls");
        p = (pTable)malloc(X);
        toxy(26, 6);
        printf("请输入餐桌编号:");
        toxy(26, 8);
        printf("请输入可坐人数:");
        toxy(42, 6);
        scanf("%d", &ID);
        toxy(42, 8);
        scanf("%d", &count);
        while (p1 != NULL && p1->ID != ID) {
            p1 = p1->next;
        }
        if (p1 != NULL) {
            toxy(30, 10);
            printf("该餐桌编号已存在，请重新输入！");
            Sleep(2000);
            continue;
        }
        p->ID = ID;
        p->People = 0;
        p->count = count;
        strcpy(p->Username, "无");
        save_Table(p);
        toxy(24, 10);
        printf("添加成功！是否继续？(1.是 2.否)");
        while (1) {
            t = getch();
            if (t == '1')
                break;
            else if (t == '2')
                break;
        }
        if (t == '2')
            break;
    } while (1);
}

void Administrator_List_Table()  //餐桌列表
{
    system("cls");
    pTable p, head;
    head = readTableFile();
    p = head;
    int i = 11;
    toxy(32, 6);
    printf("餐桌列表(按任意键继续)");
    toxy(22, 8);
    printf("餐桌编号 | 可坐人数 | 已坐人数 | 订餐人");
    toxy(20, 9);
    printf("--------------------------------------------");
    while (p != NULL) {
        toxy(26, i);
        printf("%-10d%-10d%-10d%s", p->ID, p->count, p->People, p->Username);
        i++;
        p = p->next;
    }
    getch();
}

void Clear_Table()  //清理餐桌
{
    char t;
    do {
        system("cls");
        toxy(32, 4);
        printf("清理餐桌");
        toxy(26, 5);
        printf("-------------------");
        toxy(30, 7);
        printf("1) 清理指定餐桌");
        toxy(30, 9);
        printf("2) 清理所有餐桌");
        toxy(30, 11);
        printf("3) 返回上一级");
        t = getch();
        switch (t) {
            case '1':
                Clear_oneTable();
                break;
            case '2':
                Clear_allTable();
                break;
            case '3':
                break;
            default:
                break;
        }
        if (t == '3')
            break;
    } while (1);
}

void Updata_Table(pTable head)  //更新餐桌文件
{
    FILE* fp;
    pTable p = head->next;  //使p指向第二个结点
    fp = fopen("Table.txt", "w");  //先清空原文件内容再将修改后的信息写入文件
    if (fp == NULL) {
        printf("cannot open file\n");
    }
    if (fwrite(head, X, 1, fp) != 1)  //将head所指向的数据写入fp所指向的文件
    {
        printf("file write error\n");
    }
    fclose(fp);                    //关闭文件
    fp = fopen("Table.txt", "a");  // 打开User.txt文件，方式为追加
    while (p != NULL)              // p不为空就执行循环体
    {
        if (fwrite(p, X, 1, fp) !=
            1)  //将p所指向的1个大小为N的数据结构写入fp所指向的文件
        {
            printf("file write error\n");
        }
        p = p->next;  //使p指向下一个结点
    }
    fclose(fp);  //关闭文件
}

void Clear_oneTable()  //清理指定餐桌
{
    int ID;
    pTable p, head;
    char t;
    do {
        system("cls");
        head = readTableFile();
        p = head;
        toxy(28, 8);
        printf("请输入您要清理的餐桌编号:");
        scanf("%d", &ID);
        while (p != NULL && p->ID != ID) {
            p = p->next;
        }
        if (p) {
            toxy(32, 10);
            printf("正在清理....");
            p->People = 0;
            strcpy(p->Username, "无");
            Updata_Table(head);
            Sleep(2000);
            toxy(24, 10);
            printf("清理成功！是否继续？1.是 2.否");
            while (1) {
                t = getch();
                if (t == '1')
                    break;
                else if (t == '2')
                    break;
            }
            if (t == '2')
                break;
        } else {
            toxy(32, 10);
            printf("该餐桌不存在！请重新输入");
            Sleep(1500);
        }
    } while (1);
}

void Clear_allTable()  //清理所有餐桌
{
    system("cls");
    toxy(32, 10);
    printf("正在清理....");
    pTable p, head;
    head = readTableFile();
    p = head;
    while (p != NULL) {
        p->People = 0;
        strcpy(p->Username, "无");
        p = p->next;
    }
    Updata_Table(head);
    Sleep(2000);
    toxy(32, 10);
    printf("清理成功！按任意键继续");
    getch();
}

void Check_User()  //查看用户
{
    char t;
    do {
        system("cls");
        system("color 79");
        toxy(32, 6);
        printf(" 查看用户 ");
        toxy(32, 7);
        printf("----------------");
        toxy(32, 9);
        printf(" 1) 查找用户 ");
        toxy(32, 11);
        printf(" 2) 所有用户 ");
        toxy(32, 13);
        printf(" 3）返回上一级");
        t = getch();
        switch (t) {
            case '1':
                Find_User();
                break;
            case '2':
                All_User();
                break;
            case '3':
                break;
            default:
                break;
        }
        if (t == '3')
            break;
    } while (1);
}

void Find_User()  //查找用户
{
    system("cls");
    char username[10];
    pUser p, head = readUserFile();
    p = head;
    toxy(32, 10);
    printf("请输入您要查找的用户名：");
    scanf("%s", username);
    toxy(24, 12);
    printf("用户名\t\t余额\t\t会员状态");
    while (p != NULL && strcmp(p->userName, username) != 0)
        p = p->next;
    if (p != NULL) {
        toxy(24, 14);
        printf("%s\t\t%.2f\t\t%d", p->userName, p->money, p->isVIP);
    } else {
        toxy(28, 14);
        printf("没有找到相关信息");
    }
    toxy(30, 16);
    printf("请按任意键返回");
    getch();
}

void All_User()  //打印所有用户信息
{
    system("cls");
    pUser p, head;
    head = readUserFile();
    p = head;
    int i = 9;
    toxy(32, 4);
    printf("所有用户");
    toxy(20, 5);
    printf("--------------------------------------------------");
    toxy(30, 6);
    printf("按任意键返回");
    toxy(24, 7);
    printf("用户名\t\t余额\t\t会员状态");
    while (p != NULL) {
        toxy(24, i);
        printf("%s\t\t%.2f\t\t%d", p->userName, p->money, p->isVIP);
        p = p->next;
        i += 2;
    }
    getch();
}

void All_VIP()  //查看所有VIP
{
    system("cls");
    system("color 79");
    pUser p, head;
    head = readUserFile();
    p = head;
    int i = 11;
    toxy(32, 6);
    printf("本店会员");
    toxy(26, 8);
    printf("用户名\t\t余额");
    toxy(24, 9);
    printf("--------------------------------");
    while (p != NULL) {
        if (p->isVIP) {
            toxy(26, i);
            printf("%s\t\t\t%.2f", p->userName, p->money);
            i += 2;
        }
        p = p->next;
    }
    toxy(30, i);
    printf("按任意键返回");
    getch();
}

void Setup_administrator()  //设置管理员
{
    system("color 80");
    char t;
    char username[10];
    pUser p, head;
    head = readUserFile();
    do {
        system("cls");
        p = head;
        toxy(26, 8);
        printf("请输入您要设置为管理员的用户名：");
        scanf("%s", username);
        while (p != NULL && strcmp(p->userName, username) != 0) {
            p = p->next;
        }
        if (p != NULL) {
            p->isAdministrator = 1;
            Updata_User(head);
            toxy(32, 10);
            printf("设置成功!请按任意键返回");
            getch();
            break;
        } else {
            toxy(24, 10);
            printf("您所输入的用户名不存在！是否继续？(1.是 2.否)");
            while (1) {
                t = getch();
                if (t == '1')
                    break;
                else if (t == '2')
                    break;
            }
            if (t == '2')
                break;
        }
    } while (1);
}

int main() {
    Default();  //进入欢迎界面
    return 0;
}