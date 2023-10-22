// Double ended queue in array in C

#include<stdio.h>

int arr[5], n=5, front=-1, rear=-1;

void enqueueFront(int);
void enqueueRear(int);
void dequeueFront();
void dequeueRear();
void frontElement();
void rearElement();
int size();

void main()
{
    int choice, i, num;
    do
    {
        printf("Enter 1 to enqueue front, 2 to enqueue rear\n");
        printf("Enter 3 to dequeue front, 4 to dequeue rear\n");
        printf("Enter 5 to front element, 6 to rear element\n");
        printf("Enter 0 to exit :");
        scanf("%d",&choice);

        switch(choice)
        {
            case 1:
                printf("Enter the element :");
                scanf("%d",&num);
                enqueueFront(num);
                break;
            case 2:
                printf("Enter the element :");
                scanf("%d",&num);
                enqueueRear(num);
                break;
            case 3:
                dequeueFront();
                break;
            case 4:
                dequeueRear();
                break;
            case 5 :
                frontElement();
                break;
            case 6:
                rearElement();
                break;

            default :
                if(choice != 0)
                    printf("Invalid input!\n");
        }
        printf("\nsize :%d\n",size());
        printf("--------------------------------------\n");
    }
    while(choice != 0);
}

void enqueueFront(int num)
{
    if(front == -1)
    {
        front++;
        rear++;
        arr[front] = num;
    }
    else if(front == 0)
    {
        if((n-1) == rear)
        {
            printf("Queue full!\n");
        }
        else
        {
            front = n-1;
            arr[front] = num;
        }
    }
    else 
    {
        if((front-1) == rear)
        {
            printf("Queue full!\n");
        }
        else
        {
            front--;
            arr[front] = num;
        }
    }
}

void enqueueRear(int num)
{
    if(front ==  -1)
    {
        front++;
        rear++;
        arr[front] = num;
    }
    else if((rear+1)%n == front)
    {
        printf("Queue full!\n");
    }
    else 
    {
        rear++;
        rear = rear%n;
        arr[rear] = num;
    }
}

void dequeueFront()
{
    if(front == -1)
    {
        printf("Queue empty!\n");
    }
    else if(front == rear)
    {
        printf("%d\n",arr[front]);
        front = -1;
        rear = -1;
    }
    else
    {
        printf("%d\n",arr[front]);
        front++;
        front = front%n;
    }
}

void dequeueRear()
{
    if(rear == -1)
    {
        printf("Queue empty!\n");
    }
    else if(rear == front)
    {
        printf("%d\n",arr[rear]);
        front = -1;
        rear = -1;
    }
    else 
    {
        printf("%d\n",arr[rear]);
        rear--;
        if(rear == -1)
        {
            rear = n-1;
        }
    }
}

void frontElement()
{
    if(front == -1)
    {
        printf("Queue empty!");
    }
    else 
    {
        printf("%d\n",arr[front]);
    }
}

void rearElement()
{
    if(rear == -1)
    {
        printf("Queue empty!");
    }
    else 
    {
        printf("%d\n",arr[rear]);
    }
}

int size()
{
    // to find the no. of elements in queue
    if(front == -1)
        return 0;
    
    int temp = front;
    int count=1;
    while(temp != rear)
    {
        count++;
        temp++;
        temp = temp%n;
    }
    return count;
}