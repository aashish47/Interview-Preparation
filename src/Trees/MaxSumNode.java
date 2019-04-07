package Trees;

import org.w3c.dom.Node;

public class MaxSumNode {

    static class MaxNodePair<T>{
        GenericTreeNode<T> node;
        int sum;
    }

    public static GenericTreeNode<Integer> maxSumNode(GenericTreeNode<Integer> root){
        return maxSumNodeHelper(root).node;
    }

    public static MaxNodePair<Integer> maxSumNodeHelper(GenericTreeNode<Integer> root){
        if(root == null){
            MaxNodePair<Integer> maxNodePair = new MaxNodePair<>();
            maxNodePair.node = null;
            maxNodePair.sum = 0;
            return maxNodePair;
        }

        int sum = root.data;
        for(GenericTreeNode<Integer> child: root.children){
            sum += child.data;
        }

        MaxNodePair<Integer> ans = new MaxNodePair<>();
        ans.sum = sum;
        ans.node = root;

        for(GenericTreeNode<Integer> child: root.children){
            MaxNodePair<Integer> childAns = maxSumNodeHelper(child);
            if(childAns.sum > ans.sum){
                ans = childAns;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        System.out.println(maxSumNode(root).data);
    }
}
