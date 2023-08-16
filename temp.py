def insert(lst,element,pos) :
    new=[]
    n=len(lst)
    for i in range(pos) :
        new.append(lst[i])
    new.append(element)
    for i in range(pos,n) :
        new.append(lst[i])

    return new
    
lst=[1,2,3,4]
s=int(input('Enter an element to insert :'))
p=int(input('Enter the position :'))
lst=insert(lst,s,p)
print(lst)