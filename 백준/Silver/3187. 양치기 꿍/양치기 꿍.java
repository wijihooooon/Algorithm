import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, Wolf, Sheep;
	
	public static char map[][];
	public static boolean visited[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		// 울타리: #, 양: k, 늑대: v
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && (map[i][j] == 'k' || map[i][j] =='v')){
					visited[i][j] = true;
					if(map[i][j] == 'k') {
						sheepVSwolf(i, j, 1, 0);
					}else if(map[i][j] == 'v') {
						sheepVSwolf(i, j, 0, 1);
					}
					
				}
			}
		}
		System.out.println(Sheep + " " + Wolf);
	}

	private static void sheepVSwolf(int x, int y, int localSheep, int localWolf) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});

		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx >= 0 && cy >= 0 && cx < N && cy < M) {
					if(!visited[cx][cy] && map[cx][cy] != '#') {
						
						if(map[cx][cy] == 'k') {
							localSheep++;
						}else if(map[cx][cy] == 'v') {
							localWolf++;
						}
						
						visited[cx][cy] = true;
						q.add(new int[] {cx, cy});
					}
				}
			}
		}
		
		if(localSheep > localWolf) {
			Sheep += localSheep;
		}else {
			Wolf += localWolf;
		}
	}

}
