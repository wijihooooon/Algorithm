import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static char map[][];
	// 선생님 좌표 모집
	public static ArrayList<int[]> tList = new ArrayList<>();
	public static boolean endSign = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new char[N+1][N+1];
		
		// map에 선생님 "T" 장애물 "O" 학생 "S" 빈 공간 "X"삽입
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') {
					tList.add(new int[] {i, j});
				}
			}
		}
		
		buildTheWall(0);
		if(endSign) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

	private static void buildTheWall(int cnt) {
		if(endSign) {
			return;
		}
		if(cnt == 3) {
			if(safeCheck()) {
				//yes
				endSign = true;
			}
			return;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O';
					buildTheWall(cnt+1);
					map[i][j] = 'X';
				}
			}
		}
	}

	private static boolean safeCheck() {
		int dx[] = {-1, 1, 0, 0}; // 상 하 좌 우
		int dy[] = {0, 0, -1, 1};
		
		for(int i=0; i<tList.size(); i++) {
			int x = tList.get(i)[0];
			int y = tList.get(i)[1];
			
			for(int j=0; j<4; j++) {
				int cx = x;
				int cy = y;
				
				while(true) {
					cx = cx + dx[j];
					cy = cy + dy[j];
					
					if(!(cx>0 && cy>0 && cx<=N && cy<=N) || map[cx][cy] == 'O') {
						break;
					}else {
						if(map[cx][cy] == 'S') {
							return false;
						}
					}
				}
				
			}
		}
		return true;
	}

}
