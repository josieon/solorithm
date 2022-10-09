import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> nn = new ArrayList<>();
    static List<Integer> pn = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n > 0)
                pn.add(n);
            else
                nn.add(n);
        }
        Collections.sort(pn, Collections.reverseOrder());
        Collections.sort(nn);

        int sum = 0;
        int i = 0;
        while(i < pn.size()){
            if(i + 1 < pn.size() && pn.get(i) != 1 && pn.get(i+1) != 1)
                sum += pn.get(i++) * pn.get(i++);
            else
                sum += pn.get(i++);
        }
        i = 0;
        while(i < nn.size()){
            if(i + 1 < nn.size() && nn.get(i) != 1 && nn.get(i+1) != 1)
                sum += nn.get(i++) * nn.get(i++);
            else
                sum += nn.get(i++);
        }
        System.out.println(sum);
        /* 처음 안 보고 푼 코드. 테스트케이스는 맞게 나오나 제출하면 틀렸다고 나옴.
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int sum = 0;
        /////////////////////////////////////////////////////////////
        int idx = 0;
        // idx-1 까지가 음수의 범위
        while(true){
            if(arr[idx] >= 0 || idx+1 >= N)
                break;
            idx++;
        }
        int i = 0;
        for(; i < idx - 1; i += 2){
            sum += arr[i] * arr[i+1];
        }
        if(i == idx - 1 && arr[idx] != 0 || i == idx && arr[idx] < 0)
            sum += arr[i];
        //System.out.println(sum);
        ////////////////////////////////////////////////////////////
        // idx부터 끝까지 양수의 범위(1은 제외) : 1은 양수에 곱해도 그대로이기 때문에 그대로 더하는것이 더 큰 합을 만듦
        while(true){
            if(idx+1 > N || arr[idx] > 1)
                break;
            idx++;
        }
        //System.out.println("idx:\t" + idx);
        for(i = N - 1; i > idx; i -= 2){
            sum += arr[i] * arr[i-1];
        }
        //System.out.println(sum);
        i = idx - 1;
        while(true){
            if(i < 0)
                break;
            if(arr[i] > 0)
                sum += arr[i--];
            else
                break;
        }
        System.out.println(sum);
        */
    }
}