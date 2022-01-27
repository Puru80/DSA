package LinkedLists;

public class Implementation
{
    Node head;

    static class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
        }
    }
    
    public static Implementation insert(Implementation list, int data){

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

        return list;
    }

    public static void printList(Implementation list)
    {
        Node currNode = list.head;
    
        System.out.print("LinkedList: ");
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
    
            // Go to next node
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) throws Exception{
        Implementation list = new Implementation();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
   
        // Print the LinkedList
        printList(list);
        
    }
}