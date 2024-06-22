import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, K;
	
	public static int map[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		int count = 0;
		
		for(int j = 0; j<K; j++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int l= M - y2; l<M-y1; l++) { // map에 삽입~
				for(int m=x1; m<x2; m++) {
					map[l][m] = 1;
				}
			}
		}
		
		// 0 인곳 만 bfs~
		for(int j=0; j<M; j++) {
			for(int k=0; k<N; k++) {
				if(map[j][k] == 0) {
					list.add(bfs(j, k));
					count++;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(count);
		
		for(int j=0; j<list.size(); j++) {
			System.out.print(list.get(j) + " ");
		}
	}

	private static Integer bfs(int x, int y) {
		int localSize = 1;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		map[x][y] = 1;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx<M && cy<N) {
					if(map[cx][cy] == 0) {
						q.add(new int[] {cx, cy});
						map[cx][cy] = 1;
						localSize++;
					}
				}
			}
			
		}
		
		return localSize;
	}

}