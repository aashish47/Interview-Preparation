package Binary_Trees;

import java.util.Stack;

public class ZigZagTree {

    public static void printZigZag(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        Stack<BinaryTreeNode<Integer>> stackLeftToRight = new Stack<>();
        Stack<BinaryTreeNode<Integer>> stackRightToLeft = new Stack<>();

        stackRightToLeft.push(root);

        while(!stackLeftToRight.isEmpty() || !stackRightToLeft.isEmpty()){
            while(!stackRightToLeft.isEmpty()){
                BinaryTreeNode<Integer> currentNode = stackRightToLeft.pop();
                System.out.print(currentNode.data);
                if(currentNode.right != null){
                    stackLeftToRight.push(currentNode.right);
                }
                if(currentNode.left  != null) {
                    stackLeftToRight.push(currentNode.left);
                }

            }
            System.out.println();
            while(!stackLeftToRight.isEmpty()){
                BinaryTreeNode<Integer> currentNode = stackLeftToRight.pop();
                System.out.print(currentNode.data);
                if(currentNode.left  != null) {
                    stackRightToLeft.push(currentNode.left);
                }
                if(currentNode.right != null){
                    stackRightToLeft.push(currentNode.right);
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        printZigZag(root);
    }
}
