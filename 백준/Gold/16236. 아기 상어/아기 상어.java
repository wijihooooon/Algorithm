import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, count;
    public static int map[][];
    public static int visited[][];
    public static int dx[] = {-1, 0, 0, 1}; // 상 좌 우 하
    public static int dy[] = {0, -1, 1, 0};
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    q.add(new int[]{i, j});
                    visited[i][j] = 1;
                    map[i][j] = 0; // 아기상어 시작지점을 0으로 변경
                }
            }
        }

        babySharkHunting();
        System.out.println(count);
    }

    // BFS를 사용하여 아기상어가 물고기를 먹는 과정
    private static void babySharkHunting() {
        int babySharkSize = 2;
        int babySharkEatCount = 0;

        while (true) {
            Queue<int[]> fishList = new LinkedList<>();
            int minDistance = Integer.MAX_VALUE;

            while (!q.isEmpty()) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                q.poll();

                for (int i = 0; i < 4; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    if (cx >= 0 && cy >= 0 && cx < N && cy < N && visited[cx][cy] == 0) {
                        if (map[cx][cy] <= babySharkSize) {
                            visited[cx][cy] = visited[x][y] + 1;

                            if (map[cx][cy] != 0 && map[cx][cy] < babySharkSize) {
                                if (visited[cx][cy] <= minDistance) {
                                    minDistance = visited[cx][cy];
                                    fishList.add(new int[]{cx, cy, visited[cx][cy]});
                                }
                            }
                            q.add(new int[]{cx, cy});
                        }
                    }
                }
            }
            // 더 이상 먹을 물고기가 없으면 종료
            if (fishList.isEmpty()) {
                break; 
            }

            // 최적의 물고기를 선택 (가장 위쪽, 가장 왼쪽 순)
            int[] target = fishList.poll();
            for (int[] fish : fishList) {
                if (fish[2] == minDistance) {
                    if (fish[0] < target[0] || (fish[0] == target[0] && fish[1] < target[1])) {
                        target = fish;
                    }
                }
            }

            // 물고기를 먹고 아기상어 위치 및 상태 갱신
            count += visited[target[0]][target[1]] - 1;
            babySharkEatCount++;
            if (babySharkEatCount == babySharkSize) {
                babySharkSize++;
                babySharkEatCount = 0;
            }

            // 새로 먹은 물고기 위치에서 BFS 재시작
            map[target[0]][target[1]] = 0;
            visited = new int[N][N];
            q.add(new int[]{target[0], target[1]});
            visited[target[0]][target[1]] = 1;
        }
    }
}
