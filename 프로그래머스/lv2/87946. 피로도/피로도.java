import java.util.*;
class Solution {
    public static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(visited, dungeons, k, 0);
        return answer;
    }
    public void dfs(boolean[] visited, int[][] dungeons, int hp, int level){
        for(int i = 0; i < visited.length; i++){
            if(visited[i])
                continue;
            if(hp >= dungeons[i][0]){
                if(answer <= level)
                    answer++;
                visited[i] = true;
                dfs(visited, dungeons, hp-dungeons[i][1], level+1);
                visited[i] = false;
            }
        }
    }
}