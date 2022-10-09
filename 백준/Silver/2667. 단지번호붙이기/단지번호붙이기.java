import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stk = new Stack<>();
        int[][] T = new int[N][N];
        int[][] O = new int[N][N];
        ArrayList res = new ArrayList<>();
        for(int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < N; j++)
            {
                O[i][j] = (int)str.charAt(j) - 48;
            }
        }
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(O[i][j] == 1 && T[i][j] == 0)
                //새로운 단지를 탐색
                {
                    int[] a = {i, j};
                    int size = 1;
                    stk.push(a);
                    T[i][j] = 1;
                    while(stk.size() != 0)
                    {
                        a = stk.pop();
                        int x = a[0];
                        int y = a[1];
                        if(x > 0 && T[x-1][y] == 0 && O[x-1][y] == 1)
                        {
                            int[] b = {x-1, y};
                            stk.push(b);
                            T[x-1][y] = 1;
                            size++;
                        }
                        if(y < N-1 && T[x][y+1] == 0 && O[x][y+1] == 1)
                        {
                            int[] b = {x, y+1};
                            stk.push(b);
                            T[x][y+1] = 1;
                            size++;
                        }
                        if(x < N-1 && T[x+1][y] == 0 && O[x+1][y] == 1)
                        {
                            int[] b = {x+1, y};
                            stk.push(b);
                            T[x+1][y] = 1;
                            size++;
                        }
                        if(y > 0 && T[x][y-1] == 0 && O[x][y-1] == 1)
                        {
                            int[] b = {x, y-1};
                            stk.push(b);
                            T[x][y-1] = 1;
                            size++;
                        }
                    }
                    res.add(size);
                }
            }
        }
        res.sort(null);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(res.size()));
        for(int k = 0; k < res.size(); k++)
        {
            sb.append("\n").append(Integer.toString((int)res.get(k)));
        }
        System.out.println(sb);
    }
}