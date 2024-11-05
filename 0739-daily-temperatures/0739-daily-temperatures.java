class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] warmerTemps = new int[temperatures.length];
        
        for(int i = temperatures.length - 1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                warmerTemps[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        
        return warmerTemps;
    }
}

/*
[73,74,75,71,69,72,76,73]



while peek < curr 
    pop
    
numOfDays = right - left
*/