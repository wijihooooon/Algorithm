import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	public static int arr[];
	public static int num[];
	public static boolean isused[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		num = new int[N];
		isused = new boolean[10001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		func(0);
		
	}

	private static void func(int x) {
		if(x == M) {
			for(int i=0; i<M; i++) {
				System.out.print(num[arr[i]] + " ");
			}
			System.out.println();
			return;
		}
		
		int st = 0;
		if(x != 0) {
			st = arr[x-1];
		}
		for(int i=st; i<N; i++) {
			arr[x] = i;
			func(x+1);
		}
	}
}