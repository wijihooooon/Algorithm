import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int n, m;
    
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    
    public static int box[][];
    
    public static Deque<int[]> q = new ArrayDeque<>();
    
	public static void main (String[] args) throws java.lang.Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    m = Integer.parseInt(st.nextToken());
	    n = Integer.parseInt(st.nextToken());
	    
	    int greenTomato = 0;
	    
	    box = new int[n][m];
	    
	    for(int i=0; i<n; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<m; j++){
	            box[i][j] = Integer.parseInt(st.nextToken());
	            if(box[i][j] == 0) {
	                greenTomato++;
	                continue;
	            }
	            if(box[i][j] == 1) q.add(new int[] {i, j});
	        }
	    }
	    
	    calc(greenTomato);
	    
	}
	public static void calc(int greenTomato){
	    
	    if (greenTomato == 0) {
        System.out.println(0);
        return;
    }
    
        int date = 1;

	    while(!q.isEmpty()){
	        int x = q.peek()[0];
	        int y = q.peek()[1];
	        q.poll();
	        
	        for(int i=0; i<4; i++){
	            int cx = x + dx[i];
	            int cy = y + dy[i];
	            
	            if(cx<0 || cy<0 || cx>=n || cy>=m) continue;
	            if(box[cx][cy] != 0) continue;
	            
	            q.add(new int[] {cx, cy});
	            box[cx][cy] = box[x][y] + 1;
	            date = Math.max(date, box[cx][cy]);
	            greenTomato--;
	        }
	    }
	    
	    if(greenTomato != 0){
	        System.out.println(-1);
	    }else{
	        System.out.println(date-1);
	    } 
	}
}