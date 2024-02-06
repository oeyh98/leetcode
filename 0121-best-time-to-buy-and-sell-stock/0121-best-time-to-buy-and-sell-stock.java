class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minValue = 10001;
        
        for(int price:prices){
            if (price < minValue){
                minValue = price;
            }    
            else if (profit < price - minValue){
                profit = price - minValue;
            }
        }
        return profit;
    }
}