class MedianFinder {
    PriorityQueue<Integer> smallValues; // Max Heap 
    PriorityQueue<Integer> largeValues; // Min Heap 
    public MedianFinder() {
        smallValues = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        largeValues = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallValues.add(num);
        largeValues.add(smallValues.poll());
        if(largeValues.size() - smallValues.size() > 1){
            smallValues.add(largeValues.poll());
        }
    }
    
    public double findMedian() {
        if(smallValues.size() == largeValues.size()){
            return smallValues.peek() / 2.0 + largeValues.peek() / 2.0;
        }
        return largeValues.peek();
        // return smallValues.size() > largeValues.size() ? smallValues.peek() : largeValues.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */