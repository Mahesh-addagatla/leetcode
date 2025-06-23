import java.util.ArrayList;

public class Solution 
{
    public static boolean maxPaint(ArrayList<Integer> boards,int k,int time){
        int minTime=0,painters=1;
        for(int i=0;i<boards.size();i++){
            if(minTime+boards.get(i)>time){
                painters++;
                if(painters>k || boards.get(i)>time)return false;
                minTime = boards.get(i);
            }
            else{
                minTime+=boards.get(i);
            }
        }
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int high=0,low=0;
        int n = boards.size();
        for(int i=0;i<n;i++){
            high+=boards.get(i);
            low = Math.max(low,boards.get(i));
        }
        // for(int i=low;i<=high;i++){
        //     if(maxPaint(boards,k,i))return i;
        // }
        while(low<=high){
            int mid = (low+high)/2;
            if(maxPaint(boards,k,mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
