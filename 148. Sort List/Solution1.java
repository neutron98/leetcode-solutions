// merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null){
            return head;
        }
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        
        ListNode midNode = findMiddle(head); 
    
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(midNode);
        
        return merge(leftHead, rightHead);
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        
        ListNode prevNode = dummy;
        
        ListNode l1 = head1, l2 = head2;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                prevNode.next = l1;
                l1 = l1.next;
            } else{
                prevNode.next = l2;
                l2 = l2.next;
            }
            prevNode = prevNode.next;
        }
        
        if (l1 != null){
            prevNode.next = l1;
        }
        if (l2 != null){
            prevNode.next = l2;
        }
        
        return dummy.next;
    }
    
    // 1 -> 2 -> 3 -> 4 -> 5
    //           s
    //                     f
    
    // 1 -> 2 -> 3 -> 4
    //           s
    //                    f
    private ListNode findMiddle(ListNode head){
        
       
        ListNode slowPrev = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // unlink left and right parts
        if (slowPrev != null){
            slowPrev.next = null;
        }
        
        return slow;
    }
}
