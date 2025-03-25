import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			long ans = 0;
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			while(pq.size()>1) {
				long temp = pq.poll() + pq.poll();
				pq.add(temp);
				ans += (long) temp;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
/*
 * 풀이 아이디어
 * pq를 활용해서 최소 값 끼리 더하기
 * 
 */