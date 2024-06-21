import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	// 고른 수열은 오름차순이어야 한다
	public static int N, M;
	
	public static int arr[];
	public static boolean visited[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken()); // 1~N
		M = Integer.parseInt(st.nextToken()); // 고르는 수열 개수
	
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		backTracking(0);
		System.out.println(sb);
	}

	private static void backTracking(int cnt) {
        // cnt == M이면 출력 이후 return
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
        int st = 1;
		// cnt가 0이 아니면 arr[cnt-1] + 1 해 전 값에 +1부터 시작
		if(cnt != 0) {
			st = arr[cnt-1] + 1;
		}
		
		for(int i=st; i<=N; i++) {
			if(!visited[i]) {
				arr[cnt] = i;
				visited[i] = true;
				backTracking(cnt+1);
				visited[i] = false;
			}
		}
	}

}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1560_2 {
   
	public static int n, r;
    public static int[] arr; // 원소를 저장할 배열
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[r];
        
        combination(0,1);
        System.out.println(sb);
    }
	// 조합
    private static void combination(int cnt, int start) {
        if (cnt == r) {
        	for(int i=0; i<r; i++) {
        		sb.append(arr[i]).append(" ");
        	}
        	sb.append("\n");
        	return;
        }
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i + 1); // 오름차순으로 구하면 중복 체크하지 않아도 됨
        }
    }
}
*/
