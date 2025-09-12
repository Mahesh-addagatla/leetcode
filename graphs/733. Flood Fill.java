class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oriColor = image[sr][sc];
        if(oriColor == color)return image;
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        image[sr][sc] = color;
        q.add(new int[]{sr,sc});
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0],c=cur[1];
            // tm=Math.max(tm,t);
            for(int i=0;i<4;i++){
                int dx = r+dr[i];
                int dy = c+dc[i];
                if(dx>=0 && dx<m && dy>=0 && dy<n && image[dx][dy]==oriColor){
                    image[dx][dy] = color;
                    q.offer(new int[]{dx,dy});
                }
            }
            
        }
        return image;
    }
}
