#include<stdio.h>
#include<string.h>

#define toIndex(c) (c - 'a')

void main()
{
	char ch[10] = "Hello";
	printf("%d ",strlen(ch));

	char *s = ch;
	printf("%d",strlen(s));
}