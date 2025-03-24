package LinkedList;

public class LinkedList {
    public static void main(String args[]) {
        int len = 0;
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(8);
        ListNode d = new ListNode(11);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;

        ListNode head = a;
        // original Linked list
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
            len += 1;
        }
        head = a;
        System.out.println( );
        // traversing to middle of the array
        ListNode middleNode = getMiddleNode(head);
        // reverse the second half of the linked list.
        ListNode reverseSecondHalf = reverseLinkedList(middleNode);
        ListNode printReverse=reverseSecondHalf;
        // while (printReverse != null) {
        //     System.out.print(printReverse.val + " -> ");
        //     printReverse = printReverse.next;
        // }
        int halfLen=len/2;
        int maxTwinSum=-1;
        while(halfLen>0 && reverseSecondHalf!=null){
            int twinSum=head.val+reverseSecondHalf.val;
            maxTwinSum=Math.max(maxTwinSum,twinSum);
            head = head.next;
            reverseSecondHalf=reverseSecondHalf.next;
            halfLen-=1;
        }
        System.out.println("The maximum twin sum is: "+ maxTwinSum);

    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getMiddleNode'");
    }
}
