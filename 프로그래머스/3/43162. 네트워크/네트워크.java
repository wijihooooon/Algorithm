import java.util.*;

class Solution {
    
    public List<Integer>[] graph;
    public boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        graph = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[0].length; j++){
                if(i==j ||computers[i][j] == 0) continue;
                
                graph[i].add(j);
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (visited[next]) continue;
                
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}