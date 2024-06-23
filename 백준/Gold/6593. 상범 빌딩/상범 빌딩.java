import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int L, R , C;
	
	public static int map[][][];
	public static Queue<int[]> q;
	
	public static int dz[] = {0, 0, 0, 0, -1, 1,};  // 뒤 앞 좌 우 하 상
	public static int dx[] = {-1, 1, 0, 0, 0, 0};
	public static int dy[] = {0, 0, -1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) { // 0 0 0이면 탈출
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			q = new LinkedList<>();
			
			L = Integer.parseInt(st.nextToken()); // 빌딩 층 수 z
			R = Integer.parseInt(st.nextToken()); // 행 x
			C = Integer.parseInt(st.nextToken()); // 열 y
			
			if(L == 0 && R == 0 && C == 0) {
				return;
			}
			
			map = new int[L][R][C];
			
			// 벽 : -1, 길 : 0, S : 1, E : -2 map에 값 삽입
			for(int i=0; i<L; i++) { // L
				for(int j=0; j<R; j++) { // R
					String s = br.readLine();
					for(int k=0; k<C; k++) { // C
						if(s.charAt(k) == 'S') {
							map[i][j][k] = 1;
							q.add(new int[] {i, j, k}); // 시작점 큐에 삽입
						}else if(s.charAt(k) == '#') {
							map[i][j][k] = -1;
						}else if(s.charAt(k) == '.') {
							map[i][j][k] = 0;
						}else if(s.charAt(k) == 'E') {
							map[i][j][k] = -2;
						}
					}
				}
				br.readLine();
			}
			
			int ans = bfs();
			
			if(ans != -2) {
				System.out.println("Escaped in " + (ans-1) + " minute(s).");
			}else {
				System.out.println("Trapped!");
			}
			
		}
		
	}

	private static int bfs() {
		
		while(!q.isEmpty()) {
			
			int z = q.peek()[0];
			int x = q.peek()[1];
			int y = q.peek()[2];
			
			q.poll();
			
			for(int j=0; j<6; j++) {
			
				int cz = z + dz[j]; 
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cz>=0 && cx<R && cy<C && cz<L) {
					if(map[cz][cx][cy] == 0) {
						q.add(new int[] {cz, cx, cy});
						map[cz][cx][cy] = map[z][x][y] + 1;   
					}else if(map[cz][cx][cy] == -2) {
						return map[cz][cx][cy] = map[z][x][y] + 1;
					}
				}
			}
		}
		return -2;
	}

}
