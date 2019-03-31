package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class NodesAtDepthK {

    public static void nodesAtDepthK(GenericTreeNode<Integer> root, int level){
        if(root == null){
            System.out.println("null");
        }
        Queue<GenericTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int lev = 0;
        while(!queue.isEmpty()){
            GenericTreeNode<Integer> currentNode = queue.poll();
            if(currentNode == null){
                lev++;
            }
            if(lev == level){
                do{
                    System.out.println(queue.poll().data);
                }while(queue.peek()!= null);
             return;
            }
            for(GenericTreeNode<Integer> child: currentNode.children){
                queue.add(child);
            }
            queue.add(null);
        }


    }

    public static void printNodesAtDepthK(GenericTreeNode<Integer> root, int level){
        if(root == null){
            return ;
        }
        if(level == 0){
            System.out.println(root.data);
        }
        for(GenericTreeNode<Integer> child: root.children){
            printNodesAtDepthK(child,level-1);
        }
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        nodesAtDepthK(root,1);
    }
}
