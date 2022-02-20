public class Add2NumbersLeetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode t = ans;
        int carry = 0;

        while(l1!=null || l2!=null){
            int val1 = (l1==null)? 0: l1.val;
            int val2 = (l2==null)? 0: l2.val;

            int digit = val1 + val2 + carry;

            carry = digit/10;


            ListNode n = new ListNode(digit%10);
            t.next = n;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            t = t.next;
        }

        if(carry>0){
            ListNode n = new ListNode(1);
            t.next = n;
            t = t.next;
        }

        return ans.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.next = next;
        this.val = val;
    }
}