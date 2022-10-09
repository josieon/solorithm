import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r1, r2, c1, c2, max = 0;
    static int map[][];
    //소용돌이가 반시계방향이므로 dx, dy의 값 순서는 아래와 같다.
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[r2-r1+1][c2-c1+1];
        fill();
        print();
    }
    public static void fill(){
        int x = 0, y = 0, dir = 0;
        int num = 1, len = 1, cnt = 0;
        while(!end_check()){
            //범위 내에 오면 할당
            if(x >= r1 && x <= r2 && y >= c1 && y <= c2)
                map[x-r1][y-c1] = num;
            num++;
            cnt++;
            x += dx[dir];
            y += dy[dir];

            if(cnt == len){
                cnt = 0;
                //방향이 위나 아래였으면 길이 증가
                if(dir == 1 || dir == 3)
                    len++;
                dir = (dir + 1) % 4;    //방향 전환
            }
        }
        max = num - 1;  //최댓값 저장
    }
    public static boolean end_check(){
        return map[0][0] != 0 && map[r2-r1][0] != 0 && map[0][c2-c1] != 0 && map[r2-r1][c2-c1] != 0;
    }
    public static void print(){
        int max_len = (int)Math.log10(max); //자릿수 계산
        int len;
        for(int i = 0; i <= r2-r1; i++){
            for(int j = 0; j <= c2-c1; j++){
                len = max_len - (int)Math.log10(map[i][j]);
                for(int k = 0; k < len; k++)
                    sb.append(" ");
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}