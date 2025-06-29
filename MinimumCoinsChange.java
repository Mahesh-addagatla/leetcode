import java.util.*;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
        int c =0;
        List<Integer> ans = new ArrayList<>();
        while(n!=0){
            if(n>=1 && n<2){
                ans.add(1);
                n-=1;
            }
            else if(n>=2 && n<5){
                ans.add(2);
                n-=2;
            }
            else if(n>=5 && n<10){
               ans.add(5);
                n-=5;
            }
            else if(n>=10 && n<20){
                ans.add(10);
                n-=10;
            }
            else if(n>=20 && n<50){
                ans.add(20);
                n-=20;
            }
            else if(n>=50 && n<100){
                ans.add(50);
                n-=50;
            }
            else if(n>=100 && n<500){
                ans.add(100);
                n-=100;
            }
            else if(n>=500 && n<1000){
                ans.add(500);
                n-=500;
            }
            else{
                ans.add(1000);
                n-=1000;
            }
        }
        return ans;
    }
}
