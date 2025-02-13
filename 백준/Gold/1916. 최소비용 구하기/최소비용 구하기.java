import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 도시 개수 (정점)
        int M = Integer.parseInt(br.readLine()); // 버스 개수 (간선)

        // 인접 리스트
        ArrayList<Node>[] graph = new ArrayList[N+1];
        // 최단 거리 배열
        int[] D = new int[N+1];
        // 방문 배열
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<=N; i++) {
            // 인접 리스트 배열 초기화
            graph[i] = new ArrayList<>();
            // 인덱스 값 가장 큰 값으로 초기화
            D[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 도시
            int v = Integer.parseInt(st.nextToken()); // 도착 도시
            int w = Integer.parseInt(st.nextToken()); // 비용
            graph[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());

        int startCity = Integer.parseInt(st.nextToken()); // 시작 도시
        int endCity = Integer.parseInt(st.nextToken());	  // 도착 도시

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작도시 비용을 0으로 설정
        D[startCity] = 0;
        // 시작 도시 큐에 삽입
        pq.add(new Node(startCity, 0));

        while(!pq.isEmpty()) {
            // 현재 가장 비용이 작은 노드 꺼내기
            Node now = pq.poll();

            if(!visited[now.toNode]){
                visited[now.toNode] = true;
                for(Node node : graph[now.toNode]) {
                    if(!visited[node.toNode] && D[node.toNode] > now.e + node.e){
                        D[node.toNode] = now.e + node.e;
                        pq.add(new Node(node.toNode, D[node.toNode]));
                    }
                }
            }
        }
        System.out.println(D[endCity]);

    }
    private static class Node implements Comparable<Node> {
        int toNode; // 현재 도시
        int e;		// 비용

        // 비용이 작은 도시 선정
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.e - o.e;
        }

        public Node(int toNode, int e) {
            this.toNode = toNode;
            this.e = e;
        }
    }
}
