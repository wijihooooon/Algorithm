import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        int count = 0;
        
        for(int[] edge : costs){
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            if(union(a, b)){
                answer += cost;
                count++;
            }
            
            if(count == n-1) break;
        }
        
        return answer;
    }
    
    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return false;
        
        parent[rootB] = rootA;
        return true;
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
}