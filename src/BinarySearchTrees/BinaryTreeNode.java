package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    private static Scanner s = new Scanner(System.in);

    public static BinaryTreeNode<Integer> createBtree(){
        System.out.println("Enter data: ");
        int data = s.nextInt();
        if(data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

        System.out.println("Enter left data of" + data);
        root.left = createBtree();

        System.out.println("Enter right data of" + data);
        root.right = createBtree();

        return root;


    }

    public static void printLevelOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> currentNode = queue.poll();
            if(currentNode == null && queue.isEmpty()){
                return;
            }
            else if(currentNode == null){
                queue.add(null);
                System.out.println();
            }
            else{
                System.out.print(currentNode.data + " ");
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }


            }
        }
    }

    public static void printBtree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        printBtree(root.left);
        System.out.println(root.data);
        printBtree(root.right);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createBtree();
        printLevelOrder(root);
    }
}
