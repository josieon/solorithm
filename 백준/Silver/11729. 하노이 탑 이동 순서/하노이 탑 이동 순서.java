import java.io.*;
import java.lang.Math;
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		bw.write(Integer.toString((int)(Math.pow(2, N) - 1)));
		bw.write('\n');
		Hanoi(N, 1, 2, 3);
		bw.flush();
		bw.close();
	}
	
	public static void Hanoi(int N, int src, int tmp, int dst) throws Exception{
		if(N == 0)
			return;
		if(N == 1) {
			bw.write(src+ " " + dst + "\n");
			return;
		}
		else {
			Hanoi(N-1, src, dst, tmp);
			bw.write(src+ " " + dst + "\n");
			Hanoi(N-1, tmp, src, dst);
		}
	}
}