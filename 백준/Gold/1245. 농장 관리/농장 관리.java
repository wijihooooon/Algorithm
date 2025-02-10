import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, count;

    public static int[][] map;
    public static boolean[][] visited;

    public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = 0;

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        boolean check = false;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<8; i++) {
                int cx = p.x + dir[i][0];
                int cy = p.y + dir[i][1];

                if(cx>=0 && cy>=0 && cx<N && cy<M){
                    if(map[cx][cy] > map[p.x][p.y]){ // 현재 영역 보다 높은 곳
                        check = true;
                    }

                    if(!visited[cx][cy] && map[cx][cy] == map[p.x][p.y]){ // 같은 영역
                        visited[cx][cy] = true;
                        q.add(new Point(cx, cy));
                    }
                }
            }
        }
        if(!check){
            count++;
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}