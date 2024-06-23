import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer>q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		
		while(!q.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				q.add(q.poll());
			}
			list.add(q.poll());
		}
		
		sb.append("<");
		for(int i=0; i<list.size()-1; i++) {
			sb.append(list.get(i));
			sb.append(", ");
		}
		sb.append(list.get(list.size()-1)).append(">");
		System.out.println(sb);
	}

}
