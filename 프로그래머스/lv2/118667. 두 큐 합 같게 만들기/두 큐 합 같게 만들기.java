import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        long sum1 = 0, sum2 = 0;
        for(int s : queue1){
            sum1 += (long)s;
            q1.offer(s);
        }
        for(int s : queue2){
            sum2 += (long)s;
            q2.offer(s);
        }
        int cnt = 0;
        while(sum1 != sum2){
            cnt++;
            if(sum1 > sum2){
                int tmp = q1.poll();
                sum1 -= tmp;
                sum2 += tmp;
                q2.offer(tmp);
            }
            else{
                int tmp = q2.poll();
                sum1 += tmp;
                sum2 -= tmp;
                q1.offer(tmp);
            }
            if(cnt > (queue1.length + queue2.length) * 2)
                return -1;
        }
        return cnt;
    }
}