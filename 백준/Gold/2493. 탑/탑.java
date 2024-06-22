import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tower[] = new int[N];
		int ans[] = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && tower[stack.peek()] <= tower[i]) {
				stack.pop();
			}
			if(!stack.isEmpty() && tower[stack.peek()] > tower[i]) {
				ans[i] = stack.peek()+1;
			}
			
			stack.push(i);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}

}
