import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N > K) {
			sb.append(N-K).append("\n");
			for(int i=N; i>=K; i--) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		boolean[] visited = new boolean[100001];
		
		ArrayDeque<Subin> q = new ArrayDeque<>();
		Subin now = new Subin(N, new ArrayList<>());
		now.path.add(now.pos);
		visited[now.pos] = true;
		q.add(now);
		
		while(true) {
			now = q.poll();
			if(now.pos == K) break;
			
			if(now.pos*2 <= 100000 && !visited[now.pos*2]) {
				q.add(new Subin(now.pos*2, new ArrayList<>(now.path)));
				visited[now.pos*2] = true;
				q.peekLast().path.add(now.pos*2);
			}
			
			if(now.pos-1 >=0 && !visited[now.pos-1]) {
				q.add(new Subin(now.pos-1, new ArrayList<>(now.path)));
				visited[now.pos-1] = true;
				q.peekLast().path.add(now.pos-1);
			}
			
			if(now.pos+1 <= 100000 && !visited[now.pos+1]) {
				q.add(new Subin(now.pos+1, new ArrayList<>(now.path)));
				visited[now.pos+1] = true;
				q.peekLast().path.add(now.pos+1);
			}
		}

		sb.append(now.path.size() - 1).append("\n");
		
		for(int i=0; i<now.path.size(); i++) {
			sb.append(now.path.get(i) + " ");
		}		
		System.out.println(sb);
	}

	private static class Subin{
		int pos;
		List<Integer> path = new ArrayList<>();
		
		Subin(int pos, List<Integer> path){
			this.pos = pos;
			this.path = path;
		}
	}
}