package Trees;

public class NodesGreaterThanX {

    public static int nodesGreaterThanX(GenericTreeNode<Integer> root, int x){
        if(root == null){
            return 0;
        }

        int count = 0;

        if(root.data > x){
            count++;
        }

        for(GenericTreeNode<Integer> child:root.children){
            count += nodesGreaterThanX(child,x);
        }
        return count;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        int count = nodesGreaterThanX(root,5);
        System.out.println(count);
    }
}
