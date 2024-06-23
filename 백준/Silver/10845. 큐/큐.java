import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] queue = new int[10001];
	static int front = 0;
	static int rear = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int j=0; j<N; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			switch(s) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	private static void push(int num) {
		queue[rear] = num;
		rear++;
	}
	
	private static int pop() {
		if(rear - front == 0) {
			return -1;
		}else {
			front++;
			return queue[front - 1];
		}
	}
	
	private static int size() {
		return rear - front;
	}
	
	private static int empty() {
		if(rear - front == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	private static int front() {
		if(rear - front == 0) {
			return -1;
		}else {
			return queue[front];
		}
	}
	
	private static int back() {
		if(rear - front == 0){
			return -1;
		}else {
			return queue[rear - 1];
		}
	}
}
