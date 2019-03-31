package Trees;

public class SumOfAllNodes {

    public static int sumOfAllNodes(GenericTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int sum = root.data;
        for(GenericTreeNode<Integer> child: root.children){
            sum += sumOfAllNodes(child);
        }
        return sum;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        int sum = sumOfAllNodes(root);
        System.out.println(sum);
    }
}
