import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        boolean[][] danger = new boolean[board.length][board.length];
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 1)
                    queue.add(new int[] {i, j});
            }
        }
        while(!queue.isEmpty()){
            int[] coor = queue.poll();
            danger[coor[0]][coor[1]] = true;
            for(int i = 0 ; i < 8; i++){
                int y = coor[0] + dy[i];
                int x = coor[1] + dx[i];
                if(y >= board.length || y < 0 || x >= board.length || x < 0)
                    continue;
                danger[y][x] = true;
            }
        }
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(!danger[i][j])
                    answer++;
            }
        }
        return answer;
    }
}