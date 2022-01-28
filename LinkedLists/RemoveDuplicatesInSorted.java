package LinkedLists;

import java.util.*;
import java.io.*;

public class RemoveDuplicatesInSorted
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

    // static Node head;
    
    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
    /* void push(int data){
        Node node_new = new Node(data);
        node_new.next = null;
    
        if(head == null)
            head = node_new;
        else{
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node_new;
        }
    
    } */
    
    static void printList(Node head){
        Node node = head;
        while(node != null){
            pw.print(node.data + " ");
            node = node.next;
        }
    }

    static Node removeDuplicates(Node head){
        Node curr = head;

        while(curr != null){
            Node temp = curr;

            while(temp != null && temp.data == curr.data)
                temp = temp.next;

            curr.next = temp;
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();

            Node head = new Node(arr[0]);
            Node curr = head;
            for(int i=1;i<arr.length;i++){
                curr.next = new Node(arr[i]);
                curr = curr.next;
            }

            printList(head);
            pw.println();

            Node node = removeDuplicates(head);
            printList(node);
            pw.println();
        }
        
        pw.flush();
    }
}
