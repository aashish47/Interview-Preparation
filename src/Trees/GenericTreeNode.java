package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTreeNode<T> {
    T data;
    ArrayList<GenericTreeNode<T>> children;

    public GenericTreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
    private static Scanner s = new Scanner(System.in);

    public static GenericTreeNode<Integer> addData(){
        System.out.println("Enter data");
        int data = s.nextInt();
        GenericTreeNode<Integer> root = new GenericTreeNode<>(data),newNode;
        Queue<GenericTreeNode<Integer>> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            GenericTreeNode<Integer> currentNode = queue.poll();
            System.out.println("Enter number of children");
            int children = s.nextInt();
            for(int i = 0; i < children; i++){
                System.out.println("Enter child data");
                data = s.nextInt();
                newNode = new GenericTreeNode<>(data);
                currentNode.children.add(newNode);
                queue.add(newNode);
            }
        }
        return root;
    }

    public static void printLevelOrder(GenericTreeNode<Integer> root){

        Queue<GenericTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            GenericTreeNode<Integer> currentNode = queue.poll();
            if(currentNode == null && queue.isEmpty()){
                return;
            }
            else if(currentNode == null){
                System.out.println();
                queue.add(null);
            }
            else{
                System.out.print(currentNode.data + " ");
                for(int i = 0; i < currentNode.children.size(); i++){
                    queue.add(currentNode.children.get(i));

                }
            }

        }
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        GenericTreeNode.printLevelOrder(root);
    }
}
