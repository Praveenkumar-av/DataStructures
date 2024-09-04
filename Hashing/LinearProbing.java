// Linear probing in Hashing
import java.util.Arrays;
import java.util.Scanner;

class HashingLinearProbing {
    final int SIZE = 10;
    int[] table = new int[SIZE];

    HashingLinearProbing() {
        Arrays.fill(table, 0);
    }

    void insert(int key) {
        int index = hash(key);

        if (table[index] != 0)
            index = probe( index);

        if (index != -1)
            table[index] = key;
        else
            System.out.println("Hash table full");
    }

    boolean search(int key) {
        int index = hash(key);

        for (int i = 0; i < SIZE; i++)
            if (table[(index + i) % SIZE] == key)
                return true;

        return false;
    }

    boolean delete(int key)
    {
        int index = hash(key);

        if(table[index] == 0)
            return false;
        else 
        {
            int i;
            // find the location of key
            for(i=0; table[(index+i)%SIZE] != 0 && i < SIZE ;i++)
            {
                if(table[(index+i)%SIZE] == key)
                {
                    break;
                }
            }
            
            if(i == SIZE)  // key not found
                return false;

            index = (index+i)%SIZE;  // found index
            table[index] = 0;       // delete the key
            int j, data;
            // rehash the table
            for(i=1; table[(index+i)%SIZE] != 0 && i < SIZE ;i++)
            {
                j = (index+i)%SIZE;
                
                data = table[j];
                table[j] = 0;
                insert(data);
            }
            return true;
        }
    }

    int hash(int key) {
        return (key % SIZE);
    }

    int probe(int index) {
        int i;
        for (i = 1; i < 10; i++)
            if (table[(i + index) % SIZE] == 0)
                break;

        if (i != 10)
            return (i + index) % SIZE;
        else
            return -1;
    }

    void display()
    {
        int i;
        for(i=0;i<SIZE;i++)
        {
            System.out.println(i+" "+table[i]);
        }
    }
}

class LinearProbing
{
    public static void main(String[] args)
    {
        int n, data;
        HashingLinearProbing ht = new HashingLinearProbing();

        System.out.println("Enter the size :");
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        System.out.println("Enter the elements :");
        for(int i=0;i<n;i++)
        {
            data = scan.nextInt();
            ht.insert(data);
        }
        
        ht.display();

        System.out.println("Enter the element to search :");
        data = scan.nextInt();
        boolean result = ht.search(data);
        if(result)
            System.out.println("Element found");
        else 
            System.out.println("Not found");

        System.out.println("Enter the element to delete :");
        data = scan.nextInt();
        result = ht.delete(data);
        if(result)
            System.out.println("Element deleted successfully");
        else 
            System.out.println("Element Not found");

        ht.display();
    }
}