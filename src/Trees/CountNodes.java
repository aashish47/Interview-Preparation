package Trees;

public class CountNodes {

    public static int countNodes(GenericTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.children.size() == 0){
            return 1;
        }
        int count = 1;
        for(GenericTreeNode<Integer> child: root.children){
            count += countNodes(child);
        }
        return count;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        int count = countNodes(root);
        System.out.println(count);
    }
}
