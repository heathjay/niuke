// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}

impl Solution {
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let (mut l1, mut l2, mut carry) = (l1.as_ref(), l2.as_ref(), 0);
        let mut head = Box::new(ListNode::new(0));
        let mut tail = head.as_mut();
        
        'out: loop {
            let val = match (l1, l2) {
                (Some(x), Some(y)) => {
                    l1 = x.next.as_ref();
                    l2 = y.next.as_ref();
                    x.val + y.val + carry
                },
                (Some(x), None) => {
                    l1 = x.next.as_ref();
                    x.val + carry
                },
                (None, Some(y)) => {
                    l2 = y.next.as_ref();
                    y.val + carry
                }
                _ => break 'out,
            };
            
            let val = if val > 9 {carry = 1; val - 10} else {carry = 0; val};
            tail.next = Some(Box::new(ListNode::new(val)));
            tail = tail.next.as_mut().unwrap();
        }

        if carry > 0 {
            tail.next = Some(Box::new(ListNode::new(carry)));
        }
        head.next

    }
}


fn main() {
    println!("Hello, world!");
}
