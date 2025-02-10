import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

   public static int N, M;
   public static int[][] map;
   public static boolean[][][] visited;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 0은 안부숨 1은 부숨

        // map에 값 넣기
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
    private static int bfs(){
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 1));
        visited[0][0][0] = true;
        //visited[0][0][1] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            // 도착지점에 도착하면 값 반환
            if(p.x == N-1 && p.y == M-1) return p.count;

            for(int i=0; i<4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx>=0 && cy>=0 && cx<N && cy<M){
                    if(map[cx][cy] == 1){ // 벽인 경우
                        if(p.isCrashed) continue;// 부순 경우
                        visited[cx][cy][1] = true;
                        q.add(new Point(cx, cy, p.count+1, true));
                    }else{ // 길인 경우
                        int idx = p.isCrashed ? 1 : 0;
                        if(visited[cx][cy][idx]) continue;
                        visited[cx][cy][idx] = true;
                        q.add(new Point(cx, cy, p.count+1, p.isCrashed));
                    }
                }
            }
        }
        return -1;
    }
}

class Point{
    int x;
    int y;
    int count;
    boolean isCrashed;

    public Point(int x, int y, int count, boolean isCrashed){
        this.x = x;
        this.y = y;
        this.count = count;
        this.isCrashed = isCrashed;
    }

    public Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
        this.isCrashed = false;
    }
}