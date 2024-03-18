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

        System.out.println("Enter the element to search :");
        data = scan.nextInt();
        boolean result = ht.search(data);
        if(result)
            System.out.println("Element found");
        else 
            System.out.println("Not found");
    
    }
}