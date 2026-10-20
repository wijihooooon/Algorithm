import java.util.*;

class Solution {
    
    public static List<Node> graph[];
    
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<fares.length; i++){
            graph[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            graph[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }
        
        int distS[] = cal(n, s);
        int distA[] = cal(n, a);
        int distB[] = cal(n, b);
        
        
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }      
        
        return answer;
    }
    
    public int[] cal(int n, int start){
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int vertex = node.vertex;
            int cost = node.cost;
            
            for(int i=0; i<graph[vertex].size(); i++){
                Node nextNode = graph[vertex].get(i);
                
                if(dist[nextNode.vertex] > dist[vertex] + nextNode.cost){
                    dist[nextNode.vertex] = dist[vertex] + nextNode.cost;
                    pq.add(nextNode);
                }
            }
        }
        
        return dist;
    }
    
    public class Node{
        int vertex;
        int cost;
        
        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}