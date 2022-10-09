import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stk = new Stack();
    static StringBuilder sb = new StringBuilder();
    static char[] operator = {'+', '-', '*', '/', '(', ')'};
    public static void main(String[] args) throws Exception{
        String str = br.readLine();
        int len = str.length();
        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            if(is_operator(c)){
                switch(c){
                    case ')':
                        while(true){
                            if(stk.isEmpty())
                                break;
                            char tmp = stk.pop();
                            if(tmp == '(')
                                break;
                            sb.append(tmp);
                        }
                        break;
                    case '+': case '-': case '*': case '/':
                        while(!stk.isEmpty() && priority(stk.peek()) >= priority(c))
                            sb.append(stk.pop());
                        stk.add(c);
                        break;
                    default:
                        stk.add(c);
                        break;
                }
            }
            else
                sb.append(c);
        }
        while(!stk.isEmpty())
            sb.append(stk.pop());
        System.out.println(sb);
    }

    public static int priority(char operator){
        if(operator == '+' || operator == '-')
            return 1;
        else if(operator == '*' || operator == '/')
            return 2;
        return -1;
    }

    public static boolean is_operator(char c){
        for(int i = 0; i < operator.length; i++)
            if(c == operator[i])
                return true;
        return false;
    }
}
