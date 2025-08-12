/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // if(head==null || head.next==null)return head;
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            if(cur.next!=null && cur.val == cur.next.val){
                int val = cur.val;
                while(cur!=null && cur.val==val){
                    cur=cur.next;
                    if(prev!=null){
                        prev.next = cur;
                    }
                    else{
                        head=cur;
                    }
                }
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
