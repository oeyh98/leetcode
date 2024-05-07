class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> tickets = new HashMap<>();
        
        for(int[] flight : flights){
            tickets.putIfAbsent(flight[0], new ArrayList<>());
            tickets.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pq.add(new int[]{src, 0, 0});
        Map<Integer, Integer> visited = new HashMap<>();
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int via = cur[2];
            
            if(node == dst) return cost; 
            if(via > k || (visited.containsKey(node) && visited.get(node) <= via)) continue;
            visited.put(node, via);

            if(tickets.containsKey(node)){
                for(int[] next : tickets.get(node)){
                    pq.offer(new int[]{next[0], next[1] + cost, via + 1});
                }
            }
        }
        return -1;
    }
}
