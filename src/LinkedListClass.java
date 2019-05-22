public class LinkedListClass {

    /**
     *  Advantage  :  Dynamic size, easy to delete and insert element.
     *  Disadvantage :  Extra memory requires to store pointer to next node.
     */

    Node head;
    public static class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
        }
    }

    public void printList(){
        Node n = head;
        while (n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }

    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }


    public void insetAfter(Node prev_node, int new_data){
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public static void main(String[] arg){

        LinkedListClass listClass = new LinkedListClass();
        listClass.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        listClass.head.next = second;
        second.next =third;
        third.next = fourth;
        listClass.push(0);
        listClass.insetAfter(listClass.head.next,8);

        listClass.printList();
    }
}
