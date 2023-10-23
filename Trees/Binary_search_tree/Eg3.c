// Binary search tree in C - insertion, searching, minimum and maximum using looping

#include<stdio.h>
#include<stdlib.h>

struct Node 
{
    int data;
    struct Node *left, *right;
} *root = NULL;

void insert(int);
struct Node *create(int);
void printMin();
void printMax();
int search(int);

void main()
{
    int n, i, num;
    printf("Enter the no. of elements :");
    scanf("%d",&n);
    printf("Enter the elements :");
    for(i=0;i<n;i++)
    {
        scanf("%d",&num);
        insert(num);
    }

    printMin();
    printMax();
    
    printf("\nEnter the element to search :");
    scanf("%d",&num);
    if(search(num))
        printf("\nElement found");
    else
        printf("\nElement not found");
}

struct Node *create(int value)
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->data = value;
    n->left = NULL;
    n->right = NULL;
    return n;
}

void insert(int value)
{
    if(root == NULL)
        root = create(value);
    else 
    {
        struct Node *temp = root;
        while(temp != NULL)
        {
            if(value < temp->data)            
            {
                if(temp->left == NULL)
                {
                    temp->left = create(value);
                    break;
                }
                else 
                    temp = temp->left;
            }
            else 
            {
                if(temp->right == NULL)
                {
                    temp->right = create(value);
                    break;
                }
                else 
                    temp = temp->right;
            }
        }
    }
}

void printMin()
{
    if(root == NULL)
        printf("\nEmpty!");
    else 
    {
        struct Node *temp = root;
        while(temp->left != NULL)
        {
            temp = temp->left;
        }
        printf("\nMinimum Element :%d",temp->data);
    }
}

void printMax()
{
    if(root == NULL)
        printf("\nEmpty!");
    else 
    {
        struct Node *temp = root;
        while(temp->right != NULL)
        {
            temp = temp->right;
        }
        printf("\nMaximum Element :%d",temp->data);
    }
}

int search(int value)
{
    if(root == NULL)
        return 0;
    else
    {
        struct Node *temp = root;
        while(temp != NULL)
        {
            if(temp->data == value)
                return 1;
            else if(value < temp->data)
                temp = temp->left;
            else 
                temp = temp->right;
        }
        return 0;
    }
}