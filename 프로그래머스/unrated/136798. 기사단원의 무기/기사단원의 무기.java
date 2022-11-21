import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for(int i = 2; i <= number; i++){
            int tmp = 2;
            for(int j = 2; j <= i/2; j++)
                if(i % j == 0)
                    tmp++;
            if(tmp > limit)
                answer += power;
            else
                answer += tmp;
        }
        return answer;
    }
}