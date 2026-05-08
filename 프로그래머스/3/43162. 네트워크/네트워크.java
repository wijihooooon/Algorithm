import java.util.*;

class Solution {
    
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static Deque<Integer> dq;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        graph = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            int a = i;
            for(int j=0; j<n; j++){
                if(i == j || computers[i][j] == 0) continue; // 자기 자신이거나 연결되어있지않으면 x
                int b = j;
                
                graph[a].add(b);
                graph[b].add(a);
                
            }
        }
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            answer++;
            visited[i] = true;
            bfs(i);
        }
        return answer;
    }
    
    public void bfs(int node){
        dq = new ArrayDeque<>();
        dq.addFirst(node);
        
        while(!dq.isEmpty()){
            int now = dq.pollFirst();
            
            for(int i=0; i<graph[now].size(); i++){
                int nextNode = graph[now].get(i);
                
                if(visited[nextNode]) continue;
                
                visited[nextNode] = true;
                dq.addLast(nextNode);
            }
        }      
    }
    
}