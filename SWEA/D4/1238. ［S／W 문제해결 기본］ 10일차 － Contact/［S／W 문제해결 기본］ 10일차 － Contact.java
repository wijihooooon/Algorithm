import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken())/2;
			int K = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] list = new ArrayList[101];
			boolean[] visited = new boolean[101];
			
			for(int i=0; i<101; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			q.add(K);
			visited[K] = true;
			
			int max = Integer.MIN_VALUE;
			while(!q.isEmpty()) {
				int size = q.size();
				max = 0;
				for(int i=0; i<size; i++) {
					int now = q.poll();
					max = Math.max(max, now);
					for(int j=0; j<list[now].size(); j++) {
						if(visited[list[now].get(j)]) continue;
						visited[list[now].get(j)] = true;
						q.add(list[now].get(j));
					}
				}
			}			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}