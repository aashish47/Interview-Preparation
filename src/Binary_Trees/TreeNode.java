package Binary_Trees;
import java.sql.Statement;
import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }

    private static Scanner s = new Scanner(System.in);

    public static TreeNode createBtree(){
        System.out.println("Enter data: ");
        int data = s.nextInt();
        if(data == -1){
            return null;
        }
        TreeNode root = new TreeNode(data);

        System.out.println("Enter left data of" + data);
        root.left = createBtree();

        System.out.println("Enter right data of" + data);
        root.right = createBtree();

        return root;


    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode current = A.left;
        TreeNode temp;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            temp = stack.pop();
            ans.add(temp.val);
            current = temp.right;

        }
        return ans;

    }

    public static ArrayList<Integer> preOrderTraversal(TreeNode A){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode temp;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
          temp = stack.pop();
          ans.add(temp.val);
          if(temp.right != null){
              stack.push(temp.right);
          }
          if(temp.left != null){
              stack.push(temp.left);
          }
        }
        return ans;
    }

    public static ArrayList<Integer> postOrderTraversal(TreeNode A){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(A);
        TreeNode temp;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack1.isEmpty()){
            temp = stack1.pop();
            stack2.push(temp);
            if(temp.left != null)
                stack1.push(temp.left);
            if(temp.right != null)
                stack1.push(temp.right);
        }
        while(!stack2.isEmpty()){
            ans.add(stack2.pop().val);
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if(A == null){
            return null;
        }

        Stack<TreeNode> stackLeftToRight = new Stack<>();
        Stack<TreeNode> stackRightToLeft = new Stack<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        stackLeftToRight.push(A);

        while(!stackLeftToRight.isEmpty() || !stackRightToLeft.isEmpty()){

            while(!stackLeftToRight.isEmpty()){
                TreeNode currentNode = stackLeftToRight.pop();
                temp.add(currentNode.val);

                if(currentNode.left  != null) {
                    stackRightToLeft.push(currentNode.left);
                }

                if(currentNode.right != null){
                    stackRightToLeft.push(currentNode.right);
                }
            }
            ans.add(temp);
            temp = new ArrayList<>();
            if(stackRightToLeft.isEmpty()){
                return ans;
            }
            while(!stackRightToLeft.isEmpty()){
                TreeNode currentNode = stackRightToLeft.pop();
                temp.add(currentNode.val);

                if(currentNode.right != null){
                    stackLeftToRight.push(currentNode.right);
                }

                if(currentNode.left  != null) {
                    stackLeftToRight.push(currentNode.left);
                }

            }
            ans.add(temp);
            temp = new ArrayList<>();
        }
        return ans;
    }

    public static HashMap<Integer,ArrayList<Integer>> print(TreeNode root, int order, HashMap<Integer,ArrayList<Integer>> map){
//        if(root == null){
//            return map;
//        }
//        if(!map.containsKey(order)){
//            ArrayList<Integer> temp = new ArrayList<>();
//            map.put(order,temp);
//        }
//        ArrayList<Integer> list = map.get(order);
//        list.add(root.val);
//        map.put(order,list);
//        print(root.left,order - 1,map);
//        print(root.right,order + 1,map);
//        return map;

        Queue<Integer> queueOrder = new LinkedList<>();
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.add(root);
        queueOrder.add(order);
        while(!queueNode.isEmpty()){
            TreeNode currentNode = queueNode.poll();
            order = queueOrder.poll();
            if(!map.containsKey(order)){
                ArrayList<Integer> temp = new ArrayList<>();
                map.put(order,temp);
            }
            ArrayList<Integer> list = map.get(order);
            list.add(currentNode.val);
            map.put(order,list);


            if(currentNode.left!= null){
                queueNode.add(currentNode.left);
                queueOrder.add(order - 1);
            }
            if(currentNode.right!= null){
                queueNode.add(currentNode.right);
                queueOrder.add(order + 1);
            }
        }
        return map;
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        map.put(0,temp);
        map = print(A,0,map);
        Map<Integer,ArrayList<Integer>> sortedMap = new TreeMap<>(map);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> mp: sortedMap.entrySet()){
            ans.add(mp.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = createBtree();
//        ArrayList<Integer> ans = postOrderTraversal(root);
//        for(int i : ans){
//            System.out.println(i);
//        }
//        zigzagLevelOrder(root);
        verticalOrderTraversal(root);

    }

}
