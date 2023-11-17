// Counting sort 

#include<stdio.h>
#include<stdlib.h>

void countingSort(int *,int);

void main()
{
    int arr[50], n, i;
    printf("Enter the no. of elements :");
    scanf("%d",&n);

    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    countingSort(arr,n);

    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}

void countingSort(int *arr,int n)
{
    // find the maximum element 
    int i, max = arr[0];
    for(i=1;i<n;i++)
        if(arr[i] > max)
            max = arr[i];

    int *count = (int *)calloc(max+1,sizeof(int));  // array to store the count of elements 
    int *temp = (int *)calloc(n,sizeof(int));  // to store the temporary arranged elements

    // find the count of each element
    for(i=0;i<n;i++)
        count[arr[i]]++;

    // Cumulative count
    for(i=1;i<=max;i++)
        count[i] += count[i-1];

    // arrange the elements
    for(i=n-1;i>=0;i--)
        temp[--count[arr[i]]] = arr[i];

    // copy the elements to original array
    for(i=0;i<n;i++)    
        arr[i] = temp[i];
}