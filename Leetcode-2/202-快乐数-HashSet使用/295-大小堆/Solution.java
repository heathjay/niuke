class MedianFinder {
    PriorityQueue<Integer> maxheap ;
    PriorityQueue<Integer> minheap;

    /** initialize your data structure here. */
    public Comparator<Integer> comparator = new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2){
            return o2.compareTo(o1);
        }
    };
    public MedianFinder() {

        maxheap = new PriorityQueue<>(comparator);

        //maxheap = new PriorityQueue<>((x,y) -> y- x);
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(minheap.size() - maxheap.size() > 1){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() == minheap.size()){
            return (double)(maxheap.peek() + minheap.peek())/2;

        }else{
            return (double)minheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */