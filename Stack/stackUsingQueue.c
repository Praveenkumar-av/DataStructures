// Stack using two queue

#include<stdio.h>

int q1[50], q2[50], n = 50, front1 = -1, rear1 = -1, front2 = -1, rear2 = -1;

void push(int);
int pop();
void enqueue(int *,int *,int *,int);
int dequeue(int *,int *,int *);
void swap(int *,int *);
int isq1Empty();
int isq2Empty();

void main()
{
    int choice, num;

    do
	{
		printf("Enter 1 to push, 2 to pop and 0 to exit :");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				printf("Enter the element to push :");
				scanf("%d",&num);
				push(num);
				break;
				
			case 2:
                if(isq1Empty())
                    printf("Queue empty!\n");
                else 
                {
                    num = pop();
				    printf("%d\n",num);
                }
				break;
			
			default :
				if(choice != 0)
					printf("Invalid choice!\n");
		}
	}while(choice != 0);
}

void push(int val)
{
    // enqeue value in q2
    enqueue(q2,&front2,&rear2,val);
    
    int temp;
    // dequeue elements from q1 and enqueue into q2
    while(!isq1Empty())
    {
        temp = dequeue(q1,&front1,&rear1);
        enqueue(q2,&front2,&rear2,temp);
    }

    // swap the contents of q1 and q2
    swap(q1,q2);
}

int pop()
{
    return dequeue(q1,&front1,&rear1);
}

void enqueue(int *q,int *front,int *rear,int val)
{
    if(*front == -1)
    {
        *front = *rear = 1;
        q[*rear] = val;
    }
    else if(*rear >= n-1)
    {
        printf("Queue full!\n");
    }
    else 
    {
        (*rear)++;
        q[*rear] = val;
    }
}

int dequeue(int *q,int *front,int *rear)
{
    int val;
    if(*front ==  *rear)
    {
        val = q[*front];
        *front = *rear = -1;
    }
    else 
    {
        val = q[*front];
        (*front)++;
    }
    return val;
}

void swap(int *q1,int *q2)
{
    int temp;
    while(!isq2Empty())
    {
        temp = dequeue(q2,&front2,&rear2);
        enqueue(q1,&front1,&rear1,temp);
    }
}

int isq1Empty()
{
    if(front1 == -1 && rear1 == -1)
        return 1;
    else 
        return 0;
}

int isq2Empty()
{
    if(front2 == -1 && rear2 == -1)
        return 1;
    else 
        return 0;
}