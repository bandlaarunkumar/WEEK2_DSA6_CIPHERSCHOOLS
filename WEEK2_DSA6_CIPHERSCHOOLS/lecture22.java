package cipherschools;
import java.util.Deque;
import java.util.LinkedList;

class MaximumInEachWindow
{
    static void printMaximum(int arr[], int k)
    {
        Deque<Integer> dq = new LinkedList<>();

        int i;
        for (i=0; i<k; i++)
        {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.add(i);
        }

        for ( ; i<arr.length; i++)
        {
            System.out.println(arr[dq.peek()]);

            while (!dq.isEmpty() && dq.peekLast() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        System.out.println(arr[dq.peek()]);

        while (!dq.isEmpty())
        {
            dq.removeLast();
        }
    }


    public static void main(String args[]) 
    {
        int arr[] = {7, 6, 8, 5, 8, 3, 2, 10};

        printMaximum(arr, 3);
    }
}