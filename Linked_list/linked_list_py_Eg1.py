# Singly linked list in python

class Node :
    def __init__(self) :
        self.data = None
        self.next = None 
    
class LinkedList :
    def __init__(self) :
        self.head = None

    def addList(self,num) :
        if self.head is None :
            self.head = Node()
            self.head.data = num
        else :
            temp = self.head
            while temp.next is not None :
                temp = temp.next
            
            temp.next = Node()
            temp.next.data = num

    def display(self) :
        temp = self.head
        while temp is not None :
            print(temp.data)
            temp = temp.next
        
l = LinkedList()  # create object for linked list

n = int(input("Enter the no. of elements :"))
print("Enter the elements :")
for i in range(n) :
    num = int(input())
    l.addList(num)

l.display()  # display the elements