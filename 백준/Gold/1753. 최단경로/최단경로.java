import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        int K = Integer.parseInt(br.readLine());  // 시작 정점

        //인접리스트
        ArrayList<Node>[] grape = new ArrayList[V+1];
        //최단거리배열
        int[] D = new int[V + 1];
        //방문배열
        boolean[] visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
        	//인접리스트 배열 초기화
            grape[i] = new ArrayList<>();
            //인덱스 값 무한대로 초기화
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 정점
            int v = Integer.parseInt(st.nextToken()); // 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치
            grape[u].add(new Node(v, w));
        }

        //다익스트라 -> 우선순위 큐
        PriorityQueue<Node> que = new PriorityQueue<>();
        
        //시작 정점의 최단 거리를 0으로 설정하고 큐에 삽입
        D[K] = 0;
        // 시작 노드 삽입
        que.offer(new Node(K, 0));

        while (!que.isEmpty()) {
        	// 현재 가장 최단 거리가 짧은 노드 꺼내기
            Node now = que.poll();
            
            // 현재 노드 방문으로 처리
            visited[now.toNode] = true;
            
            // 현재 노드와 연결된 모든 인접 노드 탐색
            for (Node node : grape[now.toNode]) {
            	// 방문하지 않은 경우만
                if (!visited[node.toNode]) {
                	// 더 짧은 경로를 찾으면 업데이트
                    if (D[now.toNode] + node.e < D[node.toNode]) {
                        D[node.toNode] = D[now.toNode] + node.e;
                        // 갱신된 값을 우선순위 큐에 삽입
                        que.offer(new Node(node.toNode, D[node.toNode]));
                    }
                }
            }
         }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (D[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n"); // 도달할 수 없는 경우 INF 출력
            } else {
                sb.append(D[i]).append("\n"); // 최단거리 출력
            }
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int toNode; // 도착 정점
        int e; 		// 가중치

        // 가중치가 작은 순서대로 정렬
        @Override
        public int compareTo(Node o){
            return this.e - o.e; // 오름차순 정렬
        }

        public Node(int toNode, int e) {
            this.toNode = toNode;
            this.e = e;
        }
    }
}