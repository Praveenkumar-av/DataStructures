// Merge sorting 

#include <stdio.h>

void mergeSort(int *,int *,int,int);
void merge(int *,int *,int,int,int);
void main()
{
    int arr[50], n, i, temp[50];
    printf("Enter the no. of elements :");
    scanf("%d",&n);

    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    mergeSort(arr,temp,1,n);

    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}

void mergeSort(int *arr,int *temp,int l,int r)
{
    if(l<r)
    {
        int mid = ((l+r)/2);
        mergeSort(arr,temp,l,mid);
        mergeSort(arr,temp,mid+1,r);
        merge(arr,temp,l,mid,r);
    }
}

void merge(int *arr,int *temp,int l,int mid,int h)
{
    int i=l-1, j=mid, k=0;
    while(i<mid && j<h)
    {
        if(arr[i] < arr[j])
            temp[k] = arr[i++];
        else
            temp[k] = arr[j++];

        k++;
    }

    while(i<mid)
    {
        temp[k++] = arr[i++];
    }

    while(j<h)
    {
        temp[k++] = arr[j++];
    }

    // copy the result to original array in the position
    k = 0;
    i = l-1;
    while(i<h)
    {
        arr[i++] = temp[k++];
    }
}