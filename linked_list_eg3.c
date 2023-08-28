#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int a;
	struct Node *next;
	struct Node *prev;
}*head=NULL, *temp=NULL;

struct Node *create();
void addList(int);
void display();

void main()
{
	int n, i, num;
	printf("Enter the no. of values :");
	scanf("%d",&n);
	
	for(i=0;i<n;i++)
	{
		printf("Enter the element %d :",i+1);
		scanf("%d",&num);
		addList(num);
	}
	
	display();
}

struct Node *create()
{
	struct Node *new;
	new = (struct Node *)malloc(sizeof(struct Node));
	new->next = NULL;
	new->prev = NULL;
	return new;
}

void addList(int num)
{
	if(head == NULL)
	{
		head = create();
		head->a = num;
	}
	else
	{
		temp = head;
		while(temp->next != NULL)
		{
			temp = temp->next;
		}
		struct Node *new = create();
		temp->next = new;
		new->prev = temp;
		new->a = num;  // storing the value
	}
}

void display()
{
	// Forward direction
	temp = head;
	while(temp->next != NULL)
	{
		printf("%d ",temp->a);
		temp = temp->next;
	}
	printf("%d\n",temp->a);
	
	// Reverse direction
	while(temp->prev != NULL)
	{
		printf("%d ",temp->a);
		temp = temp->prev;
	}
	printf("%d",temp->a);
}
