import java.util.*;
class Solution {
    public int solution(String dartResult) {
        String str = "";
        int[] answer = new int[3];
        int idx = 0;
        for(char c : dartResult.toCharArray()){
            switch(c){
                case 'S':
                    answer[idx++] = Integer.parseInt(str);
                    str = "";
                    break;
                case 'D':
                    answer[idx++] = (int)Math.pow(Integer.parseInt(str), 2);
                    str = "";
                    break;
                case 'T':
                    answer[idx++] = (int)Math.pow(Integer.parseInt(str), 3);
                    str = "";
                    break;
                case '*':
                    answer[idx-1] *= 2;
                    if(idx - 2 >= 0)
                        answer[idx-2] *= 2;
                    break;
                case '#':
                    answer[idx-1] *= -1;
                    break;
                default:
                    str += String.valueOf(c);
                    break;
            }
        }
        int ans = 0;
        for(int i : answer)
            ans += i;
        return ans;
    }
}