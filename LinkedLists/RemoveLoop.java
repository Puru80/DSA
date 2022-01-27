package LinkedLists;

import java.util.*;
import java.io.*;

public class RemoveLoop
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
    
    static void push(int data){
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
    
    /* public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    static int detectAndRemoveLoop(Node node)
    {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    } */

    static void detectAndRemoveLoop(Node head){
        if(head == null || head.next == null)        
            return;
        
        Node fast = head, slow=head;

        slow = slow.next;
        fast = fast.next.next;

        while(fast != null && fast.next != null){
            if(slow == fast)
                break;
            
            fast = fast.next.next;
            slow = slow.next;
        }

        if(slow == fast){
            slow = head;
            if(slow != fast){
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }
            else{
                while(fast.next != slow)
                    fast = fast.next;
                fast.next = null;
            }
        }
    }
    
    static void printList(Node head){
        while(head != null){
            pw.print(head.data + " ");
            head = head.next;
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
            int n = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                        .toArray();
            int k = input.nextInt();

            Node head = new Node(arr[0]);
            Node curr = head;
            for(int i=1;i<n;i++){
                curr.next = new Node(arr[i]);
                curr = new Node(arr[i]);
            }

            printList(head);

            makeLoop(head, k);

            detectAndRemoveLoop(head);
            printList(head);
            // pw.println(detectLoop(head));
        }
        
        pw.flush();
    }
}