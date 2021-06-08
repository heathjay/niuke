class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();


        for(int i = 0; i < k ; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }


        int[] res = new int[n-k+1];
        res[0] = nums[deque.peekFirst()];

        for(int i = k; i < n ;i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            while(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            res[i-k+1] = nums[deque.peekFirst()];
        }
        return res;
    }
}