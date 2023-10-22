class Node :
    def __init__(self) :
        self.a = None
        self.next = None

class LinkedList :
    def __init__(self) :
        self.head = None

def create(llist,num) :
    if llist.head == None :
        llist.head = Node()
        llist.head.a = num
    else :
        temp = llist.head
        while temp.next is not None :
            temp = temp.next
        
        temp.next = Node()
        temp.next.a = num


def display(llist) :
    temp = llist.head
    while temp != None :
        print(temp.a)
        temp = temp.next
    

llist = LinkedList()
n = int(input("Enter the no. of elements :"))
print("Enter the elements :")
for i in range(n) :
    num = input()
    create(llist,num)
display(llist)