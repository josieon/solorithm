import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node_7579 implements Comparable<node_7579>{
    int memory;
    int cost;
    float bound;
    int level;

    node_7579(){}

    node_7579(int memory, int cost, int level){
        this.memory = memory;
        this.cost = cost;
        this.level = level;
    }

    node_7579(int memory, int cost, float bound, int level){
        this.memory = memory;
        this.cost = cost;
        this.bound = bound;
        this.level = level;
    }

    @Override
    public int compareTo(node_7579 target){
        return this.bound <= target.bound ? -1 : 1;
    }
}

class item_7579 implements Comparable<item_7579>{
    int memory;
    int cost;

    item_7579(int memory, int cost){
        this.memory = memory;
        this.cost = cost;
    }

    @Override
    public int compareTo(item_7579 target){
        if((float)this.memory / (float)this.cost == (float)target.memory / (float)target.cost)
            return target.memory - this.memory;
        return (float)this.memory / (float)this.cost <= (float)target.memory / (float)target.cost ? 1 : -1;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<node_7579> queue = new PriorityQueue<>();
    static int[] memory;
    static int[] cost;
    static final int INF = 10_000_000;
    static int M, N;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        memory = new int[N+1];
        for(int i = 1; i <= N; i++)
            memory[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        cost = new int[N+1];
        for(int i = 1; i <= N; i++)
            cost[i] = Integer.parseInt(st.nextToken());
        //System.out.println("memory:\t" + Arrays.toString(memory));
        //System.out.println("cost:\t" + Arrays.toString(cost));
        PriorityQueue<item_7579> tmp_queue = new PriorityQueue<>();
        for(int i = 1; i <= N; i++)
            tmp_queue.add(new item_7579(memory[i], cost[i]));
        for(int i = 1; i <= N; i++){
            item_7579 tmp = tmp_queue.poll();
            memory[i] = tmp.memory;
            cost[i] = tmp.cost;
        }
        tmp_queue = null;
        //System.out.println("memory:\t" + Arrays.toString(memory));
        //System.out.println("cost:\t" + Arrays.toString(cost));
        node_7579 u, v;
        int min_cost = INF;
        v = new node_7579(0, 0,  0);
        u = new node_7579();
        v.bound = bound(v);

        queue.add(v);
        while(!queue.isEmpty()){
            while(queue.size() > 200)
                queue.poll();
            v = queue.poll();
            if(v.bound < min_cost){
                u.level = v.level + 1;
                ///////////////LEFT CHILD : included item_7579 case/////////////
                u.cost = v.cost + cost[u.level];
                u.memory = v.memory + memory[u.level];
                if(u.cost < min_cost && u.memory >= M)
                    min_cost = u.cost;
                u.bound = bound(u);
                if(u.bound < min_cost && u.bound != 0)
                    queue.add(new node_7579(u.memory, u.cost, u.bound, u.level));
                
                //////////RIGHT CHILD : not included item_7579 case/////////////
                u.cost = v.cost;
                u.memory = v.memory;
                u.bound = bound(u);
                if(u.bound < min_cost && u.bound != 0)
                    queue.add(new node_7579(u.memory, u.cost, u.bound, u.level));
            }
        }
        System.out.println(min_cost);
    }

    public static float bound(node_7579 u){
        int j;
        float result;
        int total_memory;

        if(u.memory >= M)
            return 0;

        result = u.cost;
        total_memory = u.memory;
        j = u.level + 1;
        while(j <= N && total_memory + memory[j] < M){
            result += cost[j];
            total_memory += memory[j++];
        }

        if(j > N && total_memory < M)
            return 0;

        if(j <= N && cost[j] != 0)
            result += (M - total_memory) * (float)cost[j] / (float)memory[j];
        return result;
    }
}
