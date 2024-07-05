// 불! 문제 주인공이 불보다 먼저 모서리에 도착하면 탈출 성공
// 불과 주인공은 1칸씩 퍼진다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// map크기 세로 N, 가로 M
	public static int N, M; 
	// map선언
	public static int map[][]; 
	// 상하좌우 이동
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	// 주인공의 큐
	public static Queue<int[]> Jq;
	// 불 큐
	public static Queue<int[]> Fq;
	
	public static void main(String[] args) throws IOException{
		// BufferedReader와 StringTokenizer를 통해 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			// N과M에 세로 가로 크기 지정
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			Jq = new LinkedList<>();
			Fq = new LinkedList<>();
			
			// map배열 생성
			map = new int[N][M];
			
			// 몇번만에 탈출하는지를 편하게 구하기 위해 정수로 변경
			// 벽(#)은 -1, 길(.)은 0, 사람은 좌표만 큐에 따로 저장하고 1, 불도 좌표만 따로 저장하고 1
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<M; j++) {
					if(s.charAt(j) == '#') {
						map[i][j] = -1;
					}else if(s.charAt(j) == '.') {
						map[i][j] = 0;
					}else if(s.charAt(j) == '@') {
						map[i][j] = 1;
						Jq.add(new int[] {i, j});
					}else if(s.charAt(j) == '*') {
						map[i][j] = 1;
						Fq.add(new int[] {i, j});
					}
				}
			}
			
			// 만약 사람이 가장자리에서 시작할 경우 바로 탈출
			if(Jq.peek()[0] == 0 || Jq.peek()[1] == 0 || Jq.peek()[0] == N-1 || Jq.peek()[1] == M-1) {
				sb.append("1").append("\n");
				continue;
			}
			
			// 불의 bfs를 먼저 진행
			// 사람보다 불의 bfs를 먼저 진행한 이유는 불과 사람이 동시에 같은 공간에 있을 수 없기 때문
			fire_bfs();
			
			// 사람의 bfs를 통해 리턴받은 값을 ans에 저장
			int ans = J_bfs();
	
			// -1이면 탈출 실패 아닌경우 출력
			if(ans == -1) { 
				sb.append("IMPOSSIBLE").append("\n");
			}else {
				sb.append(ans).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	// 불 전용 bfs
	private static void fire_bfs() {
		// 불 전용 큐가 빌때까지 반복
		while(!Fq.isEmpty()) {
			// x와y에 현재 불의 좌표 삽입
			int x = Fq.peek()[0];
			int y = Fq.peek()[1];
			// 값을 peek()로 확인했기에 poll()을해서 큐에서 제거
			Fq.poll();
			
			// cx, cy에 dx[i],dy[i]를 더해 상하좌우 좌표를 구함
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				// 이동한 좌표가 map[N][M]을 벗어나지 않는지 확인
				if(cx>=0 & cy>=0 && cx<N && cy<M) {
					// 만약 이동한 좌표가 0즉 길이면 이전좌표 값의 +1값을 넣어주고
					// 불 전용 큐에 이동한 좌표값을 넣어줌
					if(map[cx][cy] == 0) {
						map[cx][cy] = map[x][y] + 1;
						Fq.add(new int[] {cx, cy});
					}
				}
			}
		}
	}
	
	// 사람 전용 bfs
	private static int J_bfs() {
		// 사람 전용 큐가 빌때까지 반복
		while(!Jq.isEmpty()) {
			// x와y에 현재 사람의 좌표 삽입
			int x = Jq.peek()[0];
			int y = Jq.peek()[1];
			// 값을 peek()로 확인했기에 poll()을해서 큐에서 제거
			Jq.poll();
			
			// cx, cy에 dx[i],dy[i]를 더해 상하좌우 좌표를 구함
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				// 이동한 좌표가 map[N][M]을 벗어나지 않는지 확인
				if(cx>=0 & cy>=0 && cx<N && cy<M) {
					// 현재 지도에는 불이 몇번만에 이동했는지 값이 나와있기 때문에 사람이 현재 map[cx][cy]과 map[x][y] + 1의 값을
					// 비교해 더작을 경우 이동 또 만약 불이 없는 경우도 있기에 0이면 이동
					if(map[cx][cy] > map[x][y] + 1 || map[cx][cy] == 0) { // 불이 없는경우 map[cx][cy] == 0
						// 이동한 좌표의 값을 이전좌표값의 +1
						map[cx][cy] = map[x][y] + 1;
						// 만약 이동한 좌표가 가장자리일 경우 현재 값 return
						if(cx == 0 || cx == N-1 || cy == 0 || cy == M-1) {
							return map[cx][cy];
						}
						// 가장자리가 아닌경우 사람전용 큐에 좌표값 삽입
						Jq.add(new int[] {cx, cy});
					}
				}
			}
		}
		return -1;
	}
}
