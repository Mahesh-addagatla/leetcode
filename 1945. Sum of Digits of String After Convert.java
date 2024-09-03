class Solution {
    public int getLucky(String s, int k) {
        StringBuilder num=new StringBuilder();
        for(char x : s.toCharArray()){
            num.append(x-'a'+1);
        }
        while(k>0){
            int temp=0;
            for(char x : num.toString().toCharArray()){
                temp+=x-'0';
            }
            num=new StringBuilder(String.valueOf(temp));
            k--;
        }
        return Integer.parseInt(num.toString());
    }
}
