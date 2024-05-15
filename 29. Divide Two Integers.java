class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor)return 1;
        boolean sign=true;
        if((dividend<0 && divisor>0)||(dividend>0 && divisor<0))sign=false;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        //divisor=Math.abs(divisor);
        long quotient=0;
        for(int i=30;i>=0;i--){
            if( n>=(d<<i)){
                quotient+=(1<<i);
                n-=(d<<i);
            }
        }
        if(dividend==(Integer.MIN_VALUE) && divisor==1)return Integer.MIN_VALUE;

        return (int)(sign?quotient:-quotient);

    }
}
