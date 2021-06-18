class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> records = new HashMap<>();
        for(int num : nums1){
            records.put(num, records.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for(int i = 0 ; i < nums2.length; i++){
            if(records.containsKey(nums2[i])){
                if(records.get(nums2[i]) >0 ){
                    res[index++] = nums2[i];
                    records.put(nums2[i], records.get(nums2[i]) - 1);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}