// Level order traversal of a tree using Queue with printing the levels

#include<stdio.h>
#include<stdlib.h>

struct Node 
{
    int data;
    struct Node *left, *right;
}*root = NULL;

struct Node *create(int);
struct Node *insert(struct Node *,int);
void levelOrder(struct Node *);
void enqueue(struct Node *);
struct Node *dequeue();
int isQueueEmpty();

struct Node *q[50];
int front = -1, rear = -1, n = 50;

void enqueue(struct Node *);
struct Node *dequeue();

void main()
{
    int num, i, n;
    printf("Enter the no. of values :");
    scanf("%d",&n);
    printf("Enter the elements :");
    for(i=0;i<n;i++)
    {
        scanf("%d",&num);
        root = insert(root,num);
    }

    printf("Level order traversal :");
    levelOrder(root);
}

struct Node *create(int value)
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->data = value;
    n->left = NULL;
    n->right = NULL;
    return n;
}

void levelOrder(struct Node *temp)
{
    if(temp == NULL)
        return;

    enqueue(temp);
    enqueue(NULL);
    int i=0;
    printf("Level 0 :");
    while(!isQueueEmpty())
    {
        temp = dequeue();
        if(temp == NULL)
        {
            if(isQueueEmpty())
                return;
            enqueue(NULL);
            i++;
            printf("\nLevel %d :",i);
        }
        else
        {
            printf("%d ",temp->data);
            if(temp->left != NULL)
                enqueue(temp->left);
            if(temp->right != NULL)
                enqueue(temp->right);
        }
    }
}

struct Node *insert(struct Node *temp,int value)
{
    if(temp == NULL)
        return create(value);
    else
    {
        if(value < temp->data)
            temp->left = insert(temp->left,value);
        else
            temp->right = insert(temp->right,value);

        return temp;
    }
}

void enqueue(struct Node *temp)
{
    if(rear == n-1)
        printf("Queue is full");
    else if(front == -1 && rear == -1)
    {
        front = rear = 0;
        q[rear] = temp;
    }
    else
    {
        rear++;
        q[rear] = temp;
    }
}

struct Node *dequeue()
{
    struct Node *temp;
    if(front == -1 && rear == -1)
        printf("Queue is empty");
    else if(front == rear)
    {
        temp = q[front];
        front = rear = -1;
    }
    else
    {
        temp = q[front];
        front++;
    }
    return temp;
}

int isQueueEmpty()
{
    if(front == -1 && rear == -1)
        return 1;
    else 
        return 0;
}