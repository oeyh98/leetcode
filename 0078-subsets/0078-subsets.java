class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public void dfs(int prev, int depth, int nums[], List<Integer> temp){
        answer.add(new ArrayList<>(temp));
        
        for(int i = prev; i < nums.length; i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                dfs(i, depth+1, nums, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, 0, nums, new ArrayList<>());
        
        return answer;
    }
}