class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] answer = new int[k];
        
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);    
        }
        
        List<Integer> keySet = new ArrayList<>(freqMap.keySet());
        
        keySet.sort(new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2){
                return freqMap.get(o2).compareTo(freqMap.get(o1));
            }
        });
        
        for(int i = 0; i < k; i++){
            answer[i] = keySet.get(i);
        }
        
        return answer;
    }
}