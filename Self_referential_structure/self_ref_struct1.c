//  Self Referential Structure with Single Link

#include<stdio.h>

struct node
{
	int a, b;
	struct node *link;  // pointer to the same structure
};
void main()
{
	struct node obj1;  // Node 1
	obj1.a=10;
	obj1.b=20;
	obj1.link=NULL;
	
	struct node obj2;  // Node 2
	obj2.a=30;
	obj2.b=40;
	obj2.link=NULL;
	
	// linking obj1 and obj2
	obj1.link=&obj2;
	
	// Accessing all values from obj1
	printf("a :%d",obj1.a);
	printf("\nb :%d",obj1.b);
	printf("\nc :%d",obj1.link->a);
	printf("\nd :%d",obj1.link->b);
}
