// Bubble sort 

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
    int flag=1, temp, i;
    while(flag)
    {
        flag = 0;
        for(i=0;i<n-1;i++)
        {
            if(arr[i] > arr[i+1])
            {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                flag = 1;
            }
        }
        n--;
    }
}