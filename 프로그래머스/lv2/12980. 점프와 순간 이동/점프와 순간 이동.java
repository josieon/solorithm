import java.util.*;

public class Solution {
    public int solution(int n) {
        int tmp = n;
        int answer = 1;
        while(tmp != 1){
            if(tmp % 2 == 1)
                answer++;
            tmp /= 2;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}