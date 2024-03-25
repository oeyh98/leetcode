class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        
        for i, num in enumerate(nums):
            dic[num] = i
            
        for i, num in enumerate(nums):
            complement = target - num
            
            if complement in dic and i != dic[complement]:
                return i, dic[complement]
