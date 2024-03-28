class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        min_value = 1e9
        for price in prices:
            min_value = min(min_value, price)
            result = max(result, price - min_value)

        return result