import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, max1, max2;
	public static int map[][];
	
	public static boolean isused1[]; // 우상 (차 x - y)
	public static boolean isused2[]; // 좌상 (합 x + y)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 보드 크기
		// 최대값 저장

		map = new int[N][N];
		isused1 = new boolean[N*2];
		isused2 = new boolean[N*2];
		// 1은 빈칸 / 0은 못놓는 칸
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 색상분리
		max1 = 0; // 흰색 최대값
		max2 = 0; // 검정색 최대값
		maxBishop(0, 0, 0); // 흰색
		maxBishop(0, 1, 1); // 검정색
		System.out.println(max1 + max2);
		
	}

	// BackTracking
	private static void maxBishop(int count, int start, int color) {
		
		if(color == 0) { // 흰색칸일때
			max1 = Math.max(max1,  count);
		}else { // 검정색칸일때
			max2 = Math.max(max2, count);
		}
		
		// 몫은 x좌표 나머지는 y좌표 0~N*N-1 까지
		for(int i=start; i<N*N; i++) {
			int x = i/N;
			int y = i%N;
			
			// 다른색이면 skip
			if ((x + y) % 2 != color) continue;
			
			// 칸이 1이고 좌상 우상에 비숍이 없는경우 비숍을 놓음
			// x-y+N-1는 음수가 되지 않게끔 하기위해 N-1을 더함
			if(map[x][y] == 1 && !isused1[x-y+N-1] && !isused2[x+y]) {
				map[x][y] = 2;
				isused1[x-y+N-1] = true;
				isused2[x+y] = true;
				maxBishop(count+1, i+1, color);
				isused1[x-y+N-1] = false;
				isused2[x+y] = false;
				map[x][y] = 1;
			}
		}
	}
}