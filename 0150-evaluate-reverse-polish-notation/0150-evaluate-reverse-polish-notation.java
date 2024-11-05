class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String str: tokens){
            Integer first, second;
            switch(str){
                case "+":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second + first);
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second - first);
                    break;
                case "*":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second * first);
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second / first);
                    break;
                default:
                    stack.push(Integer.valueOf(str));
            }
        }
        
        return stack.pop();
    }
}

/*
["10","6","9","3","+","-11","*","/","*","17","+","5","+"]


stack =>
22


push (secondPop (operation) firstPop)

return stack.pop

*/