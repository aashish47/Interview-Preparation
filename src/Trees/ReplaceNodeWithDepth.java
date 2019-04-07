package Trees;

public class ReplaceNodeWithDepth {

    public static void replaceNodeWithDepth(GenericTreeNode<Integer> root,int depth){
        root.data = depth;
        for(GenericTreeNode<Integer> child : root.children){
            replaceNodeWithDepth(child,depth + 1);
        }
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        replaceNodeWithDepth(root,0);
        GenericTreeNode.printLevelOrder(root);
    }
}
