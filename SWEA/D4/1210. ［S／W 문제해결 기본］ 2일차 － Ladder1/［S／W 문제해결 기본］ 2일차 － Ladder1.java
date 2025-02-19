import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static int[][] map;
	public static Queue<int[]> q;
	public static int[] dx = {0, 0, -1}; // 좌 우 상
	public static int[] dy = {-1, 1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			
			q = new LinkedList<>();
			
			// map에 사다리 삽입
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						q.add(new int[] {i, j});
					}
				}
			}
			sb.append("#").append(T).append(" ").append(bfs()+1).append("\n");
		}
		System.out.println(sb);
	}
	private static int bfs() {
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<3; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<100 && cy<100) {
					if(map[cx][cy] == 1) {
						map[x][y] = -1;
						q.add(new int[] {cx, cy});
						break;
					}
				}
				if(cx==0) {
					return cy;
				}
			}
		}
		return 0;
	}
}
