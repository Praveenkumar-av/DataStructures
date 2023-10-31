// Linear search

#include<stdio.h>

int search(int *arr,int n,int element)
{
    for(int i=0;i<n;i++)
        if(arr[i] == element)
            return i;
        
    return -1;    
}

void main()
{
    int arr[10], n, i, element;
    printf("Enter the no. of elements :");
    scanf("%d",&n);

    printf("Enter the elements :");
    for(i=0;i<n;i++)
        scanf("%d",&arr[i]);

    printf("Enter the element to search :");
    scanf("%d",&element);

    int index = search(arr,n,element);
    if(index == -1)
        printf("Element not found!");
    else 
        printf("Element found at index :%d",index);
}