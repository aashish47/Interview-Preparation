package Trees;

public class IdenticalTrees {

    public static boolean areIdentical(GenericTreeNode<Integer> root1,GenericTreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1.data != root2.data){
            return false;
        }
        if(root1.children.size()!= root2.children.size()){
            return false;
        }

        for(int i = 0, j = 0; i < root1.children.size() && j < root2.children.size(); i++, j++){
             if(!areIdentical(root1.children.get(i),root2.children.get(j))){
                 return false;
             }
        }
        return true;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root1 = GenericTreeNode.addData();
        GenericTreeNode<Integer> root2 = GenericTreeNode.addData();
        System.out.println(areIdentical(root1,root2));
    }
}
