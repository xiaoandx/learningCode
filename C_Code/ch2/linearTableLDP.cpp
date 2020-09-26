#include <iostream>
#include<stdlib.h>
using namespace std;
typedef struct LNod
{
	int data;
	struct LNod *next;
}LNode,*LinkList;

int InitList(LinkList &L);
void TraveList(LinkList L);
int ListInsert(LinkList L,int i,int data);
int ListDete(LinkList L,int i,int &var);
int ListEmpty(LinkList L);
int ListFind(LinkList L,int data);

int main(int argc, char *argv[]) {
	LinkList L;
	int i,var;
	i=InitList(L);
	TraveList(L);
	ListInsert(L,1,12);
	ListInsert(L,1,13);
	ListInsert(L,1,14);
	ListInsert(L,1,15);
	TraveList(L);
	ListInsert(L,3,150);
	TraveList(L);
	ListDete(L,3,var);
	TraveList(L);
	cout<<"Empty?"<<ListEmpty(L)<<endl;
	cout<<"Find 15 in L:"<<ListFind(L,13)<<endl;
	
		
	return 0;
}
int InitList(LinkList &L)
{
	L=(LNode *)malloc(sizeof(LNode));
	if(!L)
	  return 0;
	  
	L->next=NULL; 
	return 1;
}
void TraveList(LinkList L)
{
	LinkList p;
	p=L->next;
	while(p!=NULL)
	{
		cout<<p->data<<"  ";
		p=p->next;		
	}
	cout<<endl;
}
int ListInsert(LinkList L,int i,int data)
{
	LinkList p,s;
	int j=0;
	p=L;
	while(p!=NULL&&j<i-1)
	{
		p=p->next;
		j=j+1;
	}
	if(p==NULL||j>i-1) return 0;
	
	s=(LNode *)malloc(sizeof(LNode));
	
	if(!s)  return 0;
	
	s->data=data;
	s->next=p->next;
	p->next=s;
	return 1;	
}

int ListDete(LinkList L,int i,int &var)
{
	LinkList p,s;
	int j=0;
	p=L;
	while(p!=NULL&&j<i-1)
	{
		p=p->next;
		j=j+1;
	}
	if(p==NULL||j>i-1) return 0;
	
	s=p->next;
	var=s->data;
	p->next=s->next;
	free(s);
	return 1;
}

int ListEmpty(LinkList L)
{
	if(L->next==NULL)
	   return 0;
	else
	   return 1;   
}

int ListFind(LinkList L,int data)
{
	LinkList p;
	int j=1;
	p=L->next;
	while(p!=NULL)
	{
		if(p->data==data)
		   return j;
		p=p->next;
		j=j+1;		
	}
	
	return 0;
	
}