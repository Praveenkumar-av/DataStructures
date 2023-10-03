// singly linked list in C - reading value from user, adding node at the middle and first, 
// deleting, inserting and printing

#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int a;
	struct Node *next;
}*head=NULL, *temp=NULL;

struct Node *create();
void addList(int);
void display();
void addFirst(int);
void addMiddle(int);
void insert(int,int);
int length();
void delete(int);

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

    printf("\nEnter the element to add at the first position :");
    scanf("%d",&num);
    addFirst(num);
    display();

    printf("\nEnter the element to add at the middle :");
    scanf("%d",&num);
    addMiddle(num);
    display();

    printf("\nEnter the element to delete :");
    scanf("%d",&num);
    delete(num);
    display();
    
    int pos;
    printf("\nEnter the position and number to add element :");
    scanf("%d%d",&pos,&num);
    insert(num,pos);
    display();
}

struct Node *create()  // function to create node
{
	struct Node *new = (struct Node *)malloc(sizeof(struct Node));
	new->next = NULL;
	return new;
}

void addList(int num)  // creates new node and adds it to the last
{
	if(head==NULL)
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
		temp->next = create();
		temp->next->a = num;
	}
}

void addFirst(int num)  // creates the node and make it as the starting node
{
    struct Node *new;
    new = create();  // creating a new node
    new->next = head;
    head = new;
    new->a = num; // store the num in 'a' in new node
}

void addMiddle(int num)  // create and add at the middle of the linked list
{
    int n = length();
    if(n == 0)
    {
    	printf("List is empty!\n");
	}
	else
	{
    	n /= 2;  // middle of the node
    	temp = head;

		int i;
    	for(i=1;i<n;i++)
    	{
    	    temp = temp->next;
    	}
    	struct Node *new;
    	new = create();
    	new->a = num;  // store the num in 'a' in new node
    	new->next = temp->next;
    	temp->next = new;
    }
}

void insert(int num,int pos)
{
	int n = length();

	if(pos>n || pos<1)
	{
		printf("Invalid!");
	}
	else if(pos == 1)
	{
		addFirst(num);
	}
	else
	{
		struct Node *new = create();
		temp = head;
		int i;
		for(i=2;i<pos;i++)
		{
			temp = temp->next;
		}
		new->next = temp->next;
		temp->next = new;
		new->a = num;
	}
}

void delete(int num)
{
	if(head == NULL)
	{
		printf("List is empty!");
	}
	else
	{
	    temp = head;  // stores the current node address
	    struct Node *temp2 = NULL;  // to store the previous node address
	    int flag = 0;  // to identify if num is found or not
    	if(temp->a == num)  // first element
    	{
    	    head = head->next;
    	    flag = 1;
    	}
    	else
    	{
    	    while(temp->next != NULL)
        	{
        	    temp2 = temp;
        	    temp = temp->next;
        	    if(temp->a == num)
        	    {
            	    temp2->next = temp->next;
               		flag = 1;
                	break;
            	}
        	}
    	}
	    if(temp->a == num && flag == 0)  // last element
    	{
    	    temp2->next == NULL;
    	    flag = 1;
    	}
    	if(flag == 0)
        	printf("Element not found!");
    	else
        	printf("Element removed");
    }
}

int length()
{
	if(head == NULL)
	{
		return 0;  
	}
	// find the length of the Node
	temp = head;
	int count = 0;
	while(temp != NULL)
	{
		count++;
		temp = temp->next;
	}
	return count;
}

void display()	// printing in the output console
{
	if(head == NULL)
	{
		printf("List is empty!\n");
	}
	else
	{
		temp = head;
		int i=1;
		while(temp != NULL)
		{
			printf("\nElement %d :%d",i++,temp->a);
			temp = temp->next;
		}
		printf("\n");
	}
}
