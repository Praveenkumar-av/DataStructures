// depth first search traversal using stack of graphs

#include<stdio.h>
#include<stdlib.h>

void dfs(int **,int,int);
void push(int *,int);
int pop(int *);
int isStackEmpty();

int top = -1;

void main()
{
	int n, start;
	printf("Enter the no. of vertices :");
	scanf("%d",&n);
	
	int i, j;
	int **adj = (int **)calloc(n,sizeof(int *));
	for(i=0;i<n;i++)
		adj[i] = (int *)calloc(n,sizeof(int));
		
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			scanf("%d",&adj[i][j]);
			
	printf("Enter the start vertix :");
	scanf("%d",&start);
	dfs(adj,n,start);
}

void dfs(int **adj,int n,int s)
{
	int *st = (int *)calloc(n,sizeof(int));
	
	int *visited = (int *)calloc(n,sizeof(int));
	printf("%d ",s);
	visited[s] = 1;
	push(st,s);
	
	int i;
	while(!isStackEmpty())
	{
		s = pop(st);

		for(i=0;i<n;i++)
		{
			if(adj[s][i] == 1 && visited[i] == 0)
			{
				printf("%d ",i);
				visited[i] = 1;
				push(st,s);
				push(st,i);
				break;
			}
		}
	}
}

void push(int *st,int e)
{
	top++;
	st[top] = e;
}

int pop(int *st)
{
	int e = st[top];
	top--;
	return e;
}

int isStackEmpty()
{
	if(top == -1)
	 	return 1;
	 	
	return 0;
}
