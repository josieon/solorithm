import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for(int tmp : d){
            if(tmp > budget)
                break;
            budget -= tmp;
            answer++;
        }
        return answer;
    }
}