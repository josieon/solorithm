import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] arr = new int[10];
        int[] common = new int[10];
        toArray(X, arr);
        for(char c : Y.toCharArray()){
            if(arr[c - '0'] > 0){
                common[c - '0']++;
                arr[c - '0']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i > 0; i--){
            for(int j = 0; j < common[i]; j++)
                sb.append(i);
        }
        if(sb.toString().matches("")){
            if(common[0] == 0)
                return "-1";
            else
                return "0";
        }
        for(int j = 0; j < common[0]; j++)
            sb.append("0");
        return sb.toString();
    }
    public void toArray(String target, int[] arr){
        for(char c : target.toCharArray())
            arr[c - '0']++;
    }
}