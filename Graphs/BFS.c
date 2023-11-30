// Breadth first search implementation for graphs

#include<stdio.h>
#include<stdlib.h>

void enqueue(int *,int);
int dequeue(int *);
int isEmpty();

int front=-1, rear=-1;

void bfs(int **adj,int *q,int n,int start)
{
    int v, u = start;
    int *visited = (int *)calloc(n,sizeof(int));

    printf("%d ",u);  // start node
    enqueue(q,u);
    while(!isEmpty())
    {
        u = dequeue(q);

        for(v=1;v<n;v++)
        {
            if(adj[u][v] == 1 && visited[v] == 0)
            {   
                printf("%d \n",v);
                visited[v] = 1;
                enqueue(q,v);
            }
        }
    }
}

void main()
{
    int n, i, j, start;

    printf("Enter the no. of vertices :");
    scanf("%d",&n);

    // create the adjacency matrix dynamically
    int **adj = (int **)calloc(n,sizeof(int *));
    for(i=0;i<n;i++)
        adj[i] = (int *)calloc(n,sizeof(int));

    // create the queue dynamically
    int *q = (int *)calloc(n,sizeof(int));

    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            scanf("%d",&adj[i][j]);

    printf("Enter the root :");
    scanf("%d",&start);
    bfs(adj,q,n,start);
}

void enqueue(int *q,int ch)
{
    if(front == -1 && rear == -1)
    {
        front = rear = 0;
        q[rear] = ch;
    }
    else
    {
        rear++;
        q[rear] = ch;
    }
}

int dequeue(int *q)
{
    int ch;
    if(front == rear)
    {
        ch = q[front];
        front = rear = -1;
    }
    else
    {
        ch = q[front];
        front++;
    }
    return ch;
}

int isEmpty()
{
    if(front == -1 && rear == -1)
        return 1;
    else
        return 0;
}
