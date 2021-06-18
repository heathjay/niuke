// class NumArray {
//     List<Integer> arr;
//     public NumArray(int[] nums) {
//         arr = new ArrayList<>();
//         for(int i = 0; i < nums.length; i++){
//             arr.add(nums[i]);
//         }
//     }
    
//     public int sumRange(int left, int right) {
//         int sum = 0;
//         for(int i = left; i <= right ; i++){
//             sum += arr.get(i);
//         }
//         return sum;
//     }
// }

// /**
//  * Your NumArray object will be instantiated and called as such:
//  * NumArray obj = new NumArray(nums);
//  * int param_1 = obj.sumRange(left,right);
//  */

class NumArray {
    List<Integer> arr;
    public NumArray(int[] nums) {
        arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            arr.add(nums[i]);
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right ; i++){
            sum += arr.get(i);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */