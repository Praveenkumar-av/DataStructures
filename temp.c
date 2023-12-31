// Shortest path of graph

#include<stdio.h>
#include<stdlib.h>

void shortPath(int **,int);

void main()
{
	int n, arr[10];
	printf("Enter the no. of vertices :");
	scanf("%d",&n);
	
	for(int i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}

	for(int i=0;i<n;i++)
		printf("%d ",arr[i]);
}

void shortPath(int **adj,int n)
{
	int mat1[n+1][n+1], mat2[n][n];
	int i, j, k;

	// copy adj matrix to mat1
	for(i=1;i<=n;i++)
		for(j=1;j<=n;j++)
			mat1[i][j] = adj[i][j];

	// find the shortest path
	for(k=1;k<=n;k++)
	{
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(i == j || i == k || j == k)
				{
					mat1[i][j] = mat1[i][j];
				}
				else 
				{	
					if(mat1[i][j] > (mat1[i][k] + mat1[k][j]))
					{
						mat1[i][j] = mat1[i][k] + mat1[k][j];
					}
					else 
					{
						mat1[i][j] = mat1[i][j];
					}
				}
			}
		}
		// copy mat2 to mat1
		// for(i=0;i<n;i++)
		// 	for(j=0;j<n;j++)
		// 		mat1[i][j] = mat2[i][j];
	}

	// print the shortest path matrix 
	printf("Shortest path is :\n");
	for(i=1;i<=n;i++)
	{
		for(j=0;j<n;j++)
			printf("%d ",mat1[i][j]);
		printf("\n");
	}
}
