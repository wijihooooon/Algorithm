import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	public static int N, L;
	public static int[][] arr;
	public static int ans;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			
			// 음식 맛 및 칼로리 저장
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			dfs(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
			System.out.println(sb);
	}

	private static void dfs(int x, int score, int cal) {
		// 칼로리 초과시 종료
		if(cal > L) {
			return;
		}
		
		// 최대 점수 갱신
		if(x == N) {
			ans = Math.max(score, ans);
			return;
		}
		
		// 선택하지 않는 경우
		dfs(x + 1, score, cal);
		// 선택하는 경우
		dfs(x + 1, score + arr[x][0], cal + arr[x][1]);
	}
}
