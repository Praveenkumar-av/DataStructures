// Top view of a tree without using dictionary

#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *left, *right;
} *root = NULL;

void topView(struct Node *);
void leftTopView(struct Node *,int);
void rightTopView(struct Node *,int);
struct Node *create(int);

void main(void)
{
    // binary tree
    root = create(1);
    root->left = create(2);
    root->right = create(3);
    root->left->left = create(4);
    root->left->right = create(5);
    root->right->right = create(6);
    root->left->left->right = create(7);
    root->right->right->left = create(8);
    root->left->left->right->left = create(9);
    root->right->right->left->right = create(11);
    root->right->right->left->right->right = create(12);
    root->left->left->right->left->left = create(10);

    topView(root);
}

void topView(struct Node *root)
{
    if(root != NULL)
    {
        printf("%d ",root->data);
        leftTopView(root->left,-1);
        rightTopView(root->right,+1);
    }
}

void leftTopView(struct Node *temp, int width)
{
    if (temp != NULL)
    {
        static int left = 0;

        if(width < left)
        {
            printf("%d ",temp->data);
            left = width;
        }

        leftTopView(temp->left,width-1);
        leftTopView(temp->right,width+1);
    }
}

void rightTopView(struct Node *temp, int width)
{
    if (temp != NULL)
    {
        static int right = 0;

        if(width > right)
        {
            printf("%d ",temp->data);
            right = width;
        }

        rightTopView(temp->right,width+1);
        rightTopView(temp->left,width-1);
    }
}

struct Node *create(int value)
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->data = value;
    n->left = NULL;
    n->right = NULL;
    return n;
}
