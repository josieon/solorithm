import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] arr = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String tmp = toBinary(arr1[i], n);
            for(int j = 0; j < n; j++){
                if(tmp.charAt(j) == '1')
                    arr[i][j] = true;
            }
            tmp = toBinary(arr2[i], n);
            for(int j = 0; j < n; j++){
                if(tmp.charAt(j) == '1')
                    arr[i][j] = true;
            }
        }
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n; j ++){
                if(arr[i][j])
                    sb.append('#');
                else
                    sb.append(' ');
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public String toBinary(int i, int n){
        Stack<Integer> stk = new Stack();
        while(i != 0){
            stk.push(i%2);
            i /= 2;
        }
        String res = "";
        for(int j = n-stk.size(); j > 0; j--)
            res += "0";
        while(!stk.isEmpty())
            res += stk.pop();
        return res;
    }
}