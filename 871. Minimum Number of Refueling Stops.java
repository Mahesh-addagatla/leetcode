class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target)return 0;
        PriorityQueue<Integer> gas = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = startFuel,i = 0;
        int stop=0;
        while(fuel<target){
            while(i<stations.length && fuel>=stations[i][0]){
                gas.add(stations[i][1]);
                i++;
            }
            if(gas.isEmpty())return -1;
            fuel+=gas.poll();
            stop++;
        }
        return stop;
    }
}
