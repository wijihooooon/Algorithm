import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer>Deque = new ArrayDeque<>();
		
		for(int j=0; j<N; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s) {
			case "push_front":
				Deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				Deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(Deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(Deque.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if(Deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(Deque.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(Deque.size()).append("\n");
				break;
			case "empty":
				if(Deque.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				break;
			case "front":
				if(Deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(Deque.peekFirst()).append("\n");
				}
				break;
			case "back":
				if(Deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(Deque.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}