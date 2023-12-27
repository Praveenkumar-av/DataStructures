// Shell sort

#include<stdio.h>

void shell_sort(int *,int);
void swap(int *,int,int);

void main()
{
    int arr[50], n, i;

    printf("Enter the no. of elements :");
    scanf("%d",&n);

    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    shell_sort(arr,n);
    
    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}

void shell_sort(int *arr,int n)
{
    int i, j, gap;
    
    for(gap = n/2;gap >= 1;gap /= 2)
    {
        for(j=gap;j<n;j++)
        {
            for(i = j-gap;i >= 0;i-=gap)
            {
                if(arr[i+gap] < arr[i])
                    swap(arr,i,i+gap);
                else 
                    break;
            }
        }
    }

    // int gap = n/2;
    // int i=0, j = gap, k, m;
    // while(gap > 0)
    // {
    //     while(j < n)
    //     {
    //         if(arr[i] > arr[j])
    //         {
    //             swap(arr,i,j);
    //             m = i;
    //             k = m - gap;
    //             while(k >= 0 && arr[k] > arr[m])
    //             {
    //                 swap(arr,k,m);
    //                 m = k;
    //                 k -= gap;
    //             }
    //         }
    //         i++;
    //         j++;
    //     }
    //     gap /= 2;
    //     i = 0;
    //     j = gap;
    // }
}

void swap(int *arr,int i,int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}