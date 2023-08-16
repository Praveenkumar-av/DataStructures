# python program to implement operation in arrays in Data Structures

def search(lst,element) :  
    '''function to search an element in an array'''
    n=len(lst)
    for i in range(n) :
        if lst[i]==element :
            return i
    else :
        return -1

def sort(lst) :  
    '''function to sort the given array'''
    n=len(lst)
    for i in range(n) :
        for j in range(i+1,n) :
            if lst[j]<lst[i] :
                temp=lst[j]
                lst[j]=lst[i]
                lst[i]=temp

def insert(lst,element,pos) :  
    '''function to insert an element in the given position'''
    n=len(lst)
    for i in range(pos,n) :
        temp=lst[i]
        lst[i]=element
        element=temp

lst=[40,50,10,30,20]

# searching
s=int(input('Enter an element to search :'))
result=search(lst,s)
if result==-1 :
    print('Element not found!')
else :
    print('Element found at index :',result)

# sorting
sort(lst)
print('Sorted array :',lst)

# inserting
s=int(input('Enter an element :'))
p=int(input('Enter the position :'))
insert(lst,s,p)
print('Array after insertion :',lst)