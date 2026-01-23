import java.util.*;
import java.io.*;

public class Main{

    public static int N;

    public static int map[][];
    public static boolean visited[][];

    public static int dx[] = {1, 0};
    public static int dy[] = {0, 1};

    public static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(jumpKingJJelly()){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
    }

    public static boolean jumpKingJJelly(){
        int x = 0;
        int y = 0;
        dq.add(new int[] {x, y});
        visited[x][y] = true;
        
        while(!dq.isEmpty()){
            x = dq.peek()[0];
            y = dq.peek()[1];
            int num = map[x][y];
            dq.poll();

            for(int i=0; i<2; i++){
                int cx = x + dx[i] * num;
                int cy = y + dy[i] * num;
                
                if(cx>=N || cy>=N) continue;
                if(map[cx][cy] == -1) return true;
                if(visited[cx][cy]) continue;

                dq.add(new int[] {cx, cy});
                visited[cx][cy] = true;
            }
        }
        return false;
    }
}