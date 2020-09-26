#include <iostream>
#include <stdio.h>
using namespace std;


/*主函数*/ 
int main() {
	int arr[10];
	int i = 0,j,temp;
	cout<<"input 10 number："<<endl;
	
	for(i=0;i<=9;i++){
		cin>>arr[i];
	}
	
	for(i=0;i<=8;i++){
		for(j=i+1;j<=9;j++){
			
			if(arr[i]<arr[j]){
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	for(i=0;i<=9;i++){
		cout<<arr[i]<<" ";
	}
	system("pause");
	return 0;
}


