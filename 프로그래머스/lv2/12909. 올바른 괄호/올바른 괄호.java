import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                stk.add(c);
            else if(c == ')'){
                if(stk.size() != 0 && stk.peek() == '(')
                    stk.pop();
                else
                    stk.add(c);
            }
        }
        if(stk.size() == 0)
            return true;
        else
            return false;
    }
}