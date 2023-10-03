// program to evaluate the postfix notation

#include<stdio.h> 

int evaluate(char *);
int calculate(int,int,char);
void push(char);
char pop();

void main()
{
	char arr[50];
	printf("Enter the postfix expression :");
	scanf("%s",arr);
	int result = evaluate(arr);
	printf("Result :%d",result);
}

int st[50];
int top = -1, n=50;

int evaluate(char *exp)
{
//	int a, b, c, d, e, f, g;
	char temp1, temp2;
	int v1, v2, i, ch, result;
	for(i=0;exp[i] != '\0';i++)
	{
		ch = exp[i];
		if(isalnum(ch))
		{
			ch -= '0';   // character to integer
			push(ch);
		}
		else
		{
			v2 = pop();
			v1 = pop();
//			temp2 = pop();
//			temp1 = pop();
//			if(isdigit(temp1))
//			{
//				v1 = temp1 - '0';
//			}
//			else if(isalpha(temp1))
//			{
//				v1 = temp1 - '0';
//			}
//			if(isdigit(temp2))
//			{
//				v2 = temp2 - '0';
//			}
//			else if(isalpha(temp2))
//			{
//				v2 = temp2 - '0';
//			}

			result = calculate(v1,v2,ch);
			push(result);
		}
	}
	result = pop();
	return result;
}

int calculate(int v1,int v2,char ch)
{
	switch(ch)
	{
		case '+' :
			return v1+v2;
		case '-' :
			return v1-v2;
		case '*' :
			return v1*v2;
		case '/' :
			return v1/v2;
		default :
			return 0;
	}
}

void push(char ch)
{
	if(top >= n-1)
	{
		printf("Stack full");
	}
	else
	{
		top++;
		st[top] = ch;
	}
}

char pop()
{
	if(top == -1)
	{
		return '\0';
	}
	else
	{
		char ch = st[top];
		top--;
		return ch;
	}
}
