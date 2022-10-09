import java.util.*;

class Solution
{
    static Stack<Character> stk = new Stack();
    public int solution(String s)
    {
        for(int i = 0; i < s.length(); i++){
            stk.push(s.charAt(i));
            refresh();
        }
        if(stk.size() == 0)
            return 1;
        else
            return 0;
    }
    public static void refresh(){
        int size = stk.size();
        while(size > 1 && stk.get(size - 1).compareTo(stk.get(size - 2)) == 0){
            stk.pop();
            stk.pop();
            size = stk.size();
        }
    }
}