package LinkedLists;

import java.util.*;
import java.io.*;

class LinkedList{
    Node head;

    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
        }
    }

    void insert(LinkedList list, int data){

        Node node_new = new Node(data);
        node_new.next = null;

        if(list.head == null)
            list.head = node_new;
        else{
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node_new;
        }

        // return list;
    }

    void printList(Node node)
    {
        // Node node = list.head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println();
    }

    Node reverseIterative(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;

        return node;
    }

    Node reverseRecursive(Node head)
    {
        if (head == null || head.next == null)
            return head;
 
        Node rest = reverseRecursive(head.next);
        head.next.next = head;
 
        head.next = null;

        return rest;
    }
}

public class ReverseLL
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

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
                            
            LinkedList list = new LinkedList();
            for(int i=0;i<arr.length;i++)
                list.insert(list, arr[i]);

            // list.head = list.reverseIterative(list.head);
            // list.printList(list.head);

            list.head = list.reverseRecursive(list.head);
            list.printList(list.head);

        }
        
        pw.flush();
    }
}
