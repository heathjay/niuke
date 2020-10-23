use std::collections::HashMap;

impl Solution{
    pub fn two_sum(nums:Vec<i32>, target: i32) -> Vec<i32>{
        let mut map : HashMap<i32,i32> = HashMap::new();
        for index in 0..nums.len(){
            let temp = target - nums.get(index).unwrap();
            if map.contains_key(&temp) && index as i32 != *map.get(&temp).unwrap(){
               return vec!(index as i32, *map.get(&temp).unwrap());
            }
            map.insert(*nums.get(index).unwrap(), index as i32);
        }
        return vec!();
    }
}
fn main() {

}
