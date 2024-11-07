import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean arr[] = new boolean[M+1];
		
		for(int i=2; i*i<=M; i++) {
			if(!arr[i]) {
				for(int j = i * i; j <= M; j+=i) {
					arr[j] = true;
				}
			}
		}
		
		for(int i=N; i<=M; i++) {
			if(i>1 && !arr[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
