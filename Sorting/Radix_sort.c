// Radix sort

#include<stdio.h>
#include<stdlib.h>

void radixSort(int *,int);
void countSort(int *,int,int);
int getMax(int *,int);

void main()
{
    int arr[50], n, i;
    printf("Enter the no. of elements :");
    scanf("%d",&n);

    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    radixSort(arr,n);

    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}

void radixSort(int *arr,int n)
{
    int max = getMax(arr,n);

    for(int pos=1;max/pos>0;pos*=10)
    {
        countSort(arr,n,pos);
    }
}

void countSort(int *arr,int n,int pos)
{
    int *temp = (int *)calloc(n,sizeof(int));
    int count[10] = {0}, i;

    for(i=0;i<n;i++)
        count[(arr[i]/pos)%10]++;

    for(i=1;i<10;i++)
        count[i] += count[i-1];
    
    for(i=n-1;i>=0;i--)
        temp[--count[(arr[i]/pos)%10]] = arr[i];

    for(i=0;i<n;i++)
        arr[i] = temp[i];
}

int getMax(int *arr,int n)
{
    int max = arr[0];

    for(int i=1;i<n;i++)
        if(arr[i] > max)
            max = arr[i];
    
    return max;
}