import java.util.*;
class Solution {
    public int solution(int n, int k) {
        StringTokenizer st = new StringTokenizer(convert(n, k), "0");
        int cnt = 0;
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            if(isPrime(s))
                cnt++;
        }
        return cnt;
    }
    public static String convert(int num, int regex){
        Stack<Integer> stk = new Stack();
        int n = num;
        while(n != 0){
            stk.push(n % regex);
            n /= regex;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
            sb.append(Integer.toString(stk.pop()));
        return sb.toString();
    }
    public static boolean isPrime(String num){
        if(num.compareTo("1") == 0)
            return false;
        long n = 0;
        for(int i = 0; i < num.length(); i++){
            n *= 10;
            n += num.charAt(i) - '0';
        }
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0 )
                return false;
        return true;
    }
}