import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int j=0; j<K; j++) {
			int N = Integer.parseInt(br.readLine());
			if(N != 0) {
				stack.push(N);
			}else {
				stack.pop();
			}
		}
		
		int sum = 0;
		
		while(!stack.empty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}
