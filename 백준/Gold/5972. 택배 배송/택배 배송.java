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

        int N = Integer.parseInt(st.nextToken()); // 헛간 개수
        int M = Integer.parseInt(st.nextToken()); // 길 개수

        // 인접 리스트 생성
        ArrayList<Node>[] graph = new ArrayList[N + 1];
        // 최단 거리 배열
        int[] D = new int[N+1];
        // 방문 배열
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 헛간에서 양방향으로 갈 수 있기 떄문에 양방향 처리를 해주어야함.
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작지점 비용 0으로 설정
        D[1] = 0;
        // 시작 지점 pq에 삽입
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            // 현재 가장 비용이 작은 노드 꺼내기
            Node now = pq.poll();

            // 방문 하지 않은 노드 처리
            if(!visited[now.barn]){
                // 방문한 노드로 체크
                visited[now.barn] = true;
                for(Node node : graph[now.barn]){
                    // 현재 노드 + 인접 노드의 비용 기존 저장된 노드의 비용보다 적으면 현재 노드 + 인접 노드의 비용을 저장 하고 pq에 저장
                    if(!visited[node.barn] && D[node.barn] > now.stover + node.stover){
                        D[node.barn] = now.stover + node.stover;
                        pq.add(new Node(node.barn, D[node.barn]));
                    }
                }
            }
        }
        System.out.println(D[N]);
    }

    private static class Node implements Comparable<Node>{
        int barn; // 헛간(정점)
        int stover; // 여물(가중치)

        // 작은거 반환
        @Override
        public int compareTo(Node node) {
            return this.stover - node.stover;
        }

        public Node(int barn, int stover) {
            this.barn = barn;
            this.stover = stover;
        }
    }
}
