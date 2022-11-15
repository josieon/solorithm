import java.util.*;
class Solution {
    public static HashSet<Float> set;
    public int solution(int[][] dots) {
        //기울기는 dx/dy
        set = new HashSet();
        combination(new int[2], dots, 2, 0, 0);
        if(set.size() != 6)
            return 1;
        else
            return 0;
    }
    public void combination(int[] comb, int[][] arr, int r, int idx, int target){
        if(r == 0){
            int[] co1 = arr[comb[0]];
            int[] co2 = arr[comb[1]];
            set.add((float)(co1[0] - co2[0])/(co1[1] - co2[1]));
            return;
        }
        else if(target == arr.length)
            return;
        else{
            comb[idx] = target;
            combination(comb, arr, r-1, idx+1, target+1);
            combination(comb, arr, r, idx, target+1);
        }
    }
}