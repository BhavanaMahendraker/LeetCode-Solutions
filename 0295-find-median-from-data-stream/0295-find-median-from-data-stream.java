class MedianFinder {
    PriorityQueue<Integer> smallValues; // Max Heap 
    PriorityQueue<Integer> largeValues; // Min Heap 

    public MedianFinder() {
        smallValues = new PriorityQueue<>((a,b) -> b - a);
        largeValues = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallValues.add(num);
        if(!smallValues.isEmpty() && !largeValues.isEmpty() && smallValues.peek() > largeValues.peek()){
            largeValues.add(smallValues.poll());
        }
        
        if(Math.abs(smallValues.size() - largeValues.size()) > 1){
            if(smallValues.size() > largeValues.size())
                largeValues.add(smallValues.poll());
            else
                smallValues.add(largeValues.poll());
        }
    }
    
    public double findMedian() {
        if(smallValues.size() == largeValues.size())
            return ((double) (smallValues.peek() + largeValues.peek())) / 2;
        return smallValues.size() > largeValues.size() ? smallValues.peek() : largeValues.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */