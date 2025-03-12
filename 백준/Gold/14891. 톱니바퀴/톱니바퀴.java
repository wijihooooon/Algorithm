import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static LinkedList<Integer>[] machine;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		machine = new LinkedList[4];
		
		for(int i=0; i<4; i++) {
			machine[i] = new LinkedList<>();
		}
		
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				machine[i].add(str.charAt(j) - '0');
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()) - 1; // 회전할 바퀴
			int d = Integer.parseInt(st.nextToken()); // 회전 방향 -1: 좌, 1: 우
			
			int nowLeft = machine[N].get(6);
			int nowRight = machine[N].get(2);
			
			int direction = -d;
			// 왼쪽
			for(int i=N-1; i>=0; i--) {
				if(machine[i].get(2) == nowLeft) {
					break;
				}
				nowLeft = machine[i].get(6);
				roll(i, direction);
				direction = -direction;
			}
			
			nowLeft = machine[N].get(6);
			nowRight = machine[N].get(2);
			
			// 오른쪽
			direction = -d;
			for(int i=N+1; i<4; i++) {
				if(machine[i].get(6) == nowRight) {
					break;
				}
				nowRight = machine[i].get(2);
				roll(i, direction);
				direction = -direction;
			}
			// 기준
			roll(N, d);
		}
		
		int sum = 0;
		int mul = 1;
		for(int i=0; i<4; i++) {
			if(machine[i].getFirst() == 1) {
				sum+= mul;
			}
			mul *= 2;
		}
		System.out.println(sum);
	}

	private static void roll(int i, int d) {
		if(d == -1) {
			machine[i].addLast(machine[i].removeFirst());
		}else {
			machine[i].addFirst(machine[i].removeLast());
		}
	}
}