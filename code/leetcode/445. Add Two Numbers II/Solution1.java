
class Solution {  // O(2M+N) time. O(1) space
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //7 -> 2 -> 4 -> 3 +(5 -> 6 -> 4
        // 8->0->5
        // 5->6->4
        

        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode l1Prev = null;
        
        int carry = 0, num;
        while (l1 != null || l2 != null){
            
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            
            num = l1Val + l2Val + carry;
            carry = num / 10;
            num = num % 10;
            
            if (l1 == null){
                l1Prev.next = new ListNode(num);
                l1 = l1Prev.next;
            } else{
                l1.val = num;
            }
            
            l1Prev = l1;
            l1 = l1 != null ? l1.next : null;;
            l2 = l2 != null ? l2.next : null;;
        }
        if (carry != 0){
            l1Prev.next = new ListNode(carry);
            l1 = l1Prev.next;
            l1Prev = l1;
            l1 = l1.next;
        }
        
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
