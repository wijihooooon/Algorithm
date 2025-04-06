import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree);
		cutTheTree(tree, M);
	}

	private static void cutTheTree(int[] tree, int M) {
		int start = 0;
		int end = tree[tree.length-1];
		int result  = 0;
		
		while(start<=end) {
			int mid = (start + end) / 2;
			
			if(isPossible(tree, mid, M)) {
				result = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean isPossible(int[] tree, int mid, int M) {
		long sum = 0;
		
		for(int h : tree) {
			if(h>mid) {
				sum += h - mid;
			}
		}
		
		return sum >= M;
	}
}