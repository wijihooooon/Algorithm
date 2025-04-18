import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	public static int[] temp;
	public static StringBuilder sb;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		temp = new int[M];
		
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			temp[cnt] = i;
			dfs(cnt+1);
		}
	}
}
