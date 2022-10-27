import java.util.*;
class Solution {
    public static int solution(int distance, int[][] scope, int[][] times) {
        for(int[] tmp : scope)
            Arrays.sort(tmp);
        int[][] arr = new int[scope.length][4];
        for(int i = 0 ; i < scope.length; i++){
            arr[i][0] = scope[i][0];
            arr[i][1] = scope[i][1];
            arr[i][2] = times[i][0];
            arr[i][3] = times[i][1];
        }
        Arrays.sort(arr, new Comparator<int[]> (){
            @Override
            public int compare(int[] e1, int[] e2){
                return e1[0] - e2[0];
            }
        });
        Queue<int[]> q = new LinkedList<>();
        for(int[] tmp : arr)
            q.add(tmp);
        int time = 0;
        while(!q.isEmpty()){
            time++;
            if(time >= q.peek()[0]){
                int[] guard = q.peek();
                int cycle = guard[2] + guard[3];
                if((time-1) % cycle < guard[2])
                    return time;
                if(time == guard[1])
                    q.poll();
            }
        }
        return distance;
    }
}