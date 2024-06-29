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
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cheeseCount = 0;
        int timeCount = 0;
        int lastCheeseCount = 0;

        while (true) {
            // 현재 치즈 개수 세기
            cheeseCount = countCheese();
            if (cheeseCount == 0) {
                System.out.println(timeCount);
                System.out.println(lastCheeseCount);
                break;
            }

            lastCheeseCount = cheeseCount;
            timeCount++;
            meltCheese();
        }
    }

    private static int countCheese() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void meltCheese() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < N && cy < M && !visited[cx][cy]) {
                    visited[cx][cy] = true;
                    if (map[cx][cy] == 1) {
                        map[cx][cy] = 0;
                    } else {
                        q.add(new int[] {cx, cy});
                    }
                }
            }
        }
    }
}
