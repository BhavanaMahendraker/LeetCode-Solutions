class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int pos = 0;
        int[] res = new int[nums.length - k + 1];
        
        for(int right = 0; right<nums.length; right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.addLast(right);
            
            if(!dq.isEmpty() && right - dq.peekFirst() + 1 > k){
                dq.pollFirst();
            }
            
            if(right >= k-1){
                res[pos++] = nums[dq.peekFirst()];
            }

        }
        
        return res;
    }
}

/*

[1,3,1,2,0,5]
 l
       r



*/
