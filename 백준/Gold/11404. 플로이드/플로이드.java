import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_cities = Integer.parseInt(br.readLine());
        int num_buses = Integer.parseInt(br.readLine());
        int[][] costs = new int[num_cities][num_cities];
        StringTokenizer st;
        int origin;
        int dest;
        int INF = 10000001;       //무한대값
        int cost;

        //비용 무한대로 초기화
        for(int i = 0; i < num_cities; i++){
            for(int j = 0; j < num_cities; j++){
                costs[i][j] = INF;
                if(i == j){
                    costs[i][j] = 0;
                }
            }
        }

        //입력 및 초기화
        for(int k = 0; k < num_buses; k++){
            st = new StringTokenizer(br.readLine(), " ");
            origin = Integer.parseInt(st.nextToken()) - 1;
            dest = Integer.parseInt(st.nextToken()) - 1;
            cost = Integer.parseInt(st.nextToken());
            if(costs[origin][dest] < cost)
                continue;
            else
                costs[origin][dest] = cost;
        }

        //플로이드 와샬 알고리즘
        for(int k = 0; k < num_cities; k++){
            for(int i = 0; i < num_cities; i++){
                for(int j = 0; j < num_cities; j++){
                    if(costs[i][k] + costs[k][j] < costs[i][j])
                        costs[i][j] = costs[i][k] + costs[k][j];
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num_cities; i++){
            for(int j = 0; j < num_cities; j++){
                if(costs[i][j] == INF)
                    costs[i][j] = 0;
                sb.append(costs[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
