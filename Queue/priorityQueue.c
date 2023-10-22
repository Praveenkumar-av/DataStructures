// Priority queue - the element is removed based on priority

#include<stdio.h>

struct Element
{
    int value, priority;
}e[50];
int rear = -1, n=50;

void enqueue(int,int);
void maxPriority();
void minPriority();
int size();

void main()
{
    int choice, num, priority;
	do
	{
		printf("Enter the choice 1 to Enqueue, 2 to Dequeue maximum Priority, ");
		printf("3 to dequeue minimum Priority and 0 to exit :");
		scanf("%d",&choice)	;
		switch(choice)
		{
			case 1:
				printf("Enter the element :");
				scanf("%d",&num);
				printf("Enter the Priority :");
				scanf("%d",&priority);

				enqueue(num,priority);
				break;

			case 2:
				maxPriority();
				break;

            case 3:
                minPriority();
                break;

			default :
				if(choice != 0)
					printf("Invalid choice!\n");
		}
        ;
        printf("Size :%d\n",size());
        printf("-----------------------------\n");
	}while(choice != 0);
}

void enqueue(int num,int pr)
{
    if(rear == -1)
    {
        rear++;
        e[rear].value = num;
        e[rear].priority = pr;
    }
    else if(rear >= n-1)
    {
        printf("%d\n",rear);
        printf("%d\n",n);
        printf("Queue full!\n");
    }
    else
    {
        rear++;
        e[rear].value = num;
        e[rear].priority = pr;
    }
}

void maxPriority()
{
    // This function returns and deletes the element with highest priority
    // lesser priority value is taken highest priority here
    if(rear == -1)
    {
        printf("Queue empty!\n");
    }
    else
    {
        int max = 0;     // max stores the index of highest priority
        for(int i=1;i<=rear;i++)
        {
            if(e[i].priority < e[max].priority)
            {
                max = i;
            }
        }
        printf("Element :%d\n",e[max].value);
        printf("Priority :%d\n",e[max].priority);

        // store the last element in last fetched index
        (e+max)->value = (e+rear)->value;
        (e+max)->priority = (e+rear)->priority;

        rear--;
    }
}

void minPriority()
{
    // This function returns and deletes the element with least priority
    // higher priority value is taken least priority here
    if(rear == -1)
    {
        printf("Queue empty!\n");
    }
    else
    {
        int min = 0;     // min stores the index of highest priority
        for(int i=1;i<=rear;i++)
        {
            if(e[i].priority > e[min].priority)
            {
                min = i;
            }
        }
        printf("Element :%d\n",e[min].value);
        printf("Priority :%d\n",e[min].priority);

        // store the last element in last fetched index
        (e+min)->value = (e+rear)->value;
        (e+min)->priority = (e+rear)->priority;

        rear--;
    }
}

int size()
{
    return rear+1;
}
