impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        if s.len()==0{
            return 0;  
        }    
        let mut ans:i32 = 0;
        let mut index:Vec<i32>=vec![-1;128];
        let mut i=0;
        for (j,c) in s.chars().enumerate(){
            i = index[c as usize].max(i);
            ans = ans.max((j as i32) -i+1);
            index[c as usize] = (j+1) as i32;
        }
        ans
    }
}


fn main() {
    println!("Hello, world!");
}
