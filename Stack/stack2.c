// stack implementation in C using linked list

#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int a;
	struct Node *next;
}*head = NULL;

void push(int);
void pop();
void peak();

void main()
{
	int num, choice;
	
	do
	{
		printf("Enter 1 to push, 2 to pop, 3 to peak and 0 to exit :");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				printf("Enter the element to push :");
				scanf("%d",&num);
				push(num);
				break;
				
			case 2:
				pop();
				break;
				
			case 3:
				peak();
				break;
			
			default :
				if(choice != 0)
					printf("Invalid choice!\n");
		}
	}while(choice != 0);
}

struct Node *create()
{
	return (struct Node *)malloc(sizeof(struct Node));
}

void push(int num)
{
	// function to insert the element at the top of the stack
	if(head == NULL)
	{
		head = create();
		head->next = NULL;
		head->a = num;
	}
	else
	{
		struct Node *n = create();
		n->next = head;
		n->a = num;
		head = n;
	}
}

void pop()
{
	// function to fetch and delete the top element of the stack
	if(head == NULL)
		printf("Stack empty!\n");
	else
	{
		printf("%d\n",head->a);
		head = head->next;
	}
}

void peak()
{
	// function to fetch the top element of the stack
	if(head == NULL)
		printf("Stack empty!\n");
	else
	{
		printf("%d\n",head->a);
	}
}
