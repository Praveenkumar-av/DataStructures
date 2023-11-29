// Breadth first search in graphs

#include<stdio.h>
#include<stdlib.h>

void bfs(int **,int *,int);
void enqueue(int *,int);
int dequeue(int *);
int isEmpty();

int front=-1, rear=-1;

void main()
{
    int n, i, j;

    printf("Enter the no. of vertices :");
    scanf("%d",&n);

    int **adj = (int **)calloc(n,sizeof(int *));
    int *q = (int *)calloc(n,sizeof(int));

    for(i=0;i<n;i++)
        adj[i] = (int *)calloc(n,sizeof(int));

    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            scanf("%d",&adj[i][j]);

    bfs(adj,q,n);
}

void bfs(int **adj,int *q,int n)
{
    int i,j, e;
    int *visited = (int *)calloc(n,sizeof(int));

    printf("Enter the root :");
    scanf("%d",&e);

    enqueue(q,e);
    while(!isEmpty())
    {
        e = dequeue(q);

        if(visited[e] != 1)
        {
            printf("%d ",e);
            visited[e] = 1;

            for(j=0;j<n;j++)
            {
                if(adj[e][j] == 1)
                {
                    enqueue(q,j);
                }
            }
        }
    }
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
