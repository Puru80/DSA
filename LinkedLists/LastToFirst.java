package LinkedLists;

import java.util.*;
import java.io.*;

public class LastToFirst
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

    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int key){
            data = key;
            next = null;
        }
    }
    
    static void printList(){
        Node node = head;
        while(node != null){
            pw.print(node.data + " ");
            node = node.next;
        }
    }

    static void moveToFront() {
        if(head == null || head.next == null)
            return;

        Node last = head;
        Node secLast = null;

        while(last.next != null){
            secLast = last;
            last = last.next;
        }

        secLast.next = null;
        last.next = head;
        head = last;

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

            head = new Node(arr[0]);
            Node curr = head;
            for(int i=1;i<arr.length;i++){
                curr.next = new Node(arr[i]);
                curr = curr.next;
            }

            printList();
            pw.println();

            moveToFront();

            printList();
            pw.println();
        }
        
        pw.flush();
    }
}
