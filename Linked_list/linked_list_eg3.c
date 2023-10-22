// Doubly linked list in C

#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int a;
	struct Node *next;
	struct Node *prev;
}*head=NULL, *last=NULL, *temp=NULL;

struct Node *create();
void addList(int);
void addFirst(int);
void insert(int,int);
void removeFirst();
void removeLast();
void delete();
int length();
void display();

void main()
{
	int n, i, num, pos;
	printf("Enter the no. of values :");
	scanf("%d",&n);
	
	for(i=0;i<n;i++)
	{
		printf("Enter the element %d :",i+1);
		scanf("%d",&num);
		addList(num);
	}
	
	display();
	
	printf("Enter a element to add first :");
	scanf("%d",&num);
	addFirst(num);
	display();
	
	removeFirst();
	printf("First element removed\n");
	display();
	
	removeLast();
	printf("Last element removed\n");
	display();
	
	printf("Enter the position and number to insert an element :");
	scanf("%d%d",&pos,&num);
	insert(num,pos);
	display();
	
	printf("Enter a element to remove :");
	scanf("%d",&num);
	delete(num);
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
		last = head;
	}
	else
	{
		temp = last;

		struct Node *new = create();
		temp->next = new;
		new->prev = temp;
		new->a = num;  // storing the value
		last = new;
	}
}

void addFirst(int num)
{
	if(head == NULL)
	{
		addList(num);
	}
	else 
	{
		struct Node *new = create();
		new->next = head;
		head->prev = new;
		head = new;
		new->a = num;
	}
}

void insert(int num,int pos)
{
	int n = length();
	if(n == 0)
	{
		printf("List empty!");
	}
	else if(pos>n || pos<1)
	{
		printf("Invalid");
	}
	else if(pos == 1)
	{
		addFirst(num);
	}
	else
	{
		temp = head;
		int i;
		for(i=2;i<pos;i++)
		{
			temp = temp->next;
		}
		struct Node *new;
		new = create();
		new->next = temp->next;
		temp->next->prev = new;
		temp->next = new;
		new->prev = temp;
		new->a = num;
	}
}

void removeFirst()
{
	if(head == NULL)
	{
		printf("List empty!\n");
	}
	else if(head->next == NULL)
	{
		head = NULL;
		last = NULL;
	}
	else 
	{
		head = head->next;
		head->prev = NULL;
	}
}

void removeLast()
{
	if(last == NULL)
	{
		printf("List empty!");
	}
	if(last->prev == NULL)
	{
		last = NULL;
		head = NULL;
	}
	else
	{
		last = last->prev;
		last->next = NULL;
	}
}

void delete(int num)
{
	if(head == NULL)
	{
		printf("List empty!\n");
	}
	else
	{
		int flag = 0;
		if(head->a == num)
		{
			removeFirst();
			flag = 1;
		}

		temp = head->next;
		while(temp->next != NULL)
		{
			if(temp->a == num)
			{
				temp->prev->next = temp->next;
				temp->next->prev = temp->prev;
				flag = 1;
			}
			temp = temp->next;
		}

		if(temp->a == num)
		{
			removeLast();
			flag = 1;
		}
		if(flag == 0)
			printf("Element not found\n");
		else
			printf("Element removed\n");
	}
}

int length()
{
	if(head == NULL)
	{
		return 0;
	}
	temp = head;
	int count = 0;
	while(temp != NULL)
	{
		count++;
		temp = temp->next;
	}
	return count;
}

void display()
{
	if(head == NULL)
	{
		printf("List is empty!\n");
	}
	else
	{
		// Forward direction
		temp = head;
		printf("list :\n");
		while(temp != NULL)
		{
			printf("%d ",temp->a);
			temp = temp->next;
		}
		printf("\n");
	
		// Reverse direction
		temp = last;
		printf("list reversed :\n");
		while(temp != NULL)
		{
			printf("%d ",temp->a);
			temp = temp->prev;
		}
		printf("\n\n");
	}
}

