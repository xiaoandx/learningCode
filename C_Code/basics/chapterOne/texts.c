#include <stdio.h>
int main()
{
    int a=10;
    int status = 0;
    if(a>=3){
        for (int i = 2; i < a; i++){
            if (a % i == 0){
                status = 1;
                break;
            }
        }
        if(status == 0){
            printf("该数为素数\n");
        }else{
            printf("该数不为素bai数du\n");
        }
        
    }else{
        printf("该数不符合要求\n");
    }
    
    
    return 0;
}
