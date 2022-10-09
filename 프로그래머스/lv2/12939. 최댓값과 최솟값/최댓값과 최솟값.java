import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.parseInt(st.nextToken());
        int min = max;
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            if(max < tmp)
                max = tmp;
            if(min > tmp)
                min = tmp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}