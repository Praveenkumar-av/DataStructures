// program to convert infix to postfix notation

#include<stdio.h>
#include<ctype.h>

void find(char *);
int precedence(char);
void push(char);
char pop();

void main()
{
	char arr[50];
	printf("Enter the string :");
	scanf("%s",arr);
	find(arr);
}

char st[50];
int top=-1, n=50;

void find(char *exp)
{
	char ch, out;
	int i, prch, prst;
	for(i=0;exp[i] != '\0';i++)
	{
		ch = exp[i];
		if((isalnum(ch)) != 0)
		{
			printf("%c",ch);
		}
		else
		{
			prch = precedence(ch);
			prst = precedence(st[top]);
			if(ch == '(')
			{
				push(ch);
			}
			else if(ch == ')')
			{
				while(st[top] != '(' && top != -1)
				{
					out = pop();
					printf("%c",out);
				}
				pop();
			}
			else if(prch <= prst)
			{
				while(prch <= prst)
				{
					out = pop();
					printf("%c",out);
					prst = precedence(st[top]);
				}
				push(ch);
			}
			else if(prch > prst)
			{
				push(ch);
			}
		}
	}
	while(top >= 0)
	{
		out = pop();
		printf("%c",out);
	}
}

int precedence(char ch)
{
	switch(ch)
	{
		case '+' :
		case '-' :
			return 1;
		case '*' :
		case '/' :
			return 2;
		case '^' :
			return 3;
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
