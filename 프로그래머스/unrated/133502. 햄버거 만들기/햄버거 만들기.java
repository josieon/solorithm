import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stk = new Stack();
        int answer = 0;
        for(int i : ingredient){
            stk.add(i);
            if(i == 1){
                int size = stk.size();
                while(size >= 4){
                    if(stk.get(size-1) == 1 && stk.get(size-4) == 1 && stk.get(size-2) == 3 && stk.get(size - 3) == 2){
                        answer++;
                        stk.pop();
                        stk.pop();
                        stk.pop();
                        stk.pop();
                        size = stk.size();
                    }
                    else
                        break;
                }
            }
        }
        return answer;
    }
}