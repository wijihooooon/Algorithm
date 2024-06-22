import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	public static int[][] map;
	public static boolean[][] check;
	public static LinkedList<Integer> list = new LinkedList<>();
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int count = 0;
		
		map = new int[N][N];
		check = new boolean[N][N];
		
		for(int j=0; j<N; j++) {
			String s = br.readLine();
			for(int k=0; k<N; k++) {
				map[j][k] = s.charAt(k) - '0';
			}
		}
		
		for(int j=0; j<N; j++) {
			for(int k=0; k<N; k++) {
				if(map[j][k] == 1 && !check[j][k]) {
					BFS(j, k);
					count++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(count);
		for(int j=0; j<list.size(); j++) {
			System.out.println(list.get(j));
		}
	}

	private static void BFS(int x, int y) {
		int localCount = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx >= 0 && cy >= 0 && cx < N && cy < N) {
					if(map[cx][cy] == 1 && !check[cx][cy]) {
						q.add(new int[] {cx, cy});
						check[cx][cy] = true;
						localCount++;
					}
				}
			}
		}
		if(localCount != 0) {
			list.add(localCount);
		}
		
	}
}