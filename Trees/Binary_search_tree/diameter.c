// Diameter of a binary search tree

#include<stdio.h>
#include<stdlib.h>

struct Node 
{
    int data;
    struct Node *left, *right;
} *root = NULL;

int diameter(struct Node *);
int height(struct Node *);
struct Node *create(int);
struct Node *insert(struct Node *,int);
void enqueue(struct Node *);
struct Node *dequeue();
int isQueueEmpty();

int front = -1, rear = -1, n=100;
struct Node *q[100];

void main()
{
    int n, num, i, d=0;
    printf("Enter the no. of elements :");
    scanf("%d",&n);
    printf("Enter the elements :");
    for(i=0;i<n;i++)
    {
        scanf("%d",&num);
        root = insert(root,num);
    }

    d = diameter(root);
    printf("diameter :%d",d);
}

int diameter(struct Node *root)
{
    int hl, hr;
    hl = height(root->left);
    printf("Height of left sub tree :%d\n",hl);

    hr = height(root->right);
    printf("Height of right sub tree :%d\n",hr);
    
    return hl + hr + 1;
}

int height(struct Node *temp)
{
    if(temp == NULL)
        return 0;
    
    enqueue(temp);
    enqueue(NULL);
    int count = 1;

    while(!isQueueEmpty())
    {
        temp = dequeue();
        if(temp == NULL)
        {
            if(isQueueEmpty())
            {
                return count;
            }

            enqueue(NULL);
            count++;
        }
        else
        {
            if(temp->left != NULL)
                enqueue(temp->left);
            if(temp->right != NULL)
                enqueue(temp->right);
        }
    }    
}

struct Node *create(int val)
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->data = val;
    n->left = NULL;
    n->right = NULL;
    return n;
}

struct Node *insert(struct Node *temp, int val)
{
    if(temp == NULL)
    {
        return create(val);
    }
    else
    {
        if(val < temp->data)
        {
            temp->left = insert(temp->left, val);
        }
        else
        {
            temp->right = insert(temp->right,val);
        }
    }
    return temp;
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