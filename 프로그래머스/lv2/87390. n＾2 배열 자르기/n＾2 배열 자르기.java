import java.util.*;
class Solution {
    public static int[] solution(int n, long left, long right){
        int[] answer = new int[(int)(right - left) + 1];
        int idx = 0;
        for(long i = left; i < right+1; i++){
            answer[idx++] = Math.max((int)(i/n), (int)(i%n)) + 1;
        }
        /*
        int idx = 0;
        for(long i = left/n; i <= right/n; i++){
            int num = (int)i + 1;
            long j = 0, limit = n;
            if(i == left/n){
                j = left % n;
                num += (j - i);
            }
            if(i == right/n)
                limit = right % n + 1;
            for(; j < limit; j++){
                answer[idx++] = num;
                if(j >= i)
                    num++;
            }
        }
        */
        return answer;
    }
}