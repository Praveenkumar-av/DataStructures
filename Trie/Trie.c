// Trie data structure - insertion and search in C

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define toIndex(ch) (ch - 'a')

struct TrieNode
{
	struct TrieNode *children[26]; // children
	int isEnd;					   // end of word
};

struct TrieNode *newNode();
void insert(struct TrieNode *,char *);
void printTrie(struct TrieNode *);
int search(struct TrieNode *,char *);

void main()
{
	int n, i;
	struct TrieNode *root = newNode();
	char s[20];

	printf("Enter the no. of words :");
	scanf("%d", &n);

	char(*words)[20] = (char (*)[20])calloc(n, sizeof(*words));
	for (i = 0; i < n; i++)
		scanf("%s", &words[i]);

	for (i = 0; i < n; i++)
		insert(root, words[i]);

	printTrie(root);

	printf("\nEnter the word to search :");
	scanf("%s",&s);

	int found = search(root,s);
	if(found)
		printf("Word found");
	else 
		printf("Word not found");
}

struct TrieNode *newNode()
{
	struct TrieNode *n = (struct TrieNode *)calloc(1, sizeof(struct TrieNode));

	for (int i = 0; i < 26; i++)
		n->children[i] = NULL;

	n->isEnd = 0;

	return n;
}

void insert(struct TrieNode *root, char *word)
{
	struct TrieNode *temp = root;

	int i, index;
	for (i = 0; word[i] != '\0'; i++)
	{
		index = toIndex(word[i]);
		if (temp->children[index] == NULL)
		{
			temp->children[index] = newNode();
		}
		temp = temp->children[index];
	}
	temp->isEnd = 1;
}

int search(struct TrieNode *root,char *word)
{
	struct TrieNode *temp = root;
	int len = strlen(word); 
	int i, index;

	for(i=0;i<len;i++)
	{
		index = toIndex(word[i]);
		if(temp->children[index] == NULL)
		{
			return 0;
		}
		temp = temp->children[index];
	}

	if(i == len && temp->isEnd == 1)
		return 1;	
	else 
		return 0;
}

void printTrie(struct TrieNode *temp)
{
	if(temp != NULL)
	{
		for(int i=0;i<26;i++)
			if(temp->children[i] != NULL)
			{
				printf("%c ",i+'a');
				printTrie(temp->children[i]);
			}
	}
}