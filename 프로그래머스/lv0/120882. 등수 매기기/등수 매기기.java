import java.util.*;
class Solution {
    //수정 후.
    public int[] solution(int[][] score){
        int[] answer = new int[score.length];
        float[] avg = new float[score.length];
        for(int i = 0; i < score.length; i++)
            avg[i] = (float)(score[i][0] + score[i][1])/2;
        for(int i = 0; i < score.length; i++){
            answer[i] = 1;
            for(int j = 0; j < avg.length; j++){
                if(avg[i] < avg[j])
                    answer[i]++;
            }
        }
        return answer;
    }
    // public int[] solution(int[][] score) {
    //     float[] avg = new float[score.length];
    //     for(int i = 0; i < avg.length; i++)
    //         avg[i] = (float)(score[i][0] + score[i][1]) / 2;
    //     float[] rank = avg.clone();
    //     int[] answer = new int[rank.length];
    //     Arrays.sort(avg);
    //     int r = 1;
    //     for(int i = avg.length-1; i >= 0; i--){
    //         int cnt = 1;
    //         float val = avg[i];
    //         while(i > 0 && avg[i] == avg[i-1]){
    //             cnt++;
    //             i--;
    //         }
    //         int tmp = cnt;
    //         for(int j = 0; cnt > 0; j++){
    //             if(val == rank[j]){
    //                 answer[j] = r;
    //                 cnt--;
    //             }
    //         }
    //         r += tmp;
    //         // i -= tmp;
    //     }
    //     return answer;
    // }
}