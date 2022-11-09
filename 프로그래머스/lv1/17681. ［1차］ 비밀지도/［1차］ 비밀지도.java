import java.util.*;
class Solution {
    //다른사람 풀이
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      String temp;
      for(int i = 0 ; i < n ; i++){
          temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
          temp = temp.substring(temp.length() - n);
          temp = temp.replaceAll("1", "#");
          temp = temp.replaceAll("0", " ");
          answer[i] = temp;
      }

      return answer;
  }
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
