class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public void dfs(List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for(int num : nums){
            if(!list.contains(num)){
                list.add(num);
                dfs(list, nums);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        dfs(new ArrayList(), nums);
        
        return answer;
    }
}