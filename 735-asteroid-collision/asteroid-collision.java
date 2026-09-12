class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int ast: asteroids){
            boolean destroyed = false;
            while(ast < 0 && !stack.isEmpty() && stack.peek() > 0){
                int top = stack.peek();
                if(top > -ast){
                    destroyed = true;
                    break;
                } else if(top == -ast){
                    destroyed = true;
                    stack.pop();
                    break;
                } else{
                    stack.pop();
                }
            }

            if(!destroyed){
                stack.push(ast);
            }
        }

        int i = stack.size()-1;
        int[] res = new int[stack.size()];

        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }

        return res;
    }
}