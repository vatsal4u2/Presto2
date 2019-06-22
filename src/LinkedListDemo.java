import java.util.HashSet;

public class LinkedListDemo {

    Node head;
    public static void main(String arg[]){
        LinkedListDemo demo =  new LinkedListDemo();
        demo.head =  new Node(0);
        demo.head.next = new Node(1);
        demo.head.next.next = new Node(2);
        demo.head.next.next.next = new Node(3);
        demo.head.next.next.next.next = new Node(2);
        demo.head.next.next.next.next.next = new Node(2);
        demo.head.next.next.next.next.next.next = new Node(3);
        demo.head.next.next.next.next.next.next.next = new Node(4);
        demo.printList(demo.head);

        System.out.println("####");
        demo.reverseList(demo.head);

    }

    public void printList(Node node){
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void reverseList(Node node){
        Node previous = null;
        Node current = node;
        Node next =  null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        node = previous;
        printList(node);
    }
    
    /**
     * This is static Node class
     *
     */
    private static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
        }
    }
}
