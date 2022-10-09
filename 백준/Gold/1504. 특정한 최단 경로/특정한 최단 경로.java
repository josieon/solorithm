import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

class Point implements Comparable<Point>{
    int end;
    int weight;

    public Point(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Point o){
        return weight - o.weight;
    }
}

public class Main {
    private static final int INF = 100_000_000;
    static int[] dist;
    static boolean[] visited;
    static List<Point> list[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Point(end, cost));
            list[end].add(new Point(start, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int required_1 = Integer.parseInt(st.nextToken());
        int required_2 = Integer.parseInt(st.nextToken());

        int res_1 = 0;
        res_1 += dijkstra(1, required_1);
        res_1 += dijkstra(required_1, required_2);
        res_1 += dijkstra(required_2, N);

        int res_2 = 0;
        res_2 += dijkstra(1, required_2);
        res_2 += dijkstra(required_2, required_1);
        res_2 += dijkstra(required_1, N);

        int result = res_1 > res_2? res_2 : res_1;
        if(res_1 >= INF && res_2 >= INF)
            result = -1;
        
        System.out.println(result);
    }

    public static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;

            if(visited[curNode] == true)
                continue;
            visited[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++){
                int nextNode = list[curNode].get(i).end;
                int nextWeight = list[curNode].get(i).weight;
                if(!visited[nextNode] && dist[nextNode] > curWeight + nextWeight){
                    dist[nextNode] = curWeight + nextWeight;
                    queue.add(new Point(nextNode, dist[nextNode]));
                }
            }
        }
        return dist[end];
        /*
        while(true){
            int current = getSmallIndex();
            visited[current] = true;
            for(int j = 1; j <= visited.length; j++){
                if(!visited[j]){
                    if(dist[current] + list[current].get(j-1).weight < dist[j])
                        dist[j] = dist[current] + list[current].get(j-1).weight;
                }
            }
            if(visited[end])
                return dist[end];
        }
        */
    }

    public static int getSmallIndex(){
        int min = INF;
        int index = 0;
        for(int i = 1; i <= dist.length; i++){
            if(dist[i] < min && !visited[i]){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}