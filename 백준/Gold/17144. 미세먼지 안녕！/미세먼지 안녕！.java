import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        // int R = 7, C = 8, T = 1;
        int[][] map = new int[R][C];
        for(int i = 0 ; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // int [][] map = {
        //     {0,0,0,0,0,0,0,9}, {0,0,0,0,3,0,0,8}, {-1,0,5,0,0,0,22,0},
        //     {-1,8,0,0,0,0,0,0}, {0,0,0,0,0,10,43,0}, {0,0,5,0,15,0,0,0},
        //     {0,0,40,0,0,0,20,0}
        // };
        int conditionA = -1, conditionB = -1;
        for(int i = 0 ; i < R; i++){
            if(map[i][0] == -1){
                if(conditionA == -1)
                    conditionA = i;
                else
                    conditionB = i;
            }
        }
        // System.out.println(conditionA);
        // System.out.println(conditionB);
        //출력
        // for(int i = 0 ; i < R; i++){
        //     StringBuilder sb = new StringBuilder();
        //     for(int j = 0 ; j < C; j++){
        //         sb.append(map[i][j]).append("\t");
        //     }
        //     System.out.println(sb);
        // }
        for(int t = 0 ; t < T; t++){
            Queue<int[]> q = new LinkedList<>();
            for(int i = 0 ; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] > 0)
                        q.add(new int[]{i, j, map[i][j]});
                }
            }
            // System.out.println(q.size());
            // for(int[] tmp : q)
            //     System.out.println(Arrays.toString(tmp));
            while(!q.isEmpty()){
                int[] coor = q.poll();
                int cnt = 0;
                for(int i = 0 ; i < 4; i++){
                    int y = coor[0] + dy[i];
                    int x = coor[1] + dx[i];
                    if(x < 0 || x >= C || y < 0 || y >= R || map[y][x] == -1)
                        continue;
                    map[y][x] += Math.floor((float)coor[2]/5);
                    cnt++;
                }
                map[coor[0]][coor[1]] -= Math.floor((float)coor[2]/5) * cnt;
            }
            //출력
            // for(int i = 0 ; i < R; i++){
            //     StringBuilder sb = new StringBuilder();
            //     for(int j = 0 ; j < C; j++){
            //         sb.append(map[i][j]).append("\t");
            //     }
            //     System.out.println(sb);
            // }
            // System.out.println();
            //반시계방향
            for(int i = conditionA-1; i > 0; i--)
                map[i][0] = map[i-1][0];
            for(int i = 0; i < C-1; i++)
                map[0][i] = map[0][i+1];
            for(int i = 0; i < conditionA; i++)
                map[i][C-1] = map[i+1][C-1];
            for(int i = C-1; i > 1; i--)
                map[conditionA][i] = map[conditionA][i-1];
            // for(int i = 0 ; i < R; i++){
            //     StringBuilder sb = new StringBuilder();
            //     for(int j = 0 ; j < C; j++){
            //         sb.append(map[i][j]).append("\t");
            //     }
            //     System.out.println(sb);
            // }
            // System.out.println();
            //시계방향
            for(int i = conditionB+1; i < R-1; i++)
                map[i][0] = map[i+1][0];
            for(int i = 0; i < C-1; i++)
                map[R-1][i] = map[R-1][i+1];
            for(int i = R-1; i > conditionB; i--)
                map[i][C-1] = map[i-1][C-1];
            for(int i = C-1; i > 1; i--)
                map[conditionB][i] = map[conditionB][i-1];
            map[conditionA][1] = 0;
            map[conditionB][1] = 0;
            //출력
            // for(int i = 0 ; i < R; i++){
            //     StringBuilder sb = new StringBuilder();
            //     for(int j = 0 ; j < C; j++){
            //         sb.append(map[i][j]).append("\t");
            //     }
            //     System.out.println(sb);
            // }
        }
        int answer = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0 ; j < C; j++)
                answer += map[i][j];
        }
        answer += 2;
        System.out.println(answer);
    }
}