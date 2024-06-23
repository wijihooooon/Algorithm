import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int N;

	public static boolean isused1[]; // 세로
	public static boolean isused2[]; // 우하
	public static boolean isused3[]; // 우상
	
	public static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		isused1 = new boolean[30];
		isused2 = new boolean[30];
		isused3 = new boolean[30];
		count = 0;
		func(0);
		System.out.println(count);
	}

	private static void func(int x) {
		if(x == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isused1[i] || isused2[x-i+N-1] || isused3[i+x]) {
				continue;
			}
			isused1[i] = true;
			isused2[x-i+N-1] = true;
			isused3[i+x] = true;
			func(x+1);
			isused1[i] = false;
			isused2[x-i+N-1] = false;
			isused3[i+x] = false;
		}
	}

}