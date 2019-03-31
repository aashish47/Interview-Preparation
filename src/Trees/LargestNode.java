package Trees;

public class LargestNode {

    public static int largestNode(GenericTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.children.size() == 0){
            return root.data;
        }
        int maxNode = root.data;
        for(GenericTreeNode<Integer> child : root.children){
            maxNode = Math.max(largestNode(child),maxNode);
        }
        return maxNode;
    }
    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        int data = largestNode(root);
        System.out.println(data);
    }
}
