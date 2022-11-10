import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles){
        boolean[][] check = new boolean[n][m];
        for(int[] tmp : puddles)
            check[tmp[1]-1][tmp[0]-1] = true;
        int[][] map = new int[n][m];
        map[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j != 0 && !check[i][j])
                    map[i][j] += map[i][j-1] % 1_000_000_007;
                if(i != 0 && !check[i][j])
                    map[i][j] += map[i-1][j] % 1_000_000_007;
            }
        }
        return map[n-1][m-1] % 1_000_000_007;
    }
    // BFS 풀이 - 시간 초과
    // public int solution(int m, int n, int[][] puddles) {
    //     int answer = 0;
    //     boolean[][] check = new boolean[n][m];
    //     for(int[] tmp : puddles){
    //         check[tmp[1] - 1][tmp[0] - 1] = true;
    //     }
    //     Queue<int[]> queue = new LinkedList();
    //     queue.offer(new int[]{0, 0});
    //     while(!queue.isEmpty()){
    //         int[] cur = queue.poll();
    //         if(cur[0] == m-1 && cur[1] == n-1){
    //             answer++;
    //             continue;
    //         }
    //         if(cur[0]+1 < m){
    //             if(!check[cur[1]][cur[0]+1])
    //                 queue.offer(new int[]{cur[0]+1, cur[1]});
    //         }
    //         if(cur[1]+1 < n){
    //             if(!check[cur[1]+1][cur[0]])
    //                 queue.offer(new int[]{cur[0], cur[1]+1});
    //         }
    //     }
    //     return answer % 1_000_000_007;
    // }
}