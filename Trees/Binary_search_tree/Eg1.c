// Binary search tree implementation in C using recursion - insertion, traversal and search

#include<stdio.h>
#include<stdlib.h>

struct Node
{
    int data;
    struct Node *left, *right;
} *root = NULL;

struct Node *create(int);
struct Node *insert(struct Node *,int);
void inorder(struct Node *);
void preorder(struct Node *);
void postorder(struct Node *);
int search(struct Node *,int);

void main()
{
    int n, num, i;
    printf("Enter the no. of elements :");
    scanf("%d",&n);
    printf("Enter the elements :");
    for(i=0;i<n;i++)
    {
        scanf("%d",&num);
        root = insert(root,num);
    }

    printf("Inorder traversal :");
    inorder(root);

    printf("\nPreorder traversal :");
    preorder(root);

    printf("\nPostorder traversal :");
    postorder(root);

    printf("\nEnter a element to search :");
    scanf("%d",&num);
    int result = search(root,num);
    if(result == 1)
        printf("Element found");
    else 
        printf("Element not found");
}

struct Node *create(int value)
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->data = value;
    n->left = NULL;
    n->right = NULL;
    return n;
}

struct Node *insert(struct Node *temp, int value)
{
    if(temp == NULL)
    {
        return create(value);
    }
    else 
    {
        if(value < temp->data)
        {
            temp->left = insert(temp->left,value);
        }
        else
        {
            temp->right = insert(temp->right,value);
        }
        return temp; 
    }
}

void inorder(struct Node *temp)
{
    if(temp != NULL)
    {
        inorder(temp->left);
        printf("%d ",temp->data);
        inorder(temp->right);
    }
}

void preorder(struct Node *temp)
{
    if(temp != NULL)
    {
        printf("%d ",temp->data);
        preorder(temp->left);
        preorder(temp->right);
    }
}

void postorder(struct Node *temp)
{
    if(temp != NULL)
    {
        postorder(temp->left);
        postorder(temp->right);
        printf("%d ",temp->data);
    }
}

int search(struct Node *temp,int value)
{
    if(temp == NULL)
    {
        return -1;
    }
    else 
    {
        if(temp->data == value)
        {
            return 1;
        }
        else if(value < temp->data)
        {
            return search(temp->left,value);
        }
        else 
        {
            return search(temp->right,value);
        }
    }
}