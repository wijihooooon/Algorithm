import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static int N, Y, count;
	public static int map[][];
	public static boolean check[];
	public static boolean found = false;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {	// map에 관계 삽입
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = 1;
		}
		check = new boolean[N+1];
		dfs(X, 0);
		if(count == 0) {
			sb.append(-1);
		}else {
			sb.append(count);
		}
		
		System.out.println(sb);
	}

	private static void dfs(int x, int depth) {
		if(found) return;
		check[x] = true;
		for(int i=1; i<=N; i++) {
			if(!check[i] && map[x][i] == 1) {
				if(i == Y) {
					count = depth + 1;
					found = true;
					return;
				}
				
				dfs(i, depth + 1);		
			}
		}
	}
}