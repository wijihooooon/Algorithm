import java.util.*;
import java.io.*;

public class Solution{
    
    public static int[] parent;
    
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
            sb.append("#").append(t).append(" ");
            
        	st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            parent = new int[V+1];
            for(int i=1; i<=V; i++){
                parent[i] = i;
            }
            
            int costs[][] = new int[E][3];
			for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++){
                	costs[i][j] = Integer.parseInt(st.nextToken());
                }
        	}
            
            Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
            
            int count = 0;
            long answer = 0;
            for(int[] edge : costs){
            	int a = edge[0];
                int b = edge[1];
                int cost = edge[2];
                
                if(union(a, b)){
                    answer += cost;
                    count++;
                }
                
                if(count == V-1) break;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
	}
    
    public static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return false;
        parent[rootB] = rootA;
        
        return true;
    }
    
    public static int find(int x){
    	if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}