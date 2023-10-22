// singly linked list in c - reading from user and printing by dynamically creating node

#include<stdio.h>
#include<stdlib.h>
struct Node
{
	int a;
	struct Node *next;
}*head=NULL;

struct Node *create();
void addList(int);
void display();

void main()
{
	int n, num, i;
	printf("Enter the no. of values :");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("Enter the element %d :",i+1);
		scanf("%d",&num);
		addList(num);
	}
	
	display();  // printing the elements
}

struct Node *create()
{
	return (struct Node *)malloc(sizeof(struct Node));
}

void addList(int num)
{
	struct Node *temp;
	if(head==NULL)
	{
		head = create();
		head->a = num;
		head->next = NULL;
	}
	else
	{
		temp = head;
		while(temp->next != NULL)
		{
			temp = temp->next;
		}
		temp->next = create();
		temp->next->a = num;
		temp->next->next = NULL;
	}
}

void display()
{
	// printing in the output console
	struct Node *temp = head;
	int i=1;
	while(temp != NULL)
	{
		printf("\nElement %d :%d",i++,temp->a);
		temp = temp->next;
	}
}
