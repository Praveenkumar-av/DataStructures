import java.util.Arrays;
import java.util.Scanner;

public class SeparateChaining {
    public static void main(String[] args)
    {
        HashingSeparateChaining hsc = new HashingSeparateChaining();
        int n, data;

        System.out.print("Enter the size :");
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        System.out.println("Enter the elements :");
        for(int i=0;i<n;i++)
        {
            data = scan.nextInt();
            hsc.insert(data);
        }
    }
}
class HashingSeparateChaining
{
    final int SIZE = 10;
    SortedLinkedList[] llarr = new SortedLinkedList[SIZE];

    HashingSeparateChaining()
    {
        Arrays.fill(llarr, null);
    }

    void insert(int key)
    {
        int index = hash(key);

        if(llarr[index] == null) {
            llarr[index] = new SortedLinkedList();
        }
        llarr[index].sortedAddList(key);
    }

    int hash(int key)
    {
        return key%SIZE;
    }
}

class SortedLinkedList
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

    void sortedAddList(int data)
    {
        if(head == null)
        {
            head = new Node(data);
        }
        else
        {
            Node current = head;
            boolean inserted = false;
            if(data < current.data)
            {
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
                inserted = true;
            }
            else if(!inserted)
            {
                current = head;
                while(current.next != null && current.next.data < data)
                {
                    current = current.next;
                }

                Node newNode = new Node(data);
                newNode.next = current.next;
                current.next = newNode;
            }
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