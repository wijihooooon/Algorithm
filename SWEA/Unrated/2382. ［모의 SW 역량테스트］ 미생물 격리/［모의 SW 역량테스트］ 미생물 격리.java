import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    public static int N;
    public static int microorganismSum;
    public static Node[][] map;
    public static Queue<Node> q;
    public static int[] dx = {0, -1, 1, 0, 0};
    public static int[] dy = {0, 0, 0, -1, 1};
 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
 
            microorganismSum = 0;
 
            map = new Node[N][N];
            q = new ArrayDeque<>();
 
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int microorganism = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
 
                q.add(new Node(x, y, microorganism, microorganism, d));
            }
 
            while(M-->0){
                Move();
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(map[i][j] != null){
                            q.add(map[i][j]);
                        }
                    }
                }
            }
 
            while(!q.isEmpty()){
                microorganismSum += q.remove().microorganism;
            }
            sb.append("#").append(t).append(" ").append(microorganismSum).append("\n");
        }
        System.out.println(sb);
 
    }
    private static void Move(){
        map = new Node[N][N];
        while(!q.isEmpty()){
            Node now = q.poll();
            int x = now.x + dx[now.d];
            int y = now.y + dy[now.d];
            int currCount = now.microorganism;
            int currDir = now.d;
 
            if(x == 0 || y == 0 || x == N-1 || y == N-1){
                if(currDir == 1) currDir = 2;
                else if(currDir == 2) currDir = 1;
                else if(currDir == 3) currDir = 4;
                else if(currDir == 4) currDir = 3;
                currCount /= 2;
                if(currCount == 0) continue;
            }
 
            if(map[x][y] == null) {
                map[x][y] = new Node(x, y, currCount, currCount, currDir);
            } else {
                Node existing = map[x][y];
                int newTotal = existing.microorganism + currCount;
                int newMaxCount;
                int newDir;
                if(currCount > existing.maxCount) {
                    newMaxCount = currCount;
                    newDir = currDir;
                } else {
                    newMaxCount = existing.maxCount;
                    newDir = existing.d;
                }
                map[x][y] = new Node(x, y, newTotal, newMaxCount, newDir);
            }
        }
    }
 
 
 
    private static class Node{
        int x;
        int y;
        int microorganism;
        int maxCount;
        int d;
 
        Node(int x, int y, int microorganism, int maxCount, int d){
            this.x = x;
            this.y = y;
            this.microorganism = microorganism;
            this.maxCount = maxCount;
            this.d = d;
        }
    }
}