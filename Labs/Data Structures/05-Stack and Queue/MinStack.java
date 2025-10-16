class MinStack {
    private int[] stack = new int[1000];
    private int[] minStack = new int[1000];
    private int top = -1;

    public void push(int val) {
        top++;
        stack[top] = val;
        if (top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = val < minStack[top - 1] ? val : minStack[top - 1];
        }
    }

    public void pop() {
        if (top >= 0) {
            top--;
        }
    }

    public int top() {
        if (top < 0) return -1; 
        return stack[top];
    }

    public int getMin() {
        if (top < 0) return -1; 
        return minStack[top];
    }
}
