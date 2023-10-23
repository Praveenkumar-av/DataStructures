// Binary search tree - finding minimum and maximum element using recursion 

#include<stdio.h>
#include<stdlib.h>

struct Node
{
    int data;
    struct Node *left, *right;
} *root = NULL;

struct Node *create(int);
struct Node *insert(struct Node *,int);
void printMin(struct Node *);
void printMax(struct Node *);

void main()
{
    int num, n, i;
    printf("Enter the no. of elements :");
    scanf("%d",&n);
    printf("Enter the elements :");
    for(i=0;i<n;i++)
    {
        scanf("%d",&num);
        root = insert(root,num);
    }

    printMin(root);
    printMax(root);
}

struct Node *create(int value)
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->data = value;
    n->right = NULL;
    n->left = NULL;
    return n;
}

struct Node *insert(struct Node *temp,int value)
{
    if(temp == NULL)
        return create(value);
    else 
    {
        if(value < temp->data)
            temp->left = insert(temp->left,value);
        else 
            temp->right = insert(temp->right,value);
        
        return temp;
    }
}

void printMin(struct Node *temp)
{
    if(temp == NULL)
        printf("\nEmpty!");
    else
    {
        if(temp->left == NULL)
            printf("Minimum element :%d",temp->data);
        else 
            printMin(temp->left);
    }
}

void printMax(struct Node *temp)
{
    if(temp == NULL)
        printf("\nEmpty!");
    else
    {
        if(temp->right == NULL)
            printf("\nMaximum element :%d",temp->data);
        else 
            printMin(temp->right);
    }
}