import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr = new int[20][20];
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        //입력 및 할당
        for(int i = 1; i < 20; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < 20; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //브루트 포스
        for(int j = 1; j < 20; j++){
            for(int i = 1; i < 20; i++){
                //돌이 있는 경우
                if(arr[i][j] == 1 || arr[i][j] == 2){
                    //우측 위 대각선에 동일한 색 존재
                    if(i-4 >= 1 && j+4 <= 19 && arr[i-1][j+1] == arr[i][j]){
                        int count = 1;
                        for(int k = 1; i-k >= 1 && j+k <= 19; k++){
                            if(arr[i-k][j+k] == arr[i][j])
                                count++;
                            else
                                break;
                        }
                        if(count == 5){
                            if(i == 19){
                                System.out.println(arr[i][j] + "\n" + i + " " + j);
                                return;
                            }
                            else if(arr[i+1][j-1] != arr[i][j]){
                                System.out.println(arr[i][j] + "\n" + i + " " + j);
                                return;
                            }
                        }
                    }
                    //우측에 동일한 색 존재
                    if(j+4 <= 19 && arr[i][j+1] == arr[i][j]){
                        int count = 1;
                        for(int k = 1; j+k <= 19; k++){
                            if(arr[i][j+k] == arr[i][j])
                                count++;
                            else
                                break;
                        }
                        if(count == 5 && arr[i][j-1] != arr[i][j]){
                            System.out.println(arr[i][j] + "\n" + i + " " + j);
                            return;
                        }
                    }
                    //아래에 동일한 색 존재
                    if(i+4 <= 19 && arr[i+1][j] == arr[i][j]){
                        int count = 1;
                        for(int k = 1; i+k <= 19; k++){
                            if(arr[i+k][j] == arr[i][j])
                                count++;
                            else
                                break;
                        }
                        if(count == 5 && arr[i-1][j] != arr[i][j]){
                            System.out.println(arr[i][j] + "\n" + i + " " + j);
                            return;
                        }
                    }
                    //우측 아래 대각선에 동일한 색 존재
                    if(i+4 <= 19 && j+4 <= 19 && arr[i+1][j+1] == arr[i][j]){
                        int count = 1;
                        for(int k = 1; i+k <= 19 && j+k <= 19; k++){
                            if(arr[i+k][j+k] == arr[i][j])
                                count++;
                            else
                                break;
                        }
                        if(count == 5 && arr[i-1][j-1] != arr[i][j]){
                            System.out.println(arr[i][j] + "\n" + i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        //승부가 결정나지 않았을 경우
        System.out.println("0");
    }
}