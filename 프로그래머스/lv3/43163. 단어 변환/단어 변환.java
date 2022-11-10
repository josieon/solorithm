import java.util.*;
class Solution {
    public int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        dfs(new boolean[words.length], begin, target, words, 0);
        if(answer == Integer.MAX_VALUE)
            return 0;
        return answer;
    }
    public void dfs(boolean[] visited, String cur, String target, String[] words, int stage){
        if(cur.matches(target)){
            if(stage < answer)
                answer = stage;
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(visited[i])
                continue;
            int diff = 0;
            for(int j = 0; j < cur.length(); j++){
                if(cur.charAt(j) != words[i].charAt(j))
                    diff++;
                if(diff > 1)
                    break;
            }
            if(diff == 1){
                visited[i] = true;
                dfs(visited, words[i], target, words, stage+1);
                visited[i] = false;
            }
        }
    }
}