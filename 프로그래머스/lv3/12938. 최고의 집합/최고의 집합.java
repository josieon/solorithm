import java.util.*;
class Solution {
    // public static int product = 0;
    // public static int[] answer;
    // public int[] solution(int n, int s) {
    //     doCombination(new int[n], n, 1, 0, 0, 1, s);
    //     if(answer == null)
    //         return new int[] {-1};
    //     else
    //         return answer;
    // }
    // public void doCombination(int[] comb, int r, int stage, int idx, int sum, int p, int s){
    //     if(r == 0){
    //         if(p > product)
    //             answer = comb;
    //         System.out.println(Arrays.toString(comb));
    //         return;
    //     }
    //     else if(r == 1){
    //         comb[idx] = (s - sum);
    //         doCombination(comb, r-1, stage, idx+1, sum+(s - sum), p*(s - sum), s);
    //     }
    //     else{
    //         comb[idx] = stage;
    //         doCombination(comb, r-1, stage, idx+1, sum+stage, p*stage, s);
    //         doCombination(comb, r, stage+1, idx, sum, p, s);
    //     }
    // }
    public int[] solution(int n, int s){
        if(s / n < 1)
            return new int[] {-1};
        int[] answer = new int[n];
        int tmp = s % n;
        for(int i = n-1; i >= 0; i--){
            answer[i] = s/n;
            if(tmp-- > 0)
                answer[i]++;
        }
        return answer;
    }
}