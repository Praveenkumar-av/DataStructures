// Selection sort

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
    int i, j, temp, min;
    min = 0;
    for(i=0;i<n;i++)
    {
        min = i;
        for(j=i+1;j<n;j++)
        {
            if(arr[j] < arr[min])
                min = j;
        }
        if(min != i)
        {
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
