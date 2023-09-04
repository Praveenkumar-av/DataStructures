// Circular singly linked list in C

#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int a;
	struct Node *next;
}*head=NULL, *temp=NULL;

void addList(int);
void addFirst(int);
void insert(int,int);
void removeFirst();
void removeLast();
void delete(int);
int length();
void display();

struct Node *create()
{
	struct Node *new = (struct Node *)malloc(sizeof(struct Node));
	new->next = NULL;
	return new;
}

void main()
{
	int n, i, num, pos;
	printf("Enter the no. of elememts :");
	scanf("%d",&n);
	printf("Enter the elements :");
	for(i=0;i<n;i++)
	{
		scanf("%d",&num);
		addList(num);
	}
	display();
	
	printf("Enter a element to add First :");
	scanf("%d",&num);
	addFirst(num);
	display();
	
	printf("Enter the position and element to add :");
	scanf("%d%d",&pos,&num);
	insert(num,pos);
	display();
	
	removeFirst();
	printf("First element removed\n");
	display();
	
	removeLast();
	printf("Last element removed\n");
	display();
	
	printf("Enter a element to remove :");
	scanf("%d",&num);
	delete(num);
	display();
}

void addList(int num)
{
	if(head == NULL)
	{
		head = create();
		head->a = num;
		head->next = head;
	}
	else
	{
		temp = head;
		while(temp->next != head)
		{
			temp = temp->next;
		}
		temp->next = create();
		temp->next->a = num;
		temp->next->next = head;
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
		new->a = num;   // value
		temp = head;
		while(temp->next != head)
		{
			temp = temp->next;
		}
		head = new;
		temp->next = head;  // connect head to last node
	}
}

void insert(int num,int pos)
{
	int n = length();
	if(n == 0)
	{
		printf("List empty\n");
	}
	else if(pos > n || pos < 1)
	{
		printf("Invalid\n");
	}
	else
	{
		if(pos==1)
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
			struct Node *newNode;
			newNode = create();
			newNode->next = temp->next;
			temp->next = newNode;
			newNode->a = num;
		}
	}
}

void removeFirst()
{
	if(head == NULL)
	{
		printf("List empty!");
	}
	else if(head->next == head)
	{
		head = NULL;
	}
	else
	{
		temp = head;
		while(temp->next != head)
		{
			temp = temp->next;
		}
		head = head->next;
		temp->next = head;
	}
}

void removeLast()
{
	if(head == NULL)
	{
		printf("List empty!");
	}
	else if(head->next == head)
	{
		head = NULL;
	}
	else
	{
		temp = head;
		struct Node *tempprev = temp;
		while(temp->next != head)
		{
			tempprev = temp;
			temp = temp->next;
		}
		tempprev->next = head;
	}
}

void delete(int num)
{
	if(head == NULL)
		printf("List empty!\n");
	else
	{
		int flag = 0;
		struct Node *tempprev;  // to store the previous node address
		
		if(head->a == num)  // check the first element
		{
			removeFirst();
			flag = 1;
		}
		// check intermediate elements
		temp = head;
		while(temp->next != head)
		{
			tempprev = temp;
			temp = temp->next;
			if(temp->a == num)
			{
				tempprev->next = temp->next;
				flag = 1;
			}
		}
		if(temp->a == num)   // check last element
		{
			tempprev->next = head;
			flag = 1;
		}
		
		if(flag == 0)
			printf("Element not found!\n");
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
	int count = 1;
	temp = head;
	while(temp->next != head)
	{
		count++;
		temp = temp->next;
	}
	return count;
}

void display()
{
	if(head == NULL)
		printf("List empty!\n");
	else
	{
		temp = head;
		while(temp->next != head)
		{
			printf("%d ",temp->a);
			temp = temp->next;
		}
		printf("%d\n",temp->a);
	}
}
