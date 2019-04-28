package Binary_Trees;

public class MaxDataNode {

    public static BinaryTreeNode<Integer> max(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        BinaryTreeNode<Integer> max = root;

        BinaryTreeNode<Integer> left = null;

        if(root.left != null){
            left = max(root.left);
            if(left.data > max.data){
                max = left;
            }
        }

        BinaryTreeNode<Integer> right = null;

        if(root.right != null){
            right = max(root.right);
            if(right.data > max.data){
                max = right;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        System.out.println(max(root).data);
    }
}
