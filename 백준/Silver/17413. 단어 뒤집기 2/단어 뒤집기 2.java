import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		boolean check = false;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				check = true;
				System.out.print('<');
			}else if(check) {
				while(s.charAt(i) != '>') {
					System.out.print(s.charAt(i));
					i++;
				}
				System.out.print(s.charAt(i));
				check = false;
			}else if(s.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(' ');
			}else {
				stack.push(s.charAt(i));
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}