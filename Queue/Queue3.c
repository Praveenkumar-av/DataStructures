// Queue using linked list in C

#include<stdio.h>
#include<stdlib.h>

struct Node
{
    int a;
    struct Node *next;
}*front = NULL, *rear = NULL;

void enQueue(int);
void deQueue();

void main()
{
    int choice, num, n;
	do
	{
		printf("Enter the choice 1 to Enqueue, 2 to Dequeue, ");
		printf("3 to front element, 4 to rear element and 0 to exit :");
		scanf("%d",&choice)	;
		switch(choice)
		{
			case 1:
				printf("Enter the element to enqueue :");
				scanf("%d",&num);
				enQueue(num);
                // n = size();
                // printf("Size :%d\n",n);
				break;

			case 2:
				deQueue();
				
                // n = size();
                // printf("Size :%d\n",n);
				break;

			default :
				if(choice != 0)
					printf("Invalid choice!\n");
		}
	}while(choice != 0);
}

struct Node *create()
{
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));
    n->next = NULL;
    return n;
}

void enQueue(int num)
{
    if(front == NULL)
    {
        front = create();
        rear = front;
        front->a = num;
    }
    else
    {
        rear->next = create();
        rear->next->a = num;
        rear = rear->next;
    }
}

void deQueue()
{
    if(front == NULL)
    {
        printf("Queue empty!");
    }
    else if(front == rear)
    {
        printf("%d\n",front->a);
        front = NULL;
        rear = NULL;
    }
    else
    {
        printf("%d\n",front->a);
        front = front->next;
    }
}