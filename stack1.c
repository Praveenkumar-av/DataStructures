// stack implementation in C using array

#include<stdio.h>

void push(int *,int,int *,int);
void pop(int *,int,int *);
void peak(int *,int);

void main()
{
	int Arr[50], n, i, top = -1, num, choice;
	printf("Enter the size :");
	scanf("%d",&n);
	
	do
	{
		printf("Enter 1 to push, 2 to pop, 3 to peak and 0 to exit :");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				printf("Enter the element to push :");
				scanf("%d",&num);
				push(Arr,n,&top,num);
				break;
				
			case 2:
				pop(Arr,n,&top);
				break;
				
			case 3:
				peak(Arr,top);
				break;
			
			default :
				if(choice != 0)
					printf("Invalid choice!\n");
		}
	}while(choice != 0);
}

void push(int *Arr,int n,int *top,int num)  
{
	// function to insert the element at the top of the stack
	if((*top) >= n-1)
	{
		printf("Stack full!\n");
	}
	else
	{
		++(*top);
		Arr[*top] = num;
	}
}

void pop(int *Arr,int n,int *top)
{
	// function to fetch and delete the top element of the stack
	if((*top) == -1)
		printf("Stack empty!\n");
	else
	{
		printf("%d\n",Arr[*top]);
		--(*top);
	}
}

void peak(int *Arr,int top)
{
	// function to fetch the top element of the stack
	if(top == -1)
		printf("Stack empty!\n");
	else
	{
		printf("%d\n",Arr[top]);
	}
}
