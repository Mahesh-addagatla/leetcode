class Solution {
    public int maxArea(int[] height) {
        int capa = 0;
        int i=0,j=height.length-1;
        while(i<j){
            int c = 0;
            if(height[i]>height[j]){
                c = height[j] * (j-i);
                j--;
            }else{
                c = height[i]*(j-i);
                i++;
            }
            capa = Math.max(c,capa);
        }
        return capa;
    }
}
