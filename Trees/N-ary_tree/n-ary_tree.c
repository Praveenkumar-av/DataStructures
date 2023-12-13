// N-ary tree

#include<stdio.h>
#include<stdlib.h>

struct Node
{
    int data;
    struct Node **child;
} *root = NULL;

void createTree(struct Node *,int *,int);
void preorder(struct Node *);
void enqueue(struct Node *);
struct Node *dequeue();

struct Node **q;
int front = -1, rear = -1;

void main()
{
    int n, *arr;
	printf("Enter the no. of vertices :");
	scanf("%d",&n);

    arr = (int *)calloc(n,sizeof(int));
	
	for(int i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
    // create a queue of size n
    q = (struct Node **)calloc(n,sizeof(struct Node *));

    createTree(root,arr,n);
    preorder(root);
}

void createTree(struct Node *temp,int *arr,int n)
{
    int i = 0, j, count, k;
    
    // create root node
    root = (struct Node *)malloc(sizeof(struct Node));
    root->data = arr[i];
    enqueue(root);
    i++;

    while(i < n)
    {
        if(arr[i] == 0)
        {
            temp = dequeue();
            i++;
        }
        else
        {
            count = 0;
            // counting the no. of elements
            for(j=i;arr[j] != 0 && j < n;j++)
                count++;

            // allocate memory for child array dynamically
            temp->child = (struct Node **)calloc(count+1,sizeof(struct Node *));

            k = i;  // to represent the index of data array
            for(j=0;j<count;j++,k++)
            {
            	temp->child[j] = (struct Node *)malloc(sizeof(struct Node));  // create a node
                temp->child[j]->data = arr[k];  // copy the data to node
                temp->child[j]->child = NULL;   // set the child to null
                enqueue(temp->child[j]);        // enqueue the node to queue
		    }
            temp->child[j] = NULL;

            i += count;
        }
    }
}

void preorder(struct Node *temp)
{
    if(temp != NULL)
    {
        printf("%d ",temp->data);
        if(temp->child != NULL)
        {
        	for(int i=0;temp->child[i] != NULL;i++)
        	{
        	    preorder(temp->child[i]);
        	}
        }
    }
}

void enqueue(struct Node *n)
{
	// add element to the last
	if(front == -1)
	{
		front++;
		rear++;
		q[front] = n;
	}
	else
	{
		rear++;
		q[rear] = n;
	}
}

struct Node *dequeue()
{
    struct Node *n;
	if(front == rear)
	{
		n = q[front];
		front = rear = -1;
	}
	else
	{
		n = q[front];
		front++;
	}
    return n;
}

int isQueueEmpty()
{
    if(front == -1 && rear == -1)
    {
        return 1;
    }
    return 0;
}