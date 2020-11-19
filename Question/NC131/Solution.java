import java.util.*;


public class Solution {
    /**
     * the medians
     * @param operations int整型二维数组 ops
     * @return double浮点型一维数组
     */
    public double[] flowmedian (int[][] operations) {
        // write code here
    }
}


public static class MedianHolder{
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());

    private void modifyTwoHeapSize(){
        if(this.maxHeap.size() == this.minHeap.size() + 2){
            this.minHeap.add(this.maxHeap.poll());
        }

        if(this.minHeap.size() == this.maxHeap.size() + 2){
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public void addNumber(int num){
        if(this.maxHeap.isEmpty()){
            this.maxHeap.add(num);
            return;
        }

        if(this.maxHeap.peek() >= num){
            this.maxHeap.add(num);
        }else{
            if(this.minHeap.isEmpty()){
                this.minHeap.add(num);
                return;
            }

            if(this.minHeap.peek() > num){
                this.maxHeap.add(num);
            }else{
                this.minHeap.add(num);
            }
        }

        modifyTwoHeapSize();
    }


    public Integer getMedian(){
        int maxHeapSize = this.maxHeap.size();
        int minHeapSize = this.minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }
        Integer maxHeapHead = this.maxHeap.peek();
        Integer minHeapHead = this.minHeap.peek();
        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeapHead + minHeapHead) / 2;
        }
        return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
    }
}
public static class MaxHeapComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2){
        if(o2 > o1){
            return 1;
        }else{
            return -1;
        }
    }
}
public static class MinHeapComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2){
        if(o2 < o1){
            return 1;
        }else{
            return -1;
        }
    }
}