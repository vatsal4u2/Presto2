package Alogorythm;

public class BinaryToDoubleLinkedList {

    Node root;

    public static void main(String[] arg){
        BinaryToDoubleLinkedList tree = new BinaryToDoubleLinkedList();

        // Let us create the tree shown in above diagram
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        Node head = tree.bintree2list(tree.root);

        // Print the converted list
        tree.printList(head);
        System.out.println("Tree is : " + BinaryToDoubleLinkedList.isBst(tree.root));


    }



    private Node binaryTreeToListUtil(Node node){

        if(node == null){
            return node;
        }

        if(node.left != null){
            Node left = binaryTreeToListUtil(node.left);
            // now if there is no more left node

            for(;left.right != null;left = left.right);
            left.right = node;
            node.left = left;
        }

        if(node.right != null){
            Node right = binaryTreeToListUtil(node.right);
            for(;right.left != null; right = right.left);
            right.left = node;
            node.right = right;
        }
        return node;
    }

    private Node bintree2list(Node node)
    {
        // Base case
        if (node == null)
            return node;

        // Convert to DLL using bintree2listUtil()
        node = binaryTreeToListUtil(node);

        // bintree2listUtil() returns root node of the converted
        // DLL.  We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost node
        while (node.left != null)
            node = node.left;

        return node;
    }

    private void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    private static boolean isBstRec(Node root,
                                    int minValue,
                                    int maxValue) {

        if (root == null) {
            return true;
        }

        if (root.data < minValue ||
                root.data > maxValue) {
            return false;
        }

        return
                isBstRec(root.left, minValue, root.data) &&
                        isBstRec(root.right, root.data, maxValue);
    }

    public static boolean isBst(Node root) {
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    static class Node{
        int data;
        Node left,  right;
        Node(int data){
            this.data = data;
        }
    }
}
