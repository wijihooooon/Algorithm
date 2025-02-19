import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] p;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Node[] node = new Node[E];
        p = new int[V+1];
        Arrays.fill(p, -1);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            node[i] = new Node(a, b, cost);
        }

        Arrays.sort(node);

        int cnt = 0;
        int ans = 0;

        for(int i=0; i<E; i++){
            int a = node[i].a;
            int b = node[i].b;
            int cost = node[i].cost;

            if(!union(a, b)) continue;
            ans += cost;
            cnt++;

            if(cnt == V-1) break;
        }
        System.out.println(ans);
    }
    private static int find(int x){
        if(p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    private static boolean union(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v) return false;

        if(p[u] == p[v]){
            p[u]--;
        }

        if(p[u]<p[v]){
            p[v] = u;
        }else{
            p[u] = v;
        }
        return true;
    }

    private static class Node implements Comparable<Node>{
        int a;
        int b;
        int cost;

        @Override
        public int compareTo(Node node) {
         return Integer.compare(this.cost, node.cost);
        }

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}