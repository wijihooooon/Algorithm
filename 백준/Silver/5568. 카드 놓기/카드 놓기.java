import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static int N, K;
	public static String[] str;
	public static boolean[] visited;
	public static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		str = new String[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		dfs(new StringBuilder(), 0);
		System.out.println(set.size());
	}

	private static void dfs(StringBuilder sb, int cnt) {
		if(cnt == K) {
			set.add(sb.toString());
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(sb.append(str[i]), cnt+1);
			sb.setLength(sb.length() - str[i].length());
			visited[i] = false;
		}
	}
}