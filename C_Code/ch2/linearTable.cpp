#include <iostream>
#include<stdlib.h>
#define LIST_INIT_SIZE 100
#define LISTINC 20
using namespace std;

typedef struct {
   int *elem;
   int length;
   int listsize;
}SqList;

int InitList(SqList &L);
void ListTraverse(SqList L);
int ListInsert(SqList &L,int i,int data);
int ListDelete(SqList &L,int i,int &var);

int main(int argc, char *argv[]) {
	SqList L;
	int i;
	int var;
	InitList(L);
	ListTraverse(L);
	ListInsert(L,1,12);
	ListInsert(L,1,13);
	ListInsert(L,1,15);
	ListInsert(L,1,17);
	ListInsert(L,1,19);
	cout<<"shanchuzhiqian:"<<endl;
	ListTraverse(L);
	ListDelete(L,3,var);
	cout<<endl;
	cout<<"shanchuzhihou:"<<endl;
	ListTraverse(L);
		
	return 0;
}

int InitList(SqList &L)
{
	L.elem=(int *)malloc(LIST_INIT_SIZE*sizeof(int));
	if(!L.elem)
	   return 0;
	L.length=0;
	L.listsize=LIST_INIT_SIZE;
	return 1;	
}
void ListTraverse(SqList L)
{
	int i;
    for(i=0;i<L.length;i++)
	{
		cout<<L.elem[i]<<"   ";
	}	
}

int ListInsert(SqList &L,int i,int data)
{
	int j;
   if(i<1||i>L.length+1)
      return 0;
    
    if(L.length==L.listsize)
    {
    	int *base;
	   base=(int *)realloc(L.elem,(L.listsize+LISTINC)*sizeof(int));
	   if(!base)
	      return 0;
	      
	   L.listsize=L.listsize+LISTINC;
	}
	
	for(j=L.length;j>=i-1;j--)
	{
		L.elem[j]=L.elem[j-1];
	}
	L.elem[i-1]=data;
	L.length=L.length+1;
	
	return 1;  
} 

int ListDelete(SqList &L,int i,int &var)
{
	int j;
	if(i<1||i>L.length)
	  return 0;
	
	var=L.elem[i-1];
	for(j=i;j<L.length;j++)
	{
	   L.elem[j-1]=L.elem[j];
	} 
	L.length=L.length-1;
	return 1;
}













