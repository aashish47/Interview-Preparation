package Trees;

public class SecondLargestElement {

    static class Pair<T>{
        T first;
        T second;
        Pair(T first,T second){
            this.first = first;
            this.second = second;
        }
    }



    public static GenericTreeNode<Integer> secondLargestElement(GenericTreeNode<Integer> root){
        return helper(root).second;
    }

    public  static  Pair<GenericTreeNode<Integer>> helper(GenericTreeNode<Integer> root){
        Pair<GenericTreeNode<Integer>> output;
        if(root == null){
            output = new Pair<>(null,null);
            return output;
        }
        output = new Pair<>(root,null);

        for(GenericTreeNode<Integer> child : root.children){
            Pair<GenericTreeNode<Integer>> childPair = helper(child);

            if(output.first.data < childPair.first.data){
                if(childPair.second == null || childPair.second.data < output.first.data){
                    output.second = output.first;
                    output.first = childPair.first;

                }
                else {
                    output.first = childPair.first;
                    output.second = childPair.second;
                }
            }
            else if(output.first.data != childPair.first.data && (output.second == null || childPair.first.data > output.second.data)){
                output.second = childPair.first;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        GenericTreeNode<Integer> root = GenericTreeNode.addData();
        System.out.println(secondLargestElement(root).data);

    }
}
