// Shortest path of graph

#include<stdio.h>
#include<stdlib.h>

void shortPath(int **,int);

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
			
	shortPath(adj,n);
}

void shortPath(int **adj,int n)
{
	int mat1[n][n];
	int i, j, k;

	// copy adj to mat1
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			mat1[i][j] = adj[i][j];

	// find the shortest path
	for(k=0;k<n;k++)
	{
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i != j && i != k && j != k)
					if(mat1[i][k]+mat1[k][j] < mat1[i][j])
						mat1[i][j] = mat1[i][k]+mat1[k][j];
			}
		}
	}

	// print the shortest path matrix 
	printf("Shortest path is :\n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			printf("%d ",mat1[i][j]);
		printf("\n");
	}
}
