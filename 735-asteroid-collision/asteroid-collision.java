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
        
        int[] res = new int[stack.size()];
        for(int i=res.length-1; i >=0 ; i--){
            res[i] = stack.pop();
        }

        return res;
    }
}