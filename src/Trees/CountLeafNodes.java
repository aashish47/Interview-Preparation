package Trees;

public class CountLeafNodes {

    public static int countLeafNodes(GenericTreeNode<Integer> root){

        if(root == null){
            return 0;
        }

        if(root.children.size() == 0){
            return 1;
        }
        int count = 0;
        for(GenericTreeNode<Integer> node : root.children){
            count += countLeafNodes(node);
        }
        return count;
    }
    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        int count = countLeafNodes(root);
        System.out.println(count);
    }
}
