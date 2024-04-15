class Solution {
    public int reverse(int x) {
        if(x>(Math.pow(2,31)-1)&& x<-(Math.pow(2,31)))return 0;
        String str=String.valueOf(x);
        String rev="";
        int result=0;
        for(int i=str.length()-1;i>=0;i--){
            if(i==0 && x<0)continue;
            rev+=str.charAt(i);
        }
        try{
            result=(Integer.parseInt(rev));
        }
        catch(Exception e){
            return 0;
        }
        if(x<0) return -result;
        else return result;
    }
}
