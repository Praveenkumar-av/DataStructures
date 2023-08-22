// singly linked list in c - reading and printing from user

#include<stdio.h>
#include<stdlib.h>
struct Node
{
	int n;
	struct Node *next;
}*head=NULL;

struct Node *create();
void addList(int);

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
	
	// printing

	struct Node *temp = head;
	for(i=0;i<n;i++)
	{
		printf("\nElement %d :%d",i+1,temp->n);
		temp = temp->next;
	}
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
		head->n = num;
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
		temp->next->n = num;
		temp->next->next = NULL;
	}
}
