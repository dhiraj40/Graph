package BinaryTree;

import java.util.*;

public class BinarySearchTree extends BinaryTree{

    public void insert(int data){
        if(head==null){
            this.head = new Node(data);
        }else {
            insertChild(head,data);
        }
    }

    private void insertChild(Node node,int data){
        if(node.data >= data){
            if(node.left == null) {
                node.left = new Node(data);
            }else insertChild(node.left,data);
        }
        else{
            if(node.right == null){
                node.right = new Node(data);
            }else insertChild(node.right,data);
        }
    }


}
