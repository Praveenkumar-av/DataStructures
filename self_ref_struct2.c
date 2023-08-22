#include<stdio.h>

struct node 
{
	int a;
	struct node *prev_link, *next_link;
};
void main()
{
	struct node obj1;  // Node 1
	obj1.a=10;
	obj1.prev_link=NULL;
	obj1.next_link=NULL;
	
	struct node obj2;  // Node 2
	obj2.a=20;
	obj2.prev_link=NULL;
	obj2.next_link=NULL;
	
	struct node obj3;  // Node 3
	obj3.a=30;
	obj3.prev_link=NULL;
	obj3.next_link=NULL;
	
	// forward links
	obj1.next_link=&obj2;
	obj2.next_link=&obj3;
	
	// Backward links
	obj2.prev_link=&obj1;
	obj3.prev_link=&obj2;
	
	// accessing elements using obj1
	printf("obj1 a :%d",obj1.a);
	printf("\nobj2 a :%d",obj1.next_link->a);
	printf("\nobj3 a :%d",obj1.next_link->next_link->a);
	
	// accessing elements using obj2
	printf("\nobj1 a :%d",obj2.prev_link->a);
	printf("\nobj2 a :%d",obj2.a);
	printf("\nobj3 a :%d",obj2.next_link->a);
	
	// accessing elements using obj3
	printf("\nobj1 a :%d",obj3.prev_link->prev_link->a);
	printf("\nobj2 a :%d",obj3.prev_link->a);
	printf("\nobj3 a :%d",obj3.a);	
}
