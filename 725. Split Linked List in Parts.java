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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans =new ListNode[k];
        int c=0;
        ListNode temp=head;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        int split=c/k;
        int rem=c%k;
        temp=head;
        ListNode pre=temp;
        for(int i=0;i<k;i++){
            ListNode newPart = temp;
            int cs=split;
            if(rem>0){
                rem--;
                cs++;
            }
            int j=0;
            while(j<cs){
                pre=temp;
                temp=temp.next;
                j++;
            }
            if(pre!=null){
                pre.next=null;
            }
            ans[i]=newPart;
        }
        return ans;
    }
}
