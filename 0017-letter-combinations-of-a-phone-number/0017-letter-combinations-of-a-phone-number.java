import java.util.*;

class Solution {
    static int[] digit;
    static String[] numpad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> answer;
        
    static void dfs(int depth, StringBuilder sb, char[] digits){
        if(depth == digits.length){
            answer.add(sb.toString());
            return;
        }
        
        int num = Character.getNumericValue(digits[depth]);
        char[] choice = numpad[num].toCharArray();
        
        for(int i = 0 ; i < choice.length; i++){
            sb.append(choice[i]);
            dfs(depth + 1, sb, digits);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        
        
        if(digits.length() > 0) dfs(0, new StringBuilder(), digits.toCharArray());
        
        return answer;
    }
}