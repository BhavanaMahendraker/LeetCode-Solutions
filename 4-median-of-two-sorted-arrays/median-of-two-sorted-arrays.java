class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

        int i = 0, j=0;
        while(i < nums1.length || j < nums2.length){
            if(i < nums1.length && j< nums2.length){
                if(nums1[i] <= nums2[j]){
                    minHeap.add(nums1[i]);
                    i++;
                } else{
                    minHeap.add(nums2[j]);
                    j++;
                }
            } else if(i < nums1.length){
                minHeap.add(nums1[i]);
                i++;
            } else {
                minHeap.add(nums2[j]);
                j++;
            }

            maxHeap.add(minHeap.poll());
            if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }
        }

        if((nums1.length + nums2.length) % 2 == 0){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } 

        return minHeap.peek();
    }
}