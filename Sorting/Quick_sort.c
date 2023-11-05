// Quick sort

#include<stdio.h>

void quickSort(int *,int,int);
void swap(int *,int,int);

void main()
{
    int arr[50], n, i;
    printf("Enter the no. of elements :");
    scanf("%d",&n);

    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    quickSort(arr,0,n);

    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}

void quickSort(int *arr,int start,int end)
{
    if(start >= end)
        return;

    int pivot = end, i = start-1, j;
    for(j=start;j < end;j++)
    {
        if(arr[j] < arr[pivot])
            swap(arr,++i,j);
    }
    swap(arr,++i,j);
    pivot = i;

    quickSort(arr,start,pivot-1);
    quickSort(arr,pivot+1,end);
}

void swap(int *arr,int i,int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}