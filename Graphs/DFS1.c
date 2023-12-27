// Depth first search traversal using recursion for graphs

#include<stdio.h>
#include<stdlib.h>

void dfs(int **adj,int n,int *visited,int s)
{
    if(visited[s] == 0)
    {
        printf("%d ",s);
        visited[s] = 1;
        for(int i=0;i<n;i++)
        {
            if(adj[s][i] == 1 && visited[i] == 0)
            {
                dfs(adj,n,visited,i);
            }
        }
    }
}

void main()
{
    int n, i, j, start;

    printf("Enter the no. of vertices :");
    scanf("%d",&n);

    // create matrix dynamically
    int **adj = (int **)calloc(n,sizeof(int *));
    for(i=0;i<n;i++)
        adj[i] = (int *)calloc(n,sizeof(int));

    // create the visited array dynamically
    int *visited = (int *)calloc(n,sizeof(int));

    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            scanf("%d",&adj[i][j]);

    printf("Enter the root :");
    scanf("%d",&start);
    dfs(adj,n,visited,start);
}