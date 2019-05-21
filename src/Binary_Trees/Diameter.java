package Binary_Trees;

public class Diameter {
    static class DiameterObject{
        int diameter;
        int height;

        public DiameterObject(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        return diameterBetter(root).diameter;
    }
    public static <T> DiameterObject diameterBetter(BinaryTreeNode<T> root) {
        if(root == null){
            return new DiameterObject(0,0);
        }
        DiameterObject left = diameterBetter(root.left);
        DiameterObject right = diameterBetter(root.right);
        int x = left.height + right.height + 1;

        int currentDiameter = Math.max(Math.max(left.diameter,right.diameter),x);
        int currentHeight = Math.max(left.height,right.height) + 1;

        return new DiameterObject(currentDiameter,currentHeight);

    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        diameterOfBinaryTree(root);
    }
}
