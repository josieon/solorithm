import java.util.*;
import java.io.*;

public class Main{
    static Set<Integer> set = new TreeSet<>();
    static final int[] limit = new int[3];
    static boolean[][] check = new boolean[201][201];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        limit[0] = Integer.parseInt(st.nextToken());
        limit[1] = Integer.parseInt(st.nextToken());
        limit[2] = Integer.parseInt(st.nextToken());
        dfs(0, 0, limit[2]);
        StringBuilder sb = new StringBuilder();
        for(int num : set)
            sb.append(num).append(" ");
        System.out.println(sb);
    }
    public static void dfs(int a, int b, int c){
        if(check[a][b]) return;
        if(a == 0)
            set.add(c);
        check[a][b] = true;
        // 0 -> 1
        if(a+b > limit[1])
            dfs(a+b-limit[1], limit[1], c);
        else
            dfs(0, a+b, c);
        // 1 -> 0
        if(a+b > limit[0])
            dfs(limit[0], a+b-limit[0], c);
        else
            dfs(a+b, 0, c);
        // 0 -> 2
        dfs(0, b, a+c);
        // 2 -> 0
        if(a+c > limit[0])
            dfs(limit[0], b, a+c-limit[0]);
        else
            dfs(a+c, b, 0);
        // 1 -> 2
        dfs(a, 0, b+c);
        // 2 -> 1
        if(b+c > limit[1])
            dfs(a, limit[1], b+c-limit[1]);
        else
            dfs(a, b+c, 0);
    }
}