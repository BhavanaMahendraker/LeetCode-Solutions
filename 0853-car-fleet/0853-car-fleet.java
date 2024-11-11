class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        for(int i=speed.length-1; i>= 0; i--){
            pq.add(new int[]{position[i], speed[i]});
        }
        
        while(!pq.isEmpty()){
            int[] currCar = pq.poll();
            double currTime = ((double)(target - currCar[0])) / currCar[1];
            
            // We keep (and don't pop) the inital car in the car fleet 
            // because of the below example:
            // car1Time > car2Time but car1Time < car3Time 
            // so there car1 is in car fleet with car 3 but not car2.
            if(!stack.isEmpty() && currTime <= stack.peek())
                continue;
            
            stack.push(currTime);
        }
        
        return stack.size();
    }
}