import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, virus, space;
	public static int wall = 3;
	public static int max = 0;
	
	public static int map[][];
	public static int tempMap[][];
	public static ArrayList<int[]> virusList = new ArrayList<>();

	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static Queue<int[]> q = new LinkedList<>(); // 바이러스용 q~
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		space = N * M -3;
		map = new int[N][M];
		tempMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					space--;
				}else if(map[i][j] == 2) {
					space--;
					virusList.add(new int[] {i, j});
				}
			}
		}	
		
		buildTheWall(0);
		
		System.out.println(max);
		
	}

	private static void buildTheWall(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					buildTheWall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		
		for (int i = 0; i < N; i++) {
			// 배열을 다른 배열에 복사할때 사용
			// 원본배열, 복사할 시작지점, 대상배열, 복사받을 시작지점, 복사할 요소의 수
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }
		
		for(int i=0; i<virusList.size(); i++) {
			q.add(new int[] {virusList.get(i)[0], virusList.get(i)[1]});
		}
		
		int newVirus = 0;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(tempMap[cx][cy] == 0) {
						tempMap[cx][cy] = 2;
						q.add(new int[] {cx, cy});
						newVirus++;
					}
				}
			}
		}
		max = Math.max(max, space-newVirus);
	}
}
