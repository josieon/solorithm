import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[] answer = {0};
        for(int i = 0; i < triangle.length; i++){
            int[] tmp = triangle[i].clone();
            tmp[0] += answer[0];
            for(int j = 1; j < i; j++)
                tmp[j] += Math.max(answer[j-1], answer[j]);
            if(i != 0)
                tmp[i] += answer[i-1];
            answer = tmp;
        }
        Arrays.sort(answer);
        return answer[answer.length-1];
    }
}