package Trees;

public class CheckIfContainsX {

    public static boolean checkIfContainsX(GenericTreeNode<Integer> root, int x){
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        boolean isPresent = false;
        for(GenericTreeNode<Integer> child: root.children){
            isPresent = checkIfContainsX(child,x);
        }
        return isPresent;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        System.out.println(checkIfContainsX(root,5));
    }
}
