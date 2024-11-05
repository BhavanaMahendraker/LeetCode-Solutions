class MinStack {

    Stack<int[]> minStack;
    
    public MinStack() {
        minStack = new Stack<>();    
    }
    
    public void push(int val) {
        int minVal = minStack.isEmpty() ? val : Math.min(val, minStack.peek()[1]);
        minStack.push(new int[]{val, minVal});
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek()[0];
    }
    
    public int getMin() {
        return minStack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*


[-2, 0, -3, 5, -2, 7]

stack =>

7,-3
-2,-3
[5,-3]
[-3,-3]
[0,-2]
[-2,-2]
curr, min

if currval < min -> update minSoFar

*/