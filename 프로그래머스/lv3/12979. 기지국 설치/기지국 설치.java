import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1, end = 0;
        for(int station : stations){
            end = station - w - 1;
            if(end >= start)
                answer += Math.ceil((float)(end - start + 1)/(2*w + 1));
            start = station + w + 1;
            // System.out.println(answer);
        }
        if(start <= n){
            // System.out.println("start\t" + start);
            answer += Math.ceil((float)(n - start + 1)/(2*w + 1));
        }
        return answer;
    }
}