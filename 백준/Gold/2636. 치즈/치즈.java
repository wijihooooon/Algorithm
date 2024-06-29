import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 세로: N, 가로: M
	public static int N, M;
	// 치즈 판
	public static int map[][];
	// 방문여부
	public static boolean visited[][];
	// 상하좌우
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 가로 세로 입력받음
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 치즈 판과 방문여부 확인하는거 배열 초기화
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 치즈 판에 치즈 삽입
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 치즈 개수 세기
		int cheeseCount = 0;
		// 사라지는데 걸리는 시간 세기
		int timeCount = 1;
		// 탈출을 위해 판에 공기가 얼마나 남았는지 세기
		int outCheck = 0;
	
		while(true) {
			// 치즈 개수 새기
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					// 좌표값이 1 이고 방문하지 않았으면 bfs
					if(map[i][j] == 1 && !visited[i][j]) {
						cheeseCount += bfsCheesse(i, j);
					}
				}
			}
			
			// 아래 외부 공기를 bfs하면서 공기와 접촉한 치즈를
			// 공기로 바꾸기 위해 방문확인 배열 초기화
			visited = new boolean[N][M];
			// 외부공기를 bfs해서 외부공기와 접촉한 치즈 0로 변경
			// 중첩 for문으로 한이유는
			/*		0 0 0 0 0  이런 배열이 주어질 경우 한 시간 만에 사라지는데
					0 1 1 0 0  중첩 반복문을 하지 않았을때 가운데 0을 아래 bfs에서
					0 1 0 1 0  체크하지 못해 종료하지 못하고 한번더 while문을 돔
					0 1 1 1 0
					0 0 0 0 0  */
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					// bfsAir배열에서 공기와 맞다은 치즈를 공기로 바꾸고 공기칸을 세서 반환
					if(map[i][j] == 0 && !visited[i][j]) {
						outCheck += bfsAir();
					}
				}
			}
			
			// 반환 받은 공기의 수와 N*M의 수가 같으면
			// 걸린 시간(timeCount)과 사라지기전 남은 치즈 개수(cheeseCount)를
			// 출력한뒤 while문 탈출
			if(outCheck == N*M) {
				System.out.println(timeCount);
				System.out.println(cheeseCount);
				break;
			}
			
			// while문을 돌때마나 판에 공기가 얼마나있는지 확인하는 outCheck와
			// 남은 치즈개수인 cheeseCount를 초기화 해주어야함
			// timeCount++을 걸리는시간 +1
			outCheck = 0;
			cheeseCount = 0;
			timeCount++;			
		}		
	}

	private static int bfsCheesse(int a, int b) {
		// 큐 를 int[]타입을 넣을 수 있게끔 생성
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a, b});
		// while문 들어가기전 a,b visited에 체크
		visited[a][b] = true;
		
		// 남은 치즈 개수 세기
		int localCheeseCount = 1;
		
		// 큐가 빌때까지 반복
		while(!q.isEmpty()) {
			// x, y 좌표값을 큐로 부터 꺼내옴
			int x = q.peek()[0];
			int y = q.peek()[1];
			// peek()로는 큐를 비울수 없어 poll()
			q.poll();
			
			// 상하좌우 순회
			for(int i=0; i<4; i++) {
				// 이동한 좌표
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				// 상하좌우로 이동한 좌표가 0<N,M인지 확인
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					// 이동한 좌표가 치즈(1)이고 방문하지 않았으면
					// 큐에 좌표를 넣고 해당 좌표를 방문배열에서 true로 변경 해준다.
					// 이후 치즈개수(localCheeseCount)를 +1
					if(map[cx][cy] == 1 && !visited[cx][cy]) {
						q.add(new int[] {cx, cy});
						visited[cx][cy] = true;
						localCheeseCount++;
					}
					
				}
			}
		}
		// 남아있는 치즈 개수를 return
		return localCheeseCount;
	}

	private static int bfsAir() {
		// 큐 를 int[]타입을 넣을 수 있게끔 생성
		Queue<int[]> q = new LinkedList<>();
		// 태두리는 치즈를 놓을 수 없기에 0, 0좌표를 넣음
		q.add(new int[] {0, 0});
		// 시작 좌표 방문 확인 배열에서 true로 변경
		visited[0][0] = true;
		// 공기랑 사라지는 치즈를 새기 위한 변수
		int count = 1; 
		
		// 큐가 빌때까지 반복
		while(!q.isEmpty()) {
			// x, y 좌표값을 큐로 부터 꺼내옴
			int x = q.peek()[0];
			int y = q.peek()[1];
			// peek()로는 큐를 비울수 없어 poll()
			q.poll();
			
			// 상하좌우 순회
			for(int i=0; i<4; i++) {
				// 이동한 좌표
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				// 상하좌우로 이동한 좌표가 0<N,M인지 확인
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					// 이동한 좌표가 방문하지 않았고 공기인경우 큐에 추가
					// 이동한 좌표가 방문하지 않았고 치즈인 경우 공기로 변경
					// 지금 하는 순회에서 만나는 치즈는 공기와 붙어있는 치즈임 map[x][y]가 공기이기때문
					// 이동한 좌표가 방문하지 않은 좌표이기만 하면 true로 방문 배열을 변경하고
					// 공기와 사라진 치즈 개수를 세는 count를 +1
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
		
		// 공기와 사라진 치즈의 수를 반환
		return count;
	}
}
