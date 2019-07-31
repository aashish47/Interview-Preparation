package Stacks;

public class MinStack {
    int x;
    MinStack next;
    MinStack top;
    int min;

    MinStack(){
        x = 0;
        next = null;
        top = null;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        MinStack node = new MinStack();
        node.x = x;
        node.next = top;

        if(top == null){
            top = node;
            node.min = x;
        }
        else{
            if(x < top.min){
                node.min = x;
            }
            else{
                node.min = top.min;
            }
            top = node;
        }
    }

    public void pop() {
        if(top == null){
            return;
        }
        top = top.next;
    }

    public int top() {
        if(top == null){
            return -1;
        }
        return top.x;
    }

    public int getMin() {
        if(top == null){
            return -1;
        }
        return top.min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(909204);
        stack.push(481523691);
        stack.pop();
        stack.push(465865082);
        System.out.println(stack.top);
        stack.push(243519307);
        stack.pop();
        System.out.println(stack.top);
        stack.pop();
        stack.push(844871295);
        System.out.println(stack.getMin());

    }
}
