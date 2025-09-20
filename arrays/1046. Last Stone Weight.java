class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==0)return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.offer(i);
        }
        int size = pq.size();
        while(size>1 && !pq.isEmpty()){
            int p = pq.poll();
            int q = 0;
            if(!pq.isEmpty())q = pq.poll();
            pq.add(p-q);
            size=pq.size();
        }
        return pq.peek();
    }
}
