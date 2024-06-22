import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		
		int a = 1;
		int b = 0;
		
		if(N == 1) {
			
			a = Integer.parseInt(br.readLine());
			
		}else {
			
			int stair[][] = new int[N+1][3];
			
			a = Integer.parseInt(br.readLine());
			
			stair[1][1] = a;
			stair[1][2] = a;
			
			b = Integer.parseInt(br.readLine());
			
			stair[2][1] = b;
			stair[2][2] = stair[1][1] + b;
			
			for(int j=3; j<=N; j++) {
				int num = Integer.parseInt(br.readLine());
				
				a = stair[j-2][1];
				b = stair[j-2][2];
				
				stair[j][1] = Math.max(a, b) + num;
				stair[j][2] = stair[j-1][1] + num;
			}
			
			a = stair[N][1];
			b = stair[N][2];
		}
		
		ans = Math.max(a, b);
		
		System.out.println(ans);
	}

}