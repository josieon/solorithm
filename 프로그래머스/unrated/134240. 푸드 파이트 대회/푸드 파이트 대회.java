import java.util.*;
class Solution {
    public String solution(int[] food) {
        Stack<Integer> stk = new Stack();
        String answer = "";
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                answer += Integer.toString(i);
                stk.add(i);
            }
        }
        answer += "0";
        while(!stk.isEmpty())
            answer += Integer.toString(stk.pop());
        return answer;
    }
}