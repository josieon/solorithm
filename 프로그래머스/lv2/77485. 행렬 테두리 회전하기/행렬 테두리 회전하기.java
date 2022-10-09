import java.util.*;
class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows+1][columns+1];
        int num = 1;
        for(int r = 1; r<= rows; r++)
            for(int c = 1; c<= columns; c++)
                map[r][c] = num++;
        int[] ans = new int[queries.length];
        int idx = 0;
        for(int[] q : queries)
            ans[idx++] = rotateMap(q[1], q[0], q[3], q[2]);
        return ans;
    }
    public static int rotateMap(int x1, int y1, int x2, int y2){
        Queue<Integer> queue = new LinkedList<>();
        int min = 10000;
        int dx = 0;
        while(x1 + dx <= x2){
            if(min > map[y1][x1 + dx])
                min = map[y1][x1 + dx];
            queue.offer(map[y1][x1 + dx++]);
        }
        int dy = 1;
        while(y1 + dy <= y2){
            if(min > map[y1 + dy][x2])
                min = map[y1 + dy][x2];
            queue.offer(map[y1 + dy++][x2]);
        }
        dx = -1;
        while(x2 + dx >= x1){
            if(min > map[y2][x2 + dx])
                min = map[y2][x2 + dx];
            queue.offer(map[y2][x2 + dx--]);
        }
        dy = -1;
        while(y2 + dy > y1){
            if(min > map[y2 + dy][x1])
                min = map[y2 + dy][x1];
            queue.offer(map[y2 + dy--][x1]);
        }
        
        dx = 1;
        while(x1 + dx <= x2)
            map[y1][x1 + dx++] = queue.poll();
        dy = 1;
        while(y1 + dy <= y2)
            map[y1 + dy++][x2] = queue.poll();
        dx = -1;
        while(x2 + dx >= x1)
            map[y2][x2 + dx--] = queue.poll();
        dy = -1;
        while(y2 + dy >= y1)
            map[y2 + dy--][x1] = queue.poll();

        return min;
    }
}