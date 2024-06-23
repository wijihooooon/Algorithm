import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			stack.add(Integer.parseInt(br.readLine()));
		}
		
		int front = stack.pop(); // 처음 보는 막대
		int count = 1; // 갯수
		int stick = 0;
		
		while(!stack.isEmpty()) { // 스택이 빌떄까지
			stick = stack.pop();
			if(front < stick) { // 처음 막대보다 크면 +1
				count++;
				front = stick;
			}
		}
		System.out.println(count);
	}

}
