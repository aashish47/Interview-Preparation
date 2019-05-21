package Binary_Trees;

public class IsBalanced {

    static class CheckBalacedReturnType{
        int height;
        Boolean isBlanced;
    }

    public static Boolean checkBalanced(BinaryTreeNode<Integer> root){
        return checkBalacedHelper(root).isBlanced;
    }

    public static CheckBalacedReturnType checkBalacedHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            CheckBalacedReturnType ans = new CheckBalacedReturnType();
            ans.height = 0;
            ans.isBlanced = true;
            return ans;
        }

        CheckBalacedReturnType leftAns = checkBalacedHelper(root.left);
        CheckBalacedReturnType rightAns = checkBalacedHelper(root.right);

        int heightDiff = leftAns.height > rightAns.height ? leftAns.height - rightAns.height : rightAns.height - leftAns.height;

        CheckBalacedReturnType ans;

        if(!leftAns.isBlanced || !rightAns.isBlanced || heightDiff > 1){
            ans = new CheckBalacedReturnType();
            ans.height = Math.max(leftAns.height,rightAns.height) + 1;
            ans.isBlanced = false;
        }
        else{
            ans = new CheckBalacedReturnType();
            ans.height = Math.max(leftAns.height,rightAns.height) + 1;
            ans.isBlanced = true;
        }
        return  ans;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        checkBalanced(root);
    }
}
