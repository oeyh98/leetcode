class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        result = [0] * len(t)
        stack = []
        
        for i, cur in enumerate(t):
            
            while stack and stack[-1][1] < cur:
                result[stack[-1][0]] = i-stack[-1][0]
                stack.pop()
                
            stack.append([i, cur])
        return result