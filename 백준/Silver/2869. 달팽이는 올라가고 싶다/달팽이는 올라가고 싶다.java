import java.io.*;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int day = (V-A) / (A-B);
		int position = day * (A-B);
		while(position < V) {
			day++;
			position += A;
			if(position >= V)
				break;
			position -= B;
		}
		System.out.println(day);
	}
}