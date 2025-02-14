import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // 마을 수 (정점)
        int C = Integer.parseInt(st.nextToken()); // 도로 수 (간선)
        int Ts = Integer.parseInt(st.nextToken()); // 출발하는 마을
        int Te = Integer.parseInt(st.nextToken()); // 도착하는 마을

        // 인접 리스트
        ArrayList<Node>[] graph = new ArrayList[T+1];
        // 최소 비용 배열
        int[] D = new int[T+1];
        boolean[] visited = new boolean[T+1];

        for(int i=1; i<=T; i++){
            graph[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(Ts, 0));
        D[Ts] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visited[now.town]){
                visited[now.town] = true;

                for(Node n : graph[now.town]){
                    if(!visited[n.town] && D[n.town] > now.cost + n.cost){
                        D[n.town] = now.cost + n.cost;
                        pq.add(new Node(n.town, D[n.town]));
                    }
                }
            }
        }
        System.out.println(D[Te]);
    }

    private static class Node implements Comparable<Node>{
        int town;
        int cost;

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }

        public Node(int town, int cost) {
            this.town = town;
            this.cost = cost;
        }
    }
}
