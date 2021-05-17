import java.util.ArrayList;
import java.util.List;

public class cycleNode {

    public static ListNode cycleNode(ListNode head) {
        // write your solution here
//2(m + k + s*n) = m+k+ n*f (s and f  are integers), n = loops
//m+k = (f-2s)*n  => m+k is integer * n
//we notices that:  if a pointer starts at the end of fast node, if it walks a distance of m, it should finish exactly one loop, which means meet at loop start
        if(head==null)return null;
        ListNode slow=head, fast=head;
        if(fast.next==null || fast.next.next==null)return null;
        slow = head.next; fast = head.next.next;
        while(slow!=fast){
            if(slow.next==null || fast.next==null || fast.next.next==null)return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        //now slow meets fast
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
//    public static void main(String [] args){
//        ListNode head = new ListNode(1);
//        head.next = new  ListNode(2);
//        head.next.next = new  ListNode(3);
//        cycleNode(head);
//        new Cell("33", 3);
//        List<Cell> dd = new ArrayList<>();
//
//    }
    public static class Cell{
        String str;
        int count;
        public Cell(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
}
