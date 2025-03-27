import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        double ans = 0;
        int[] X;
        int[] Y;
        PriorityQueue<Edge> q;

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            X = new int[N];
            Y = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                X[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                Y[i] = Integer.parseInt(st.nextToken());
            }

            double L = Double.parseDouble(br.readLine());

            parent = new int[N];
            rank = new int[N];

            for(int i=0; i<N; i++){
                parent[i] = i;
            }

            q = new PriorityQueue<>();

            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    int dx = X[i] - X[j];
                    int dy = Y[i] - Y[j];
                    long dis = (long) dx * dx + (long) dy * dy;

                    q.add(new Edge(i, j, dis));
                }
            }
            ans = 0;
            while(!q.isEmpty()){
                Edge now = q.poll();

                if(find(now.from) != find(now.to)){
                    union(now.from, now.to);
                    ans+=now.weight;
                }
            }
            sb.append("#").append(t).append(" ").append(Math.round(ans * L)).append('\n');
        }
        System.out.println(sb);
    }

    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y){
        int nx = find(x);
        int ny = find(y);

        if(nx == ny) return;

        if(rank[nx]< rank[ny]){
            parent[nx] = ny;
        }else if(rank[nx] > rank[ny]){
            parent[ny] = nx;
        }else{
            parent[ny] = nx;
            rank[nx]++;
        }
    }

    private static class Edge implements Comparable<Edge>{
        int from;
        int to;
        long weight;

        @Override
        public int compareTo(Edge e) {
            return Double.compare(weight, e.weight);
        }

        Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}