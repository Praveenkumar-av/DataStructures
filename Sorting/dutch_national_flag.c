#include<stdio.h>
#include<stdlib.h>

void dutch_flag_sort(int *,int);
void swap(int *,int,int);

void main()
{
    int n, *arr, i;
    printf("Enter the no. of elements :");
    scanf("%d",&n);

    arr = (int *)calloc(n,sizeof(int));
    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    dutch_flag_sort(arr,n);

    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}

void dutch_flag_sort(int *arr,int n)
{
    int i, low = 0, mid =0, high = n-1;

    while(mid <= high)
    {
        switch(arr[mid])
        {
            case 0 :
                swap(arr,mid,low);
                mid++;
                low++;
                break;

            case 1 :
                mid++;
                break;

            case 2 :
                swap(arr,mid,high);
                high--;
                break;
        }
    }
}

void swap(int *arr,int i,int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}