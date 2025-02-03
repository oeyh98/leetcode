class Solution {
    public boolean isPalindrome(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                deque.add(Character.toLowerCase(c));
            }
        }

        while(deque.size() > 1){
            Character start = deque.pollFirst();
            Character end =  deque.pollLast();
            if(!start.equals(end)){
                return false;
            }
        }

        return true;
    }
}