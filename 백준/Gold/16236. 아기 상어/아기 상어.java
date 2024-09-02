import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int map[][];
    public static boolean visited[][];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        // map에 값 대입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 상어 위치, 거리 큐에 넣고 0으로 변경
                if (map[i][j] == 9) {
                    q.add(new int[] {i, j, 0});
                    map[i][j] = 0;
                }
            }
        }
        
        int sharkSize = 2; // 상어 크기
        int eatCount = 0; // 잡아먹은 물고기 수
        int totaldist = 0; // 총 이동 거리
        
        while (true) {
            ArrayList<int[]> result = babySharkHunting(sharkSize); // 먹을 수 있는 물고기 목록
            
            // 더이상 먹을 수 있는 물고기 목록이 비었을 경우 탈출
            if (result.isEmpty()) { 
                break;
            }
            
            // 최상단 최좌측 물고기 찾기
            int[] target = result.get(0);
            for (int[] fish : result) {
                if (fish[2] == target[2]) { // 동일한 거리의 물고기들 중에서
                    if (fish[0] < target[0] || (fish[0] == target[0] && fish[1] < target[1])) { // 최상단이거나 높이는 같고 최좌측인 경우
                        target = fish;
                    }
                }
            }

            // 상어 위치 및 총 이동 거리 최신화
            totaldist += target[2]; // 물고기를 먹기 위해 이동한 거리를 총 이동거리에 +
            map[target[0]][target[1]] = 0; // 물고기를 먹은 자리가 현위치 이므로 0으로 초기화
            q.clear(); // 물고기를 찾기위해 사용했던 큐를 초기화 하고 잡아 먹은 물고기 위치를 삽입
            q.add(new int[] {target[0], target[1], 0});
            
            // 물고기 먹고 상어 크기 최신화
            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
        System.out.println(totaldist);
    }

    private static ArrayList<int[]> babySharkHunting(int sharkSize) {
        
        visited = new boolean[N][N];
        ArrayList<int[]> eatableSharkList = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                int cdist = dist + 1;
                
                if (cx >= 0 && cy >= 0 && cx < N && cy < N && !visited[cx][cy]) { // 맵 내부에 있고 방문하지 않은 곳
                    visited[cx][cy] = true;
                    
                    if (map[cx][cy] <= sharkSize) { // 이동 가능한 경로 (물고기의 크기가 나랑 같거나 작은 곳)
                        q.add(new int[] {cx, cy, cdist});
                        
                        if (map[cx][cy] > 0 && map[cx][cy] < sharkSize) { // 먹을 수 있는 경우(물고기가 있다 + 물고기의 크기가 나보다 작다)
                            eatableSharkList.add(new int[] {cx, cy, cdist});
                        }
                    }
                }
            }
        }
        return eatableSharkList;
    }
}
