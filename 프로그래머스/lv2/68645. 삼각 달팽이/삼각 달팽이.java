import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n+1) / 2];
        int[][] map = new int[n][n];
        int num = 1, dir = 0, x = 0, y = -1;
        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};
        for(int i = n; i > 0; i--){
            for(int j = 0; j < i; j++){
                y += dy[dir];
                x += dx[dir];
                map[y][x] = num++;
            }
            dir = (dir+1) % 3;
        }
        num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != 0)
                    answer[num++] = map[i][j];
            }
        }
        return answer;
    }
}