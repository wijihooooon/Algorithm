// stack을 활용해서 품
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			
			switch(s) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.empty()) {
					sb.append("-1").append("\n");
					break;
				}else {
					sb.append(stack.pop()).append("\n");
					break;
				}
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				if(stack.empty()) {
					sb.append("1").append("\n");
					break;
				}else {
					sb.append("0").append("\n");
					break;
				}
			case "top":
				if(stack.empty()) {
					sb.append("-1").append("\n");
					break;
				}else {
					sb.append(stack.peek()).append("\n");
					break;
				}
			}	
		}
		System.out.println(sb);
	}
}
