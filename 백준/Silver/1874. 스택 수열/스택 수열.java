import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int current = 1;
		for(int j=1; j<=N; j++) {
			int target = Integer.parseInt(br.readLine());
			
			while(current <= target) {
				stack.push(current);
				sb.append("+").append("\n");
				current++;
			}
			
			if(!stack.empty() && stack.peek() == target) {
				stack.pop();
				sb.append("-").append("\n");
			}
				
			
		}
		if(stack.empty()) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		
	}
}