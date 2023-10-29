// finding the height of the tree using recursion

#include<stdio.h>
#include<stdlib.h>

struct Node
{
    int data;
    struct Node *left, *right;
} *root = NULL;

struct Node *create(int);
struct Node *insert(struct Node *,int);
int findHeight(struct Node *);

void main()
{
    int num, i, n;
    printf("Enter the no. of values :");
    scanf("%d",&n);
    printf("Enter the elements :");
    for(i=0;i<n;i++)
    {
        scanf("%d",&num);
        root = insert(root,num);
    }

    printf("Height :%d",findHeight(root));
}

struct Node *create(int value)
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->data = value;
    n->left = NULL;
    n->right = NULL;
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

int findHeight(struct Node *temp)
{
    if(root == NULL)
        return 0;

    static int count = -1;
    static int height = 0;
    if(temp == NULL)
    {
        if(count > height)
            height = count;
    }
    else
    {
        count++;

        findHeight(temp->left);

        findHeight(temp->right);

        count--;
    }
    return height;
}
