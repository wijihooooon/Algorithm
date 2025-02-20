import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;

    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<int[]> list;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 내부: 0 외부 : -1 : 치즈 : 1

        airArea();

        int count = 0;
        while (true) {
            visited = new boolean[N][M];
            list.clear();

            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 1) {
                        cheeseCheck(i, j);
                    }
                }
            }

            if (list.isEmpty()) break;

            for (int[] cell : list){
                map[cell[0]][cell[1]] = -1;
            }

            airArea();
            count++;
        }
        System.out.println(count);
    }

    private static void cheeseCheck(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            x = q.peek()[0];
            y = q.peek()[1];
            q.poll();

            int airCount = 0;
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx<N && cy<M && map[cx][cy] == -1) {
                    airCount++;
                }
            }
            if(airCount >= 2){
                list.add(new int[]{x, y});
            }

            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx<N && cy<M){
                    if(map[cx][cy] == 1 && !visited[cx][cy]){
                        visited[cx][cy] = true;
                        q.add(new int[]{cx, cy});
                    }
                }
            }
        }
    }

    private static void airArea() {
        Queue<int[]> airQ = new LinkedList<>();
        boolean[][] airVisited = new boolean[N][M];

        airQ.add(new int[]{0, 0});
        airVisited[0][0] = true;
        
        while(!airQ.isEmpty()) {
            int x = airQ.peek()[0];
            int y = airQ.peek()[1];
            airQ.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
                    if ((map[cx][cy] == 0 || map[cx][cy] == -1) && !airVisited[cx][cy]) {
                        airVisited[cx][cy] = true;
                        map[cx][cy] = -1;
                        airQ.add(new int[]{cx, cy});
                    }
                }
            }
        }
    }
}
