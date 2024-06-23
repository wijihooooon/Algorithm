import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int num[];
	public static boolean check[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			}
			
			num = new int[N];
			
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			check = new boolean[N];
			func(0, 0);
			System.out.println();
		}
	}
	private static void func(int x, int st) {
		if(x == 6) {
			for(int i=0; i<N; i++) {
				if(check[i]) {
					System.out.print(num[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		for(int i=st; i<N; i++) {
			check[i] = true;
			func(x+1, i+1);
			check[i] = false;
		}
		
	}

}
