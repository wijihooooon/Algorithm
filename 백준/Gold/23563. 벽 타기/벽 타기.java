import java.util.*;
import java.io.*;

public class Main {

    public static int H, W;
    public static char map[][];
    public static int dist[][];
    public static boolean adj[][];

    public static Deque<int[]> dq = new ArrayDeque<>();

    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        dist = new int[H][W];
        adj = new boolean[H][W];

        for(int i=0; i<H; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<H; i++){
            String str = br.readLine();
            for(int j=0; j<W; j++){
                char chr = str.charAt(j);
                map[i][j] = chr;
                if(chr == 'S'){
                    dq.add(new int[] {i, j});
                    dist[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < H - 1; i++) {
            for (int j = 1; j < W - 1; j++) {
                if (map[i][j] == '#') continue;
                adj[i][j] = (map[i - 1][j] == '#') || (map[i + 1][j] == '#')
                         || (map[i][j - 1] == '#') || (map[i][j + 1] == '#');
            }
        }

        System.out.println(slideTheWall());
    }

    public static int slideTheWall(){
        int x = 0;
        int y = 0;
        int d = 0;

        while(!dq.isEmpty()){
            x = dq.peek()[0];
            y = dq.peek()[1];
            d = dist[x][y];
            dq.poll();

            if(map[x][y] == 'E') return d;

            for(int i=0; i<4; i++){     
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(map[cx][cy] == '#') continue;

                int w = (adj[x][y] && adj[cx][cy]) ? 0 : 1;

                int cd = d + w;

                if (cd < dist[cx][cy]) {
                    dist[cx][cy] = cd;
                    if (w == 0) dq.addFirst(new int[] {cx, cy});
                    else dq.addLast(new int[] {cx, cy});
                }               
            }
        }
        return 0;
    }
}