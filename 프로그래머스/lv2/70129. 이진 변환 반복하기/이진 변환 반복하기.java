import java.util.*;
class Solution {
    static int[] answer;
    public int[] solution(String s) {
        answer = new int[2];
        while(s.length() != 1){
            s = toBinary(remove(s));
            answer[0]++;
        }
        return answer;
    }
    public static String toBinary(int l){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack();
        int tmp = l;
        while(tmp != 0){
            stk.add(Integer.toString(tmp % 2).charAt(0));
            tmp /= 2;
        }
        while(!stk.isEmpty())
            sb.append(stk.pop());
        return sb.toString();
    }
    public static int remove(String s){
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '1')
                res++;
            else
                answer[1]++;
        }
        return res;
    }
}