class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack();
        int n=prices.length-1;
        for(int i=n ;i>=0;i--){
            while(!st.isEmpty() && st.peek()>prices[i]){
                st.pop();
            }
            int discount = st.isEmpty()?0:st.peek();
            st.push(prices[i]);
            prices[i]-=discount;
        }
        return prices;
    }
}
