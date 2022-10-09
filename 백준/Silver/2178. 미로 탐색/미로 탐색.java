import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int stage;
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] input = new int[N][M];
    boolean[][] visited = new boolean[N][M];
    int [] dx = {-1, 0, 1, 0};
    int [] dy = {0, -1, 0, 1};

    for(int i = 0; i < N; i++){
      String tmp = br.readLine();
      for(int j = 0; j < M; j++){
        input[i][j] = (int)tmp.charAt(j) - '0';
        visited[i][j] = false;
      }
    }
    visited[0][0] = true;

    Queue<int[]> queue = new LinkedList<>();
    int[] coordinate = {0, 0};
    queue.add(coordinate);

    while(!queue.isEmpty()){
      coordinate = queue.poll();
      int x = coordinate[0];
      int y = coordinate[1];
      for(int i = 0; i < 4; i++){
        int nextX = x + dx[i];
        int nextY = y + dy[i];

        if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
          continue;
        
        if(visited[nextX][nextY] || input[nextX][nextY] == 0)
          continue;

        int[] tmp = {nextX, nextY};
        queue.add(tmp);
        input[nextX][nextY] = input[x][y] + 1;
        visited[nextX][nextY] = true;
      }
    }

    System.out.println(input[N-1][M-1]);
  }
}