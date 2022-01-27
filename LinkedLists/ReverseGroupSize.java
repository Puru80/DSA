package LinkedLists;

import java.util.*;
import java.io.*;


public class ReverseGroupSize
{
    public static PrintWriter pw ;

    static class FastReader  
    {
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader() throws FileNotFoundException
        {
            br = new BufferedReader(
                new FileReader("D:/VSCode/DSA/input.txt"));
        }
     
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
     
        int nextInt() { return Integer.parseInt(next()); }
     
        long nextLong() { return Long.parseLong(next()); }
     
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
     
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    Node head;
    
    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    Node reverse(Node head, int k){
        if(head == null)
            return null;
        Node next = null;
        Node curr = head;
        Node prev = null;

        int count=0;

        while(count < k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            head.next = reverse(next, k);

        return prev;
    }

    void push(int data){
        Node new_node = new Node(data);

        new_node.next = head;

        head = new_node;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null) {
            pw.print(temp.data + " ");
            temp = temp.next;
        }
        pw.println();
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            int k = input.nextInt();

            ReverseGroupSize obj = new ReverseGroupSize();

            for(int i=arr.length-1;i>=0;i--)
                obj.push(arr[i]);

            obj.head = obj.reverse(obj.head, k);
            obj.printList();

        }
        
        pw.flush();
    }
}