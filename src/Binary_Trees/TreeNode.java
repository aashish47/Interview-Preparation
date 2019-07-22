package Binary_Trees;

import java.lang.reflect.Array;
import java.sql.Statement;
import java.util.*;

public class TreeNode {
    private static Scanner s = new Scanner(System.in);
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public static TreeNode createBtree() {
        System.out.println("Enter data: ");
        int data = s.nextInt();
        if (data == -1) {
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
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            temp = stack.pop();
            ans.add(temp.val);
            current = temp.right;

        }
        return ans;

    }

    public static ArrayList<Integer> preOrderTraversal(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode temp;
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            temp = stack.pop();
            ans.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return ans;
    }

    public static ArrayList<Integer> postOrderTraversal(TreeNode A) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(A);
        TreeNode temp;
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack1.isEmpty()) {
            temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null)
                stack1.push(temp.left);
            if (temp.right != null)
                stack1.push(temp.right);
        }
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if (A == null) {
            return null;
        }

        Stack<TreeNode> stackLeftToRight = new Stack<>();
        Stack<TreeNode> stackRightToLeft = new Stack<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        stackLeftToRight.push(A);

        while (!stackLeftToRight.isEmpty() || !stackRightToLeft.isEmpty()) {

            while (!stackLeftToRight.isEmpty()) {
                TreeNode currentNode = stackLeftToRight.pop();
                temp.add(currentNode.val);

                if (currentNode.left != null) {
                    stackRightToLeft.push(currentNode.left);
                }

                if (currentNode.right != null) {
                    stackRightToLeft.push(currentNode.right);
                }
            }
            ans.add(temp);
            temp = new ArrayList<>();
            if (stackRightToLeft.isEmpty()) {
                return ans;
            }
            while (!stackRightToLeft.isEmpty()) {
                TreeNode currentNode = stackRightToLeft.pop();
                temp.add(currentNode.val);

                if (currentNode.right != null) {
                    stackLeftToRight.push(currentNode.right);
                }

                if (currentNode.left != null) {
                    stackLeftToRight.push(currentNode.left);
                }

            }
            ans.add(temp);
            temp = new ArrayList<>();
        }
        return ans;
    }

    public static HashMap<Integer, ArrayList<Integer>> print(TreeNode root, int order, HashMap<Integer, ArrayList<Integer>> map) {
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
        while (!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.poll();
            order = queueOrder.poll();
            if (!map.containsKey(order)) {
                ArrayList<Integer> temp = new ArrayList<>();
                map.put(order, temp);
            }
            ArrayList<Integer> list = map.get(order);
            list.add(currentNode.val);
            map.put(order, list);


            if (currentNode.left != null) {
                queueNode.add(currentNode.left);
                queueOrder.add(order - 1);
            }
            if (currentNode.right != null) {
                queueNode.add(currentNode.right);
                queueOrder.add(order + 1);
            }
        }
        return map;
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        map.put(0, temp);
        map = print(A, 0, map);
        Map<Integer, ArrayList<Integer>> sortedMap = new TreeMap<>(map);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> mp : sortedMap.entrySet()) {
            ans.add(mp.getValue());
        }
        return ans;
    }

    static int bPresent, cPresent;
    public static TreeNode find(TreeNode A, int B, int C){
        if(A == null){
            return null;
        }
        TreeNode leftAns = find(A.left, B, C);
        TreeNode rightAns = find(A.right, B, C);

        if(A.val == B){
            bPresent = 1;
        }

        if(A.val == C){
            cPresent = 1;
        }
        if(A.val == B || A.val == C){
            return A;
        }

        if(leftAns != null && rightAns != null){
            return A;
        }
        if(leftAns == null && rightAns == null){
            return null;
        }
        if(leftAns != null){
            return leftAns;
        }
        if(rightAns != null){
            return rightAns;
        }
        return null;

    }
    public static int lca(TreeNode A, int B, int C) {
        bPresent = 0;
        cPresent = 0;
        TreeNode ans = find(A, B, C);
        if(bPresent == 0 || cPresent == 0){
            return -1;
        }
        if(ans == null){
            return -1;
        }
        else{
            return ans.val;
        }
    }

    public static int pathSum1(TreeNode A, int B, int pathSum){
        if(A == null){
            return 0;
        }
        pathSum += A.val;
        int leftAns = pathSum1(A.left, B, pathSum);
        if(leftAns == 1){
            return 1;
        }
        if(pathSum == B && A.left == null && A.right == null){
            return 1;
        }
        int rightAns = pathSum1(A.right, B, pathSum);
        if(rightAns == 1){
            return 1;
        }
        if(pathSum == B && A.left == null && A.right == null){
            return 1;
        }
        return 0;
    }
    public static int hasPathSum(TreeNode A, int B ) {
        return pathSum1(A, B, 0);

    }

    public static ArrayList<ArrayList<Integer>> pathSumList(TreeNode A, int B, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int sum){
        if(A == null){
            return ans;
        }
        temp.add(A.val);
        sum += A.val;
        ArrayList<ArrayList<Integer>> leftAns = pathSumList(A.left, B, ans, temp, sum);
        ArrayList<ArrayList<Integer>> rightAns = pathSumList(A.right, B, ans, temp, sum);
        if(sum == B && A.left == null && A.right == null){
            ArrayList<Integer> currAns = new ArrayList<>();
            currAns.addAll(temp);
            ans.add(currAns);
        }
        temp.remove(temp.size() - 1);
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        return pathSumList(A, B, ans, temp, 0);
    }

    public static ArrayList<Integer> sumNumbersHelper(TreeNode A, ArrayList<Integer> ans, int num ){
        if(A == null){
            return ans;
        }
        num = num * 10 + A.val;
        ArrayList<Integer> leftAns = sumNumbersHelper(A.left, ans, num);
        ArrayList<Integer> rightAns = sumNumbersHelper(A.right, ans, num);
        if(A.left == null && A.right == null){
            ans.add(num);
        }
        return ans;
    }
    public static int sumNumbers(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans = sumNumbersHelper(A, ans, 0);
        int sum = 0;
        for(int i = 0; i < ans.size(); i++){
            sum += ans.get(i);
        }
        return sum;
    }

    public static TreeNode buildTreeHelper(int inS, int inE, int preS, int preE,ArrayList<Integer> in, ArrayList<Integer> pre){

        if(inS > inE){
            return null;
        }

        int rootData = pre.get(preS);
        TreeNode root = new TreeNode(rootData);

        int index = -1;
        for(int i = inS; i <= inE; i++){
            if(in.get(i) == rootData){
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
    public static TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> pre) {
        return buildTreeHelper(0,in.size() - 1,0, pre.size() - 1, in, pre);
    }

    public static void main(String[] args) {
//        TreeNode root = createBtree();
//        ArrayList<Integer> ans = postOrderTraversal(root);
//        for(int i : ans){
//            System.out.println(i);
//        }
//        zigzagLevelOrder(root);
//        verticalOrderTraversal(root);
//        System.out.println(lca(root, 3, 5));
//        System.out.println(pathSum(root, 22));
//        System.out.println(sumNumbers(root));
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        in.add(3);
        in.add(2);
        in.add(4);
        in.add(1);
        in.add(5);
        pre.add(1);
        pre.add(2);
        pre.add(3);
        pre.add(4);
        pre.add(5);
        buildTree(in,pre);
    }

}
