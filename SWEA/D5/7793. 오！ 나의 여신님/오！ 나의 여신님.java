import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static int N, M;
	
	public static char[][] map;
	public static ArrayDeque<int[]> q;
	public static boolean[][] visitedD;
	public static boolean[][] visitedS;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			visitedD = new boolean[N][M];
			visitedS = new boolean[N][M];
			q = new ArrayDeque<>();
			
			// S : 수연이, D : 여신, X : 돌, * : 악마
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						q.offerFirst(new int[] {i, j, 0});
						visitedD[i][j] = true;
					}else if(map[i][j] == 'S') {
						q.offerLast(new int[] {i, j, 1});
						visitedS[i][j] = true;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(avoidTheDemon()).append("\n");
		}
		System.out.println(sb);
	}

	private static String avoidTheDemon() {
		int count = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			count++;
			
			for(int j=0; j<size; j++) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				int who = q.peek()[2];
				q.poll();
				
				for(int i=0; i<4; i++) {
					int cx = x + dx[i];
					int cy = y + dy[i];
					
					if(cx<0 || cy<0 || cx>=N || cy>=M) continue;
					if(who == 0) { // 악마 확장
						if(!visitedD[cx][cy] && (map[cx][cy] == '.' || map[cx][cy] == 'S') ) {
							map[cx][cy] = '*';
							visitedD[cx][cy] = true;
							q.offer(new int[] {cx, cy, 0});
						}
					}else { // 수연이 도망
						if (!visitedS[cx][cy]) {
						    if (map[cx][cy] == 'D') return Integer.toString(count);
						    if (map[cx][cy] == '.') {
						        visitedS[cx][cy] = true;
						        map[cx][cy] = 'S';
						        q.offer(new int[] {cx, cy, 1});
						    }
						}
					}
				}
			}			
		}
		return "GAME OVER";
	}
}
/*
 * 풀이 아이디어
 * 수연이와 악마의 손아귀를 동시에 bfs
 * 하나의 큐에 악마의 손아귀, 수연이 좌표를 넣고 bfs를 하면 되지않을까? 
 * */