class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char stone : stones.toCharArray()){
            map.put(stone, map.getOrDefault(stone, 0) + 1);
        }
        
        for(char jewel : jewels.toCharArray()){
            if(map.containsKey(jewel))
                answer += map.get(jewel);
        }
        
        return answer;
    }
}