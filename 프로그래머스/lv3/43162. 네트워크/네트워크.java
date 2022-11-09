import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(visited[i])
                continue;
            answer++;
            // System.out.println("?" + i);
            Queue<Integer> queue = new LinkedList();
            queue.add(i);
            while(!queue.isEmpty()){
                // System.out.println(queue.toString());
                int cur = queue.poll();
                visited[cur] = true;
                for(int j = 0; j < n; j++){
                    if(!visited[j] && computers[cur][j] == 1)
                        queue.add(j);
                }
            }
        }
        return answer;
    }
}