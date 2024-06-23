import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static int arr[];
	public static boolean isused[];
	public static int num[];
	public int check = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isused = new boolean[10001];
		arr = new int[10];
		num = new int[N];
		
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
		
		int temp = -1;
		
		for(int i=0; i<N; i++) {
			if(!isused[i] && num[i] != temp) {
				arr[x] = i;
				isused[i] = true;
				temp = num[arr[x]];
				func(x+1);
				isused[i] = false;
			}
		}
	}
}