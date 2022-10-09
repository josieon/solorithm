import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet();
        int cycle = 1, num = 0;
        char last = '0';
        for(String s : words){
            if(num == n){
                num = 1;
                cycle++;
            }
            else
                num++;
            if(s.charAt(0) != last && last != '0')
                break;
            set.add(s);
            last = s.charAt(s.length() - 1);
            if(set.size() != (cycle - 1) * n + num)
                break;
        }
        if(set.size() == words.length){
            cycle = 0;
            num = 0;
        }
        int[] answer = {num, cycle};
        return answer;
    }
}