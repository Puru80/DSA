package LinkedLists;

import java.util.*;
import java.io.*;

public class StartOfLoop
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
        public Node() {
        }
    }

    static void printList(Node head){
        Node node = head;
        while(node != null){
            pw.print(node.data + " ");
            node = node.next;
        }
        pw.println();
    }

    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    static Node detectLoop(Node head){
        Node temp = new Node();
        while(head!=null){
            if(head.next == null)
                return null;
            if(head.next == temp)
                break;
            
            Node nex = head.next;
            head.next = temp;
            head = nex;
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
            int n = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                        .toArray();
            int k = input.nextInt();

            Node head = new Node(arr[0]);
            Node curr = head;
            for(int i=1;i<n;i++){
                curr.next = new Node(arr[i]);
                curr = curr.next;
            }

            makeLoop(head, k);

            Node res = detectLoop(head);
            if(res == null)
                pw.println("Loop does not exist");
            else
                pw.println("Starting node is: " + res.data);

        }
        
        pw.flush();
    }
}
