class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public void dfs(int prev, int[] candidates, int target, List<Integer> nums){
        int total = 0;
        
        for(int i = 0; i < nums.size(); i++){
            total += nums.get(i);
        }
        
        if(total == target){
            answer.add(new ArrayList<>(nums));
            return;
        }
        
        else if(total > target){
            return;
        }
        
        else{
            for(int i = prev ; i < candidates.length; i++){
                nums.add(candidates[i]); 
                dfs(i, candidates, target, nums);
                nums.remove(nums.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, target, new ArrayList<>());
        
        return answer;
    }
}