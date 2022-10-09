import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        long minX=Long.MAX_VALUE, minY=Long.MAX_VALUE, maxX=Long.MIN_VALUE, maxY=Long.MIN_VALUE;
        HashSet<long[]> set = new HashSet();
        for(int i = 0; i < line.length-1; i++){
            for(int j = i+1; j < line.length; j++){
                long a = line[i][0];
                long d = line[j][1];
                long b = line[i][1];
                long c = line[j][0];
                long adbc = a*d - b*c;
                if(adbc == 0)
                    continue;
                long e = line[i][2];
                long f = line[j][2];
                long bfed = b*f - e*d;
                if(bfed % adbc != 0)
                    continue;
                long ecaf = e*c - a*f;
                if(ecaf % adbc != 0)
                    continue;
                long x = bfed / adbc;
                long y = ecaf / adbc;
                if(x > maxX)
                    maxX = x;
                if(x < minX)
                    minX = x;
                if(y > maxY)
                    maxY = y;
                if(y < minY)
                    minY = y;
                set.add(new long[] {x, y});
            }
        }
        boolean[][] board = new boolean[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
        for(long[] tmp : set)
            board[(int)(maxY - tmp[1])][(int)(tmp[0]-minX)] = true;
        String[] answer = new String[board.length];
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j])
                    sb.append("*");
                else
                    sb.append(".");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}