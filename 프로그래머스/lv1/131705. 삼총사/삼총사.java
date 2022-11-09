import java.util.*;
class Solution {
    public static HashSet<int[]> set;
    public int solution(int[] number) {
        set = new HashSet();
        doCombination(new int[3], number, 3, 0, 0);
        return set.size();
    }
    public void doCombination(int[] comb, int[] arr, int r, int idx, int target){
        if(r == 0){
            int sum = 0;
            for(int tmp : comb)
                sum += tmp;
            if(sum == 0)
                set.add(comb.clone());
            // System.out.println(set.size());
            return;
        }
        else if(target == arr.length)
            return;
        else{
            comb[idx] = arr[target];
            doCombination(comb, arr, r-1, idx+1, target+1);
            doCombination(comb, arr, r, idx, target+1);
        }
    }
}