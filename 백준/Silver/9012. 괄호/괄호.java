import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Character> stack = new Stack<>();
		
		for(int j=0; j<N; j++) {
			String s = br.readLine();
			
			for(int k=0; k<s.length();k++) {
				char c = s.charAt(k);
				
				if(!stack.empty() && stack.peek() != c && stack.peek() == '(') {
					stack.pop();
				}else {
					stack.push(c);
				}
			}
			
			if(stack.empty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			stack.clear();
		}
	}

}