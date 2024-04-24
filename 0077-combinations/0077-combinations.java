class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public void dfs(int depth, int prev, int n, int k, List<Integer> list){
        if(depth == k){
            answer.add(new ArrayList(list));
            return;
        }
        
        for(int i = depth + 1; i <= n; i++){
            if(!list.contains(i) && i > prev){
                list.add(i);
                dfs(depth + 1, i, n, k, list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        dfs(0, 0, n, k, new ArrayList());
        
        return answer;
    }
}