// iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
