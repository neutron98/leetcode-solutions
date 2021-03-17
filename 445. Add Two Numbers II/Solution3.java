class Solution {
  // https://www.cnblogs.com/grandyang/p/6216480.html
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = getLength(l1), n2 = getLength(l2);
        if (n1 < n2){
            // swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;    // pointer in new linked list
        ListNode right = curr;  // the rightmost node that is not 9. we can safely add carry value
        
        int diff = Math.abs(n1 - n2);
        
        while(diff > 0){  // copy l1 vals
            curr.next = new ListNode(l1.val);
            if (l1.val != 9){
                right = curr.next;
            }
            
            curr = curr.next;
            l1 = l1.next;
            diff--;
        }
        /**
        7 -> 2 -> 4 -> 3
                 l1
                      
             5   6     4
                 l2
        7    8   0     
               curr
       
               right
       
        */
        
        /*
        7 -> 2 -> 4 -> 3
        
        
        3    2    0    0


        */
        while (l1 != null){
            int val = l1.val + l2.val;
            if (val >= 10){
                val = val % 10;
                right.val++;
                // right后面节点全部赋值为0
                while (right.next != null){
                    right.next.val = 0;
                    right = right.next;
                }
                right = curr;
            }
            
            curr.next = new ListNode(val);
            if (val != 9){
                right = curr.next;
            }
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        return dummy.val == 1 ? dummy : dummy.next;

    }
    
    private int getLength(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
