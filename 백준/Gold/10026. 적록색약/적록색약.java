import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static int N;
	
	public static char map[][];
	public static boolean visited[][];
	public static boolean check;
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int NormalCount = 0;
		int ColorWeakCount = 0;
		
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int j=0; j<N; j++) { // map에 RGB삽입
			String s = br.readLine();
			for(int k=0; k<N; k++) {
				map[j][k] = (s.charAt(k));
			}
		}
		
		
		for(int j=0; j<N; j++) { // 정상인 bfs~
			for(int k=0; k<N; k++) {
				if(!visited[j][k]) {
					if(map[j][k] == 'R') {
						bfs(j, k, 'R');
						NormalCount++;
					}else if(map[j][k] == 'G') {
						bfs(j, k, 'G');
						NormalCount++;
					}else {
						bfs(j, k, 'B');
						NormalCount++;
					}
				}
				
			}
		}
		visited = new boolean[N][N]; // 초기화

		for(int j=0; j<N; j++) { // 색약인 bfs~
			for(int k=0; k<N; k++) {
				if(!visited[j][k]) {
					if(map[j][k] == 'R' || map[j][k] == 'G') {
						check = true; // 색약인 전용 스위치
						bfs(j, k, 'R');
						ColorWeakCount++;
					}else {
						check = false;
						bfs(j, k, 'B');
						ColorWeakCount++;
					}
				}
				
			}
		}
		
		System.out.println(NormalCount + " " + ColorWeakCount);
		
	}


	private static void bfs(int x, int y, char color) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx<N && cy<N) {
					if(!check) {
						if(!visited[cx][cy] && map[cx][cy] == color) {
							q.add(new int[] {cx, cy});
							visited[cx][cy] = true;
						}
					}else {
						if(!visited[cx][cy] && (map[cx][cy] == color || map[cx][cy] == 'G')) {
							q.add(new int[] {cx, cy});
							visited[cx][cy] = true;
						}
					}
					
				}
			}
		}
	}
}