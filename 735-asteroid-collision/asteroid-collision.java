class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid: asteroids){
            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                if(stack.peek() > Math.abs(asteroid)){
                    destroyed = true;
                    break;
                } else{
                    int popped = stack.pop();
                    if (popped == Math.abs(asteroid)){
                        destroyed = true;
                        break;
                    }
                }
            }

            if(destroyed == false){
                stack.push(asteroid);
            }
        }

        int[] res = new int[stack.size()];
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }
        return res;
    }
}