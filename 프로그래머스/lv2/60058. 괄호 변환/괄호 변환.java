import java.util.*;
class Solution {
    public String solution(String p) {
        if(p.length() == 0)
            return "";
        int o = 0, c = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '('){
                o++;
            }
            else{
                c++;
            }
            if(o == c)
                break;
        }
        String u = p.substring(0, o+c), v = p.substring(o+c);
        // System.out.print("u "+u+" v " + v);
        Stack<Character> stk = new Stack();
        for(int i = 0; i < u.length(); i++){
            char target = u.charAt(i);
            if(stk.size() > 0 && target == ')' && stk.peek() == '(')
                stk.pop();
            else
                stk.push(target);
        }
        // System.out.println(stk.toString());
        if(stk.isEmpty()){
            // System.out.println("Empty "+u);
            return u + solution(v);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < u.length()-1; i++){
            if(u.charAt(i) == '(')
                sb.append(")");
            else
                sb.append("(");
        }
        return "(" + solution(v) + ")" + sb.toString();
    }
}