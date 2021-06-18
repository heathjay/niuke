class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> records = HashMap<Integer, Integer>();
        for(int num : nums){
            records.put(num, records.getOrDefault(num, 0) + 1);
        }
        //int[0] num
        //int[1] times
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });

        for(Map.Entry<Integer, Integer> entry: records.entrySet()){
            int num = entry.getKey();
            int times = entry.getValue();
            if(queue.size()==k){
                if(queue.peek()[1] < times){
                    queue.poll();
                    queue.offer(new int[]{num, times});
                }
            }else{
                queue.offer(new int[]{num,times});
            }
        }
        int[] ret = new int[k];
        for(int i = 0 ; i < k ; i++){
            ret[i]  = queue.poll()[0];
        }
        return ret;

    }
}