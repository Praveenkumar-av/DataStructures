// Insertion sort

#include<stdio.h>
void sort(int *,int);

void main()
{
    int arr[20], n, i;
    printf("Enter the no. of elements :");
    scanf("%d",&n);

    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    sort(arr,n);

    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}

void sort(int *arr,int n)
{
    int i, j, temp;
    for(i=1;i<n;i++)
    {
        for(j=i;j>0 && arr[j]<arr[j-1];j--)
        {
            temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
        }
    }
}
