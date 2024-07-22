class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=heights.length;
        HashMap<Integer,String> hs=new HashMap<>();
        for(int i=0;i<heights.length;i++){
            hs.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] na=new String[n];
        int j=0;
        for(int i=n-1;i>=0;i--){
            na[j]=hs.get(heights[i]);
            j++;
        }
        return na;
    }
}
