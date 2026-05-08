import java.util.*;

class Solution {
    
    public static List<Integer>[] graph;
    public static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
    
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int[] wire : wires){
            visited = new boolean[n+1];
            
            int cutA = wire[0];
            int cutB = wire[1];
            
            int count = dfs(cutA, cutA, cutB);
            
            int other = n - count;
            
            int diff = Math.abs(count - other);
            
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    public int dfs(int node, int cutA, int cutB){
        visited[node] = true;
        
        int count = 1;
        
        for(int next : graph[node]){
            if(visited[next]){
                continue;
            }
            
            if((node == cutA && next == cutB)||
               (node == cutB && next == cutA)){
                continue;
            }
            
            count += dfs(next, cutA, cutB);
        }
        
        return count;
    }
}