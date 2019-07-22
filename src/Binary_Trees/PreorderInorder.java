package Binary_Trees;

import static Binary_Trees.LevelOrderTraversal.levelOrder;

public class PreorderInorder {

    public static BinaryTreeNode<Integer> buildTreeHelper(int inS, int inE, int preS, int preE, int[] in, int[] pre){

        if(inS > inE){
            return null;
        }

        int rootData = pre[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int index = -1;
        for(int i = inS; i <= inE; i++){
            if(in[i] == rootData){
                index = i;
                break;
            }
        }

//        if(index == -1){
//            return null;
//        }

        int leftInS = inS;
        int leftInE = index - 1;
        int leftPreS = preS + 1;
        int leftPreE = leftInE - leftInS + leftPreS;
        int rightInS = index + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;

        root.left = buildTreeHelper(leftInS,leftInE,leftPreS,leftPreE,in,pre);
        root.right = buildTreeHelper(rightInS,rightInE,rightPreS,rightPreE,in,pre);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int in[], int pre[]){
        return buildTreeHelper(0,in.length - 1,0, pre.length - 1, in, pre);
    }

    public static void main(String[] args) {
        int in[] = {3, 2, 4, 1, 5 };
        int pre[] = { 1, 2, 3, 4, 5};
        levelOrder(buildTree(in,pre));
    }
}
