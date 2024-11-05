class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String str: tokens){
            Integer first, second;
            switch(str){
                case "+":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first + second);
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first * second);
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(str));
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