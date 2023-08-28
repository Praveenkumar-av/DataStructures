// singly linked list in c - reading value from user, adding node at the middle, first and deleting and printing

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
}

struct Node *create()  // function to create node
{
	return (struct Node *)malloc(sizeof(struct Node));
}

void addList(int num)  // creates new node and adds it to the last
{
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
    int count = 1;
    temp = head;
    while(temp->next != NULL)
    {
        count++;
        temp = temp->next;
    }
    count/=2;
    temp = head;

    for(int i=1;i<count;i++)
    {
        temp = temp->next;
    }
    struct Node *new;
    new = create();
    new->a = num;  // store the num in 'a' in new node
    new->next = temp->next;
    temp->next = new;
}

void delete(int num)
{
    temp = head;  // stores the current node address
    struct Node *temp2 = NULL;  // to store the previous node address
    int flag = 0;  // to identify if num is found or not
    if(temp->a == num)
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
    if(temp->a == num || flag == 0)
    {
        temp2->next == NULL;
        flag = 1;
    }
    if(flag == 0)
        printf("Element not found!");
    else
        printf("Element removed");
}

void display()	// printing in the output console
{

	temp = head;
	int i=1;
	while(temp->next != NULL)
	{
		printf("\nElement %d :%d",i++,temp->a);
		temp = temp->next;
	}
	printf("\nElement %d :%d",i,temp->a);
}