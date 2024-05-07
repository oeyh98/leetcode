class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = {}
        
        for u, v, w in times:
            if u not in graph:
                graph[u] =[]
            graph[u].append((v, w))
            
        min_heap = [(0, k)]
        visited = [False] * (n+1)
        
        while min_heap:
            cost, node = heapq.heappop(min_heap)
            if visited[node] == True: continue
            visited[node] = True
            
            n -= 1
            if n == 0 :return cost
            
            if node in graph:
                for next_node, next_cost in graph[node]:
                    heapq.heappush(min_heap, (next_cost + cost, next_node))
                    
        return -1
                
            
        