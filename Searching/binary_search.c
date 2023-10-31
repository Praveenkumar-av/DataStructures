// Binary search by recursion

#include<stdio.h>

int search(int *arr,int element,int start,int end)
{
    if(start > end)  
        return -1;
    
    int mid = (start+end)/2;
    if(arr[mid] == element)
        return 1;
    else if(element < arr[mid])
        return search(arr,element,start,mid-1);
    else 
        return search(arr,element,mid+1,end);
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

    int found = search(arr,element,0,n-1);
    if(found == -1)
        printf("Element not found!");
    else 
        printf("Element found");
}