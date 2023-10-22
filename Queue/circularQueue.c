// Circular queue using array in C

#include<stdio.h>

void enQueue(int);
int deQueue();
int front_element();
int rear_element();
int size();

int arr[5], n=5, front = -1, rear = -1;

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
				break;

			case 2:
				num = deQueue();
				if(num != '\0')
                    printf("%d\n",num);
				break;

            case 3:
                num = front_element();
                if(num != '\0')
                    printf("%d\n",num);
                break;

            case 4:
                num = rear_element();
                if(num != '\0')
                    printf("%d\n",num);
                break;

			default :
				if(choice != 0)
					printf("Invalid choice!\n");
		}
        n = size();
        printf("Size :%d\n",n);
        printf("--------------------------\n");
	}while(choice != 0);
}

void enQueue(int num)
{
    if(front == -1)
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

int deQueue()
{
    if(front == -1)
    {
        printf("Queue empty!\n");
        return '\0';
    }
    else if(front == rear)
    {
        int num = arr[front];
        front = -1;
        rear = -1;
        return num;
    }
    else
    {
        int num = arr[front];
        front++;
        front = front%n;
        return num;
    }
}

int front_element()
{
    if(rear == -1)
    {
        printf("Queue empty!\n");
        return '\0';
    }
    else
    {
        return arr[front];
    }
}

int rear_element()
{
    if(rear == -1)
    {
        printf("Queue empty!\n");
        return '\0';
    }
    else
    {
        return arr[rear];
    }
}

int size()
{
    if(front == -1)
    {
        return 0;
    }
    else
    {
        int count=1, temp = front;
        while(temp != rear)
        {
            count++;
            temp++;
            temp = temp%n;
        }
        return count;
    }
}
