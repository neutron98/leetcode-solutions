
// quicksort
public class Solution {
    
    private static class PartitionResult {
        public ListNode leftHead, rightHead; 
        public PartitionResult(ListNode leftHead, ListNode rightHead) {
            this.leftHead = leftHead;
            this.rightHead = rightHead;
        }
    }
    
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMedian(head); // O(n)
        PartitionResult pair = partition(head, mid.val); // O(n)
        
        ListNode left = sortList(pair.leftHead);
        ListNode right = sortList(pair.rightHead);
        
        getTail(left).next = right; // O(n)
        
        return left;
    }
    
    // 1->2->3 return 2
    // 1->2 return 1
    private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // < value in the left, > value in the right
    private PartitionResult partition(ListNode head, int value) {
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode equalDummy = new ListNode(0), equalTail = equalDummy;
        while (head != null) {
            if (head.val < value) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > value) {
                rightTail.next = head;
                rightTail = head;
            } else {
                equalTail.next = head;
                equalTail = head;
            }
            head = head.next;
        }
        
        leftTail.next = null;
        rightTail.next = null;
        equalTail.next = null;
        
        if (leftDummy.next == null && rightDummy.next == null) {
            ListNode mid = findMedian(equalDummy.next);
            leftDummy.next = equalDummy.next;
            rightDummy.next = mid.next;
            mid.next = null;
        } else if (leftDummy.next == null) {
            leftTail.next = equalDummy.next;
        } else {
            rightTail.next = equalDummy.next;
        }
        
        return new PartitionResult(leftDummy.next, rightDummy.next);
    }
    
    private ListNode getTail(ListNode head) {
        if (head == null) {
           return null;
        } 
       
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}
