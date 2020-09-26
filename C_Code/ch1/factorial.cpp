#include<iostream>
using namespace std;

long getFactorial(int a);
int main(){
    int a,i;
    long sum = 1;
    cout<<"input one number:"<<endl;
    cin>>a;
    sum = getFactorial(a);
    cout<<a<<"!="<<sum<<endl;
    system("pause");
    return 0;
}

long getFactorial(int a){   
    if (a==1){
        return 1;
    }
    return a * getFactorial(a-1);
}