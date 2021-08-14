package BinaryTree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Random random = new Random();
        int n = 10;

        int[] arr = {3,1,2,8,6,5,7,10};
        for (int j : arr) binarySearchTree.insert(j);

        /*
        for(int i = 0;i<n;i++){
            int x = random.ints(0,20).findFirst().getAsInt();
            binarySearchTree.insert(x);
            System.out.print(x+" ");
        }*/
        //binarySearchTree.levelOrderTraversal();
        System.out.println(binarySearchTree.inverseLevelOrderTraversal());
        System.out.println(binarySearchTree.getBSTHeight());
    }
}
