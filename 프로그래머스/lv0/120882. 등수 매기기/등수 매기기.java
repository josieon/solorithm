import java.util.*;
class Solution {
    //수정 후.
    // public int[] solution(int[][] score){
    //     int[] answer = new int[score.length];
    //     float[] avg = new float[score.length];
    //     for(int i = 0; i < score.length; i++)
    //         avg[i] = (float)(score[i][0] + score[i][1])/2;
    //     for(int i = 0; i < score.length; i++){
    //         answer[i] = 1;
    //         for(int j = 0; j < avg.length; j++){
    //             if(avg[i] < avg[j])
    //                 answer[i]++;
    //         }
    //     }
    //     return answer;
    // }
        public static int[] solution(int[][] score){
        int[] answer = new int[score.length];
        float[] avg = new float[score.length];
        for(int i = 0; i < score.length; i++)
            avg[i] = (float)(score[i][0] + score[i][1]) / 2;
        PriorityQueue<Float> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(float f : avg)
            pq.add(f);
        // StringBuilder sb = new StringBuilder();
        ArrayList<Float> arr = new ArrayList<>();
        HashMap<Float, Integer> hash = new HashMap<>();
        int target = 1, cnt = 1, idx = 0;
        while(!pq.isEmpty()){
            float k = pq.poll();
            if(arr.isEmpty()){
                arr.add(k);
                hash.put(k, target);
            }
            else{
                if(arr.get(idx) > k){
                    arr.add(k);
                    target += cnt;
                    cnt = 1;
                    idx++;
                    hash.put(k, target);
                }
                else
                    cnt += 1;
            }
        }
        for(int i = 0; i < answer.length; i++)
            answer[i] = hash.get(avg[i]);
        return answer;
    }
}