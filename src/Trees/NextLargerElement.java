package Trees;

public class NextLargerElement {

    public static GenericTreeNode<Integer> nextLargerElement(GenericTreeNode<Integer> root,int n){
        if(root == null){
            return null;
        }
        GenericTreeNode<Integer> ans = null;
        if(root.data > n){
             ans = root;
        }
        for(GenericTreeNode<Integer> child: root.children){
            GenericTreeNode<Integer> temp = nextLargerElement(child,n);
            if(temp != null) {
                if (ans == null || temp.data < ans.data) {
                    ans = temp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        System.out.println(nextLargerElement(root,18).data);
    }
}
