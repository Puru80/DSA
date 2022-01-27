package LinkedLists;

import java.util.*;
import java.io.*;

public class DetectLoop
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
    
    Node push(int data){
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
        
        return node_new;
    }
    
    void printList(Node head){
        Node node = head;
        while(node != null){
            pw.print(node.data + " ");
            node = node.next;
        }
    }

    void createLoop(Node last, int k){
        Node node = head;
        int count = 1;

        if(k==0)
            return;

        while(count <= k){
            if(count == k){
                last.next = node;
            }

            node = node.next;
            count++;
        }
    }

    boolean detectLoop(Node head){
        Node slow = head, fast = head;
        int flag=0;

        if(head.next == null)
            return false;

        while(slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                flag = 1;
                break;
            }

            
        }

        if(flag == 1)
            return true;

        return false;
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


            DetectLoop obj = new DetectLoop();
            for(int i=0;i<n;i++)
                obj.push(arr[i]);

            Node last = obj.head;
            while (last.next != null) {
                last = last.next;
            }

            obj.createLoop(last, k);

            // obj.printList(obj.head);
            pw.println(obj.detectLoop(obj.head));
        }
        
        pw.flush();
    }
}
