class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        Map<Character, Integer> used = new HashMap<>();
        
        for(char c : s.toCharArray()){
            if(used.containsKey(c) && left <= used.get(c)){
                left = used.get(c) + 1; 
            }else{
                maxLength = Math.max(maxLength, right - left + 1);
            }
            
            used.put(c, right);
            right++;
        }
        return maxLength;
    }
}