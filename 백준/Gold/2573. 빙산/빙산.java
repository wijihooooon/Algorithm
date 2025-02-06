import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static int[][] copyMap;
    public static boolean[][] visited;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static ArrayList<int[]> list;
    public static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map 저장
        map = new int[N][M];
        copyMap = new int[N][M];

        // 좌표 저장
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        int year = 0;
        int count;

        while(true) {
            // 빙산 체크
            visited = new boolean[N][M];
            count = 0;

            for(int i = 0; i < N; i++) {
                copyMap[i] = Arrays.copyOf(map[i], map[i].length);
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] != 0 && !visited[i][j]) {
                        count++;
                        check(i, j);
                        if(count >= 2){
                            System.out.println(year);
                            return;
                        }
                    }
                }
            }

            if(count == 0){
                System.out.println(0);
                return;
            }

            year++;

            // 녹이기
            melting();

            for(int i = 0; i < N; i++) {
                map[i] = Arrays.copyOf(copyMap[i], copyMap[i].length);
            }
        }
    }

    // 빙산 뭉탱이 확인
    private static void check(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            x = q.peek()[0];
            y = q.peek()[1];
            q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx >= 0 && cx < N && cy >= 0 && cy < M) {
                    if(!visited[cx][cy] && map[cx][cy] != 0) {
                        q.add(new int[]{cx, cy});
                        visited[cx][cy] = true;
                    }
                }

            }
        }
    }

    // 빙산 좌표를 활용해서 주위 탐색 밑 녹이기
    private static void melting() {
        ArrayList<int[]> tempList = new ArrayList<>();

        for(int i = list.size()-1; i >= 0; i--) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int count = 0;

            for(int j = 0; j < 4; j++) {
                int cx = x + dx[j];
                int cy = y + dy[j];

                if(cx>=0 && cx<N && cy>=0 && cy<M) {
                    if(map[cx][cy] == 0) {
                        count++;
                    }
                }
            }

            if(map[x][y] - count <= 0) {
                copyMap[x][y] = 0;
                list.remove(i);
            }else{
                copyMap[x][y] = map[x][y] - count;
                tempList.add(new int[]{x, y});
            }
        }
        list = tempList;
    }
}
