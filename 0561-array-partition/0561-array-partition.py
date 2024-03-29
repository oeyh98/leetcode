class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        answer = 0
        nums.sort()
        
        for i in range(0, len(nums), 2):
            answer += min(nums[i], nums[i+1])
            
        return answer