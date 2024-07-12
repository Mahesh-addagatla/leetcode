class Solution {
    static void rev(StringBuilder str,int start,int end){
        while(start<end){
            char ch=str.charAt(start);
            str.setCharAt(start++,str.charAt(end));
            str.setCharAt(end--,ch);
        }
    }
  public String reverseParentheses(String str) {
    Stack<Integer> st=new Stack<>();
    StringBuilder s=new StringBuilder();
    for(char ch: str.toCharArray()){
        if(ch=='('){
            st.push(s.length());
        }
        else if(ch==')'){
            int start=st.pop();
            rev(s,start,s.length()-1);
        }
        else{
            s.append(ch);
        }
        
    }
    return s.toString();
  }
}
