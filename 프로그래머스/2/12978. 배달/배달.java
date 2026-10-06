import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int dist[] = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        List<Node> graph[] = new ArrayList[N + 1];
        
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            graph[road[i][0]].add(new Node(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            if(node.cost > dist[node.vertex]){
                continue;
            }
            
            for(Node next : graph[node.vertex]){
                
                int newCost = node.cost + next.cost;
                
                if (newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.offer(new Node(next.vertex, newCost));
                }
            }
        }
        
        for(int i=1; i<dist.length; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
            
        return answer;
    }
    
    class Node {
        int vertex;
        int cost;
        
        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}