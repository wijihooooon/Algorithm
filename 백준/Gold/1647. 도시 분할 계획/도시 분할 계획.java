import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] edge = new Node[M];
        p = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edge[i] = new Node(u,v,cost);
        }

        Arrays.sort(edge);
        Arrays.fill(p, -1);

        int ans = 0;
        int max = 0;
        for(int i=0; i<M; i++){
            int u = edge[i].from;
            int v = edge[i].to;
            int cost = edge[i].cost;

            if(!union(u, v)) continue;
            max = Math.max(max, cost);
            ans += cost;
        }
        System.out.println(ans - max);
    }

    private static int find(int x){
        if(p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    private static boolean union(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v) return false;

        if (p[u] == p[v]) {
            p[u]--;
        }

        if(p[u] < p[v]){
            p[v] = u;
        }else{
            p[u] = v;
        }
        return true;
    }

    private static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
