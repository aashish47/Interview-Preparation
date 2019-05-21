package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> currentNode = queue.poll();
            if(currentNode == null && queue.isEmpty()){
                return;
            }
            else if(currentNode == null){
                queue.add(null);
                System.out.println();
            }
            else{
                System.out.print(currentNode.data);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        levelOrder(root);
    }
}
