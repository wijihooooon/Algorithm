import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				ans = Math.min(ans, findInfluentialPerson(i, map, N));
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static int findInfluentialPerson(int who, int[][] map, int N) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {who, 0});
		boolean[] visited = new boolean[N+1];
		visited[who] = true;
		int sum = 0;
		
		while(!q.isEmpty()) {
			int now = q.peek()[0];
			int count = q.peek()[1];
			q.poll();
			
			for(int i=1; i<=N; i++) {
				if(map[now][i] == 1 && !visited[i]) {
					visited[i] = true;
					sum += count + 1;
					q.add(new int[] {i, count+1});
				}
			}
		}
		return sum;
	}
}
/*
 * 풀이아이디어
 *  visited 배열을 활용하여 각 노드에서 bfs돌리고 노드 방문할때마다
 *  count++해서 sum에 더하기
 *  q에 x, y, count 넣기
 *  sum 최소값 출력 
 * */