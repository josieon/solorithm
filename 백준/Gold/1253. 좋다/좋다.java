import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashSet<Integer> set = new HashSet<>();
    static int[] arr;
    static int N, cnt;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i = 0 ; i < N; i++){
            pro(i);
        }
        System.out.println(cnt);
    }

    public static void pro(int idx){
        int s = 0, e = N-1;
        int target = arr[idx];
        while(s < e){
            if(s == idx)
                s++;
            else if(e == idx)
                e--;
            else{
                if(target > arr[s] + arr[e])
                    s++;
                else if(target == arr[s] + arr[e]){
                    cnt++;
                    return;
                }
                else
                    e--;
            }
        }
    }
}