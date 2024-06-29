import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static int map[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1 ,1};
	
	public static Queue<int[]> water = new LinkedList<>();
	public static Queue<int[]> hedgehog = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	
		
		map = new int[N][M];
		
		int x = 0;
		int y = 0;
		// 물 = * = 1 /돌 = X = -1 / 비버굴 = D = -2/ 고슴도치 = S = 1
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				if(s.charAt(j) == '*') {
					map[i][j] = 1;
					water.add(new int[] {i, j});
				}else if(s.charAt(j) == 'X') {
					map[i][j] = -2;
				}else if(s.charAt(j) == 'D') {
					x = i;
					y = j;
					map[i][j] = -1;
				}else if(s.charAt(j) == 'S'){
					map[i][j] = 1;
					hedgehog.add(new int[] {i, j});
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		flood();
		run();	
		
		if(map[x][y] == -1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(map[x][y]-1);
		}
	}

	private static void run() {
		
		while(!hedgehog.isEmpty()) {
			int x = hedgehog.peek()[0];
			int y = hedgehog.peek()[1];
			hedgehog.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					// 비버집인 경우, 물이 없는경우, 물이 고슴도치보다 늦게 차는 경우
					if(map[cx][cy] == -1 || map[cx][cy] == 0 || map[cx][cy] > map[x][y] + 1 ) {
						hedgehog.add(new int[] {cx, cy});
						map[cx][cy] = map[x][y] + 1;
					}
				}
			}
		}
	}

	private static void flood() {
		
		while(!water.isEmpty()) {
			int x = water.peek()[0];
			int y = water.peek()[1];
			water.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] == 0) {
						water.add(new int[] {cx, cy});
						map[cx][cy] = map[x][y] + 1;
					}
				}
			}
		}
	}

}
