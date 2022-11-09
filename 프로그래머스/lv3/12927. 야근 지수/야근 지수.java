import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for(int tmp : works)
            pq.offer(tmp);
        for(int i = 0; i < n; i++){
            int max = pq.poll();
            if(max <= 0)
                break;
            pq.offer(max-1);
        }
        long answer = 0;
        while(!pq.isEmpty())
            answer += Math.pow(pq.poll(), 2);
        return answer;
    }
}