// Linked list in java
import java.util.Scanner;

class LinkedList
{
    Node head;
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    void addList(int data)
    {
        if(head == null)
        {
            head = new Node(data);
        }
        else
        {
            Node current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    void display()
    {
        Node current = head;
        if(current == null)
            System.out.println("List empty");
        else {
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }
}

class Linked_list
{
    public static void main(String[] args)
    {
        int n, i, data;
        LinkedList ll = new LinkedList();

        System.out.println("Enter the size :");
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        System.out.println("Enter the elements :");
        for(i=0;i<n;i++)
        {
            data = scan.nextInt();
            ll.addList(data);
        }
        ll.display();
    }
}