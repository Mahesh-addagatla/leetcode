class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode cur=head;
        Stack<ListNode> st=new Stack<>();
        while(cur!=null){
            while(!st.isEmpty() && st.peek().val<cur.val){
                st.pop();
            }
            st.push(cur);
            cur=cur.next;
        }
        ListNode nex=null;

        while(!st.isEmpty()){
            cur=st.pop();
            cur.next=nex;
            nex=cur;
        }
        return cur;
    }
}
