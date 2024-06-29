import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static int map[][];
	public static boolean visited[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cheeseCount = 0;
		int timeCount = 1;
		int outCheck = 0;
		while(true) {
			// 치즈 갯수 새기
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						cheeseCount += bfsCheesse(i, j);
					}
				}
			}
			visited = new boolean[N][M];
			// 외부공기를 bfs해서 외부공기와 접촉한 치즈 0로 변경
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 0 && !visited[i][j]) {
						outCheck += bfsAir();
					}
				}
			}
			
			//탈출 조건
			if(outCheck == N*M) {
				System.out.println(timeCount);
				System.out.println(cheeseCount);
				break;
			}
			
			outCheck = 0;
			cheeseCount = 0;
			timeCount++;			
		}		
	}

	private static int bfsCheesse(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a, b});
		visited[a][b] = true;
		
		int localCheeseCount = 1;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] == 1 && !visited[cx][cy]) {
						q.add(new int[] {cx, cy});
						visited[cx][cy] = true;
						localCheeseCount++;
					}
					
				}
			}
		}
		return localCheeseCount;
	}

	private static int bfsAir() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		visited[0][0] = true;
		int count = 1; // 공기랑 사라지는 치즈 세서 치즈가 있는지 없는지 확인용
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(!visited[cx][cy]) {
						if(map[cx][cy] == 0) {
							q.add(new int[] {cx, cy});
						}else {
							map[cx][cy] = 0;
						}
						visited[cx][cy] = true;
						count++;
					}
					
				}
			}
		}

		return count;
	}

}
