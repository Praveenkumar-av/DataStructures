// Circular doubly linked list in C

#include<stdio.h>
#include<stdlib.h>

struct Node 
{
    int a;
    struct Node *next, *prev;
}*head=NULL, *last=NULL, *temp=NULL;

struct Node *create();
void addList(int);
void addFirst(int);
void removeFirst();
void removeLast();
void display();

void main()
{
    int n, i, num;
    printf("Enter the no. of elements :");
    scanf("%d",&n);
    printf("Enter the elements :");
    for(i=0;i<n;i++)
    {
        scanf("%d",&num);
        addList(num);
    }
    display();

    printf("Enter a elememt to add first :");
    scanf("%d",&num);
    addFirst(num);
    display();

    removeFirst();
    printf("First element removed\n");
    display();

    removeLast();
    printf("Last element removed\n");
    display();
}

struct Node *create()
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->next = NULL;
    newNode->prev = NULL;
    return newNode;
}

void addList(int num)
{
    if(head == NULL)
    {
        head = create();
        head->a = num;
        last = head;
        head->prev = last;
        last->next = head;
    }
    else
    {
        temp = last;
        struct Node *newNode = create();
        temp->next = newNode;
        newNode->prev = temp;
        last = newNode;
        last->a = num;
        last->next = head;
        head->prev = last;
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
        struct Node *newNode = create();
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
        last->next = head;
        newNode->prev = last;
        newNode->a = num;
    }
}

void removeFirst()
{
    if(head == NULL)
        printf("List empty!");
    else if(head->next == head)
    {
        head = NULL;
        last = NULL;
    }
    else
    {
        head = head->next;
        head->prev = last;
        last->next = head;
    }
}

void removeLast()
{
    if(head == NULL)
        printf("List empty!");
    else if(last->next == last)
    {
        head = NULL;
        last = NULL;
    }
    else
    {
        last = last->prev;
        head->prev = last;
        last->next = head;
    }
}

void display()
{
    if(head == NULL)
        printf("List empty!");
    else
    {
        // Forward direction
        temp = head;
        while(temp->next != head)
        {
            printf("%d ",temp->a);
            temp = temp->next;
        }
        printf("%d\n",temp->a);

        // Reverse direction
        temp = last;
        while(temp->prev != last)
        {
            printf("%d ",temp->a);
            temp = temp->prev;
        }
        printf("%d\n",temp->a);
    }
}