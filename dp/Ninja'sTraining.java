import java.util.*;
public class Solution {
    public static int tasks(int day,int last,int[][] points,int[][] dp){
        if(day == 0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi = Math.max(maxi,points[day][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last]!= -1) return dp[day][last];
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int point = points[day][i]+tasks(day-1,i,points,dp);
                maxi = Math.max(point,maxi);
            }
        }
        return dp[day][last]=maxi;

    }
    public static int ninjaTraining(int n, int points[][]) {
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1] = Math.max(points[0][0],points[0][2]);
        prev[2] = Math.max(points[0][0],points[0][1]);
        prev[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for(int day=1;day<n;day++){
            int[] cur = new int[4];
            for(int last=0;last<4;last++){
                cur[last] = 0;
                for(int i=0;i<3;i++){
                    if(i!=last){
                        int point = points[day][i]+prev[i];
                        cur[last] = Math.max(point,cur[last]);
                    }
                }
            }
            prev = cur;
        }
        return prev[3];
    }
}
