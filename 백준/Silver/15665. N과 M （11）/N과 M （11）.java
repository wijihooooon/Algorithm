import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static int num[];
	public static int arr[];
	public static boolean isused[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		arr = new int[N];
		isused = new boolean[10001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		func(0);
        
        System.out.println(sb);
        
	}

	private static void func(int x) {
		if(x == M) {
			for(int i=0; i<M; i++) {
				sb.append(num[arr[i]]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int temp = -1;
		
		for(int i=0; i<N; i++) {
			if(temp != num[i]) {
				arr[x] = i;
				temp = num[i];
				func(x+1);
			}
		}
	}
}