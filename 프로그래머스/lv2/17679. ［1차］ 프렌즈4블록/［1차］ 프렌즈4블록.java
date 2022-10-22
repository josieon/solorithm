import java.util.*;
class Solution {
    public int answer = 0;
    public char[][] map;
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i = 0; i < m; i++)
            map[i] = board[i].toCharArray();
        while(update(m, n));
        return answer;
    }
    public boolean update(int m, int n){
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];
        for(int i = 0; i < m - 1; i++){
            for(int j = 0; j < n - 1; j++){
                if(map[i][j] == '#')
                    continue;
                char c = map[i][j];
                if(map[i][j+1] == c && map[i+1][j] == c && map[i+1][j+1] == c){
                    isChecked[i][j] = true;
                    isChecked[i][j+1] = true;
                    isChecked[i+1][j+1] = true;
                    isChecked[i+1][j] = true;
                }
            }
        }
        for(int j = 0; j < n; j++){
            Queue<Integer> queue = new LinkedList();
            for(int i = m-1; i >= 0; i--){
                if(isChecked[i][j]){
                    cnt++;
                    continue;
                }
                queue.add(i);
            }
            for(int i = m-1; i >= 0; i--){
                if(!queue.isEmpty())
                    map[i][j] = map[queue.poll()][j];
                else
                    map[i][j] = '#';
            }
        }
        answer += cnt;
        return cnt > 0 ? true : false;
    }
}