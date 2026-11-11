import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int cost = r[2];

            // 양방향 도로
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        int[] dist = dijkstra(graph);
        return countReachableVillages(dist, K);
    }

    private int[] dijkstra(ArrayList<Node>[] graph) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.cost, b.cost)
        );
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 더 짧은 경로가 이미 발견됐으면 이전 기록은 건너뜁니다.
            if (current.cost > dist[current.vertex]) {
                continue;
            }

            for (Node next : graph[current.vertex]) {
                // 현재까지 걸린 시간 + 다음 도로를 지나는 시간
                int newCost = current.cost + next.cost;

                if (newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;

                    // 그래프의 도로 가중치는 그대로 두고,
                    // 누적 시간을 담은 새 객체를 큐에 넣습니다.
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }

        return dist;
    }

    private int countReachableVillages(int[] dist, int K) {
        int answer = 0;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private static class Node {
        final int vertex;
        final int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}