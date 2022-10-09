import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bomb_length = bomb.length();
        boolean isSame;
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            stk.push(str.charAt(i));
            if(stk.size() >= bomb_length){
                isSame = true;
                for(int idx = 0; idx < bomb_length; idx++){
                    if(stk.get(stk.size() - bomb_length + idx) != bomb.charAt(idx)){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    for(int j = 0; j < bomb_length; j++){
                        stk.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stk.size() == 0)
            System.out.println("FRULA");
        else{
            for(Character c : stk){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
