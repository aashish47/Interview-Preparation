package Binary_Trees;

import javax.swing.text.Position;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseLinkedList {

    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }

    public static ArrayList<Node<BinaryTreeNode<Integer>>> levelwiseLinkedList(BinaryTreeNode<Integer> root){
        Node<BinaryTreeNode<Integer>> head, temp = null;
        ArrayList<Node<BinaryTreeNode<Integer>>> list = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int flag = 0;

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> currentNode = queue.poll();
            if(currentNode == null && queue.isEmpty()){
                return list;
            }
            else if(currentNode == null){
                queue.add(null);
                flag = 0;
            }
            else{
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }

                Node<BinaryTreeNode<Integer>> newNode = new Node<>(currentNode);
                if(flag == 0){
                    head = newNode;
                    list.add(newNode);
                    flag = 1;
                    temp = head;
                }
                else{
                    temp.next = newNode;
                    temp = newNode;
                }

            }
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
    }
}
