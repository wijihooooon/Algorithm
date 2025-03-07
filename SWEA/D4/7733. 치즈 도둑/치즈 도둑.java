import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static int N;
    public static int[][] map;
    public static boolean[][] visited;

    public static int dx[] = {-1 , 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            int ans = 1;
            int max = Integer.MIN_VALUE;

            map = new int[N+1][N+1];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            int day = 1;
            int count = 0;
            while(max --> 0){
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(map[i][j] == day){
                            map[i][j] = 0;
                        }
                    }
                }
                count = 0;
                visited = new boolean[N][N];
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(!visited[i][j] && map[i][j] != 0){
                            countChees(i, j);
                            count++;
                        }
                    }
                }
                ans = Math.max(ans, count);
                day++;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void countChees(int i, int j) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(i, j));
        visited[i][j] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int k=0; k<4; k++){
                int cx = now.x + dx[k];
                int cy = now.y + dy[k];

                if(cx>=0 && cy>=0 && cx<N && cy<N){
                    if(!visited[cx][cy] && map[cx][cy] != 0){
                        visited[cx][cy] = true;
                        q.add(new Node(cx, cy));
                    }
                }
            }
        }
    }

    private static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
