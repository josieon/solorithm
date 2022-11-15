import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[200];
        for(int[] line : lines){
            for(int i = line[0]; i < line[1]; i++)
                arr[i+100]++;
        }
        int answer = 0;
        for(int i = 0; i < arr.length; i++)
            if(arr[i] > 1)
                answer++;
        return answer;
    }
}