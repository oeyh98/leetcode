class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for(int[] time: times){
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{k, 0});
        
        boolean[] visited = new boolean[n+1];
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if(visited[node] == true) continue;
            visited[node] = true;
            
            if(--n == 0){
                return cost;
            }
            if(map.containsKey(node)){
                for(int[] next : map.get(node)){
                    pq.offer(new int[]{next[0], next[1] + cost});
                }
            }
        }
        return -1;
    }
}