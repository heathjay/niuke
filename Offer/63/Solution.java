
import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution {
    //用来存中位数后位
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //用来村中位数前位
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>(){

        @Override
        public int compare(Integer o1, Integer o2){
            return o2 - o1;
        }

    });
    //记录偶数个数还是奇数个数
    int count = 0;
    //每次插入小顶堆的是当前大顶堆中最大的数
    //每次插入大顶堆的是当前小顶堆中最小的数
    //这样保证小顶堆中的数永远大于等于大顶堆中的数,
    //中位数就可以方便地从两者的根结点中获取的
      //优先队列中的常用方法有：增加元素，删除栈顶，获得栈顶元素，和队列中的几个函数应该是一样的
    //offer peek poll,
    public void Insert(Integer num) {
        //偶数则插入大顶堆，然后将大顶堆中最大的数插入到小顶堆中
        if(count % 2 == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else{
            //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入到大顶堆中
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        //当前是偶数个，则去两个头节点
        if((count % 2) == 0){
            return new Double(minHeap,peek(), maxHeap.peek()) / 2;

        }else{
            return new Double(minHeap.peek());
        }
    }


}