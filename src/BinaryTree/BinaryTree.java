package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node head;

    public BinaryTree() {
        this.head = null;
    }

    public void inOrderPrintBST(){
        System.out.print("Inorder : ");
        printInOrder(head);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if(node!=null){
            printInOrder(node.left);
            System.out.print(node.data+" ");
            printInOrder(node.right);
        }
    }

    public void levelOrderTraversal(){
        System.out.print("\nLevelOrderTraversal : ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
            System.out.print(temp.data+" ");
        }
        System.out.println();
    }

    public ArrayList<Integer> inverseLevelOrderTraversal(){
        System.out.print("\nInverseLevelOrderTraversal : ");
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        int i = 0;
        int n = 1;

        while (i<n){
            Node temp = queue.get(i++);
            if(temp.right != null) {
                queue.add(temp.right);
                n++;
            }
            if(temp.left != null) {
                queue.add(temp.left);
                n++;
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (--n>=0){
            arr.add(queue.get(n).data);
        }
        return  arr;
    }

    public int getBSTHeight(){
        return getBSTHeight(head,0);
    }

    private int getBSTHeight(Node node, int h) {
        if(node==null){
            return h;
        }
        int left_height = getBSTHeight(node.left,h+1);
        int right_height = getBSTHeight(node.right,h+1);
        return Math.max(left_height,right_height);
    }

}
