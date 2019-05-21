package Binary_Trees;

import static Binary_Trees.LevelOrderTraversal.levelOrder;

public class PostorderInorder {

    public static BinaryTreeNode<Integer> buildTreeHelper(int in[], int post[], int inS, int inE, int postS, int postE){
        if(inS > inE){
            return null;
        }
        int rootData = post[postE];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int index = -1;
        for(int i = inS; i <= inE; i++){
            if(in[i] == rootData){
                index = i;
            }
        }
        int rightInS = index + 1;
        int rightInE = inE;
        int rightPostE = postE - 1;
        int leftInS = inS;
        int leftInE = index - 1;
        int leftPostS = postS;
        int leftPostE = leftInE - leftInS + leftPostS;
        int rightPostS = leftPostE + 1;

        root.left = buildTreeHelper(in,post,leftInS,leftInE,leftPostS,leftPostE);
        root.right = buildTreeHelper(in,post,rightInS,rightInE,rightPostS,rightPostE);

        return root;


    }


    public static BinaryTreeNode<Integer> buildTree(int in[], int post[]){
        return buildTreeHelper(in,post,0,in.length - 1, 0, post.length - 1);
    }

    public static void main(String[] args) {

        int post[] = {8 ,4 ,5 ,2 ,6 ,7 ,3 ,1};
        int in[] = {4 ,8 ,2 ,5 ,1 ,6 ,3 ,7};
        levelOrder(buildTree(in,post));
    }
}
