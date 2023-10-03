// Queue implementation using array in C

#include<stdio.h>

void enqueue(int);
void dequeue();
void frontElement();
void rearElement();
int size();

int arr[50], n=50, front = -1, rear = -1;

void main()
{
	int choice, num, n;
	do
	{
		printf("Enter the choice 1 to Enqueue, 2 to Dequeue, 3 to front element, ");
		printf("4 to rear element and 0 to exit :");
		scanf("%d",&choice)	;
		switch(choice)
		{
			case 1:
				printf("Enter the element to enqueue :");
				scanf("%d",&num);
				enqueue(num);
				n = size();
				printf("size :%d\n",n);
				break;
				
			case 2:
				dequeue();
				n = size();
				printf("size :%d\n",n);
				break;
			
			case 3 :
				frontElement();
				n = size();
				printf("size :%d\n",n);
				break;

			case 4 :
				rearElement();
				n = size();
				printf("size :%d\n",n);
				break;
			
			default :
				if(choice != 0)
					printf("Invalid choice!\n");
		}
	}while(choice != 0);
}

void enqueue(int num)
{
	// add element to the last
	if(front == -1)
	{
		front++;
		rear++;
		arr[front] = num;
	}
	else if(rear >= n-1)
	{
		printf("Queue full!\n");
	}
	else
	{
		rear++;
		arr[rear] = num;
	}
}

void dequeue()
{
	// fetch element in the front and delete
	if(front > rear || front == -1)
	{
		printf("Queue empty!\n");
	}
	else
	{
		printf("%d\n",arr[front]);
		front++;
	}
}

void frontElement()
{
	// fetch element in the front
	if(front > rear || front == -1)
	{
		printf("Queue empty!\n");
	}
	else
	{
		printf("%d\n",arr[front]);
	}
}

void rearElement()
{
	if(rear == -1 || front > rear)
	{
		printf("Queue empty!\n");
	}
	else
	{
		printf("%d\n",arr[rear]);
	}
}

int size()
{
	if(rear == -1 || front > rear)
		return 0;
	else
	{
		int count=0;
		for(int temp = front;temp <= rear;temp++)
			count++;

		return count;
	}
}