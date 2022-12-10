import java.util.*;
class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> hash = new HashMap();
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            answer[i] = hash.getOrDefault(c, -1);
            if(answer[i] != -1)
                answer[i] = Math.abs(answer[i] - i);
            hash.put(c, i);
        }
        return answer;
    }
}