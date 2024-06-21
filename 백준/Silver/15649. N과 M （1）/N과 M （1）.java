import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int arr[];
	public static boolean isused[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[10];
		isused = new boolean[10];
		func(0);
	}

	private static void func(int a) {
		if(a==M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!isused[i]) {
				arr[a] = i;
				isused[i] = true;
				func(a + 1);
				isused[i] = false;
			}
			
		}
	}
}
