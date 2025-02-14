import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 정점 개수
            int M = Integer.parseInt(st.nextToken()); // 간선 게수
            int S = Integer.parseInt(st.nextToken()); // 시작 정점
            int C = Integer.parseInt(st.nextToken()); // 도착 정점

            if(N == 0 && M == 0 && S == 0 && C == 0){
                break;
            }
            // 인접 리스트
            ArrayList<Node>[] graph = new ArrayList[N+1];
            // 최소 비용 배열
            int[] D = new int[N+1];
            // 방문 확인 배열
            boolean[] visited = new boolean[N+1];

            // 인접 리스트 및 최소 비용 배열 초기화
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<>();
                D[i] = Integer.MAX_VALUE;
            }

            // 인접 리스트에 정점 사이 간선 가중치 삽입
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(new Node(v, w));
            }
            
            PriorityQueue<Node> pq = new PriorityQueue<>();
            // 시작지점 비용 0 및 pq에 삽입
            D[S] = 0;
            pq.add(new Node(S, 0));

            while(!pq.isEmpty()){
                Node now = pq.poll();

                if(!visited[now.network]){
                    visited[now.network] = true;

                    for(Node n : graph[now.network]){
                        if(!visited[n.network] && D[n.network] > D[now.network] + n.cost){
                            D[n.network] = D[now.network] + n.cost;
                            pq.add(new Node(n.network, D[n.network]));
                        }
                    }
                }
            }
            System.out.println(D[C]);
        }

    }
    private static class Node implements Comparable<Node>{
        int network;
        int cost;

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }

        public Node(int network, int cost) {
            this.network = network;
            this.cost = cost;
        }
    }
}
