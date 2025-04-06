import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 int sum = 0;
		 int max = 0;
		 int[] guitarVideo = new int[N];
		 
		 st = new StringTokenizer(br.readLine());
		 for(int i=0; i<N; i++) {
			 guitarVideo[i] = Integer.parseInt(st.nextToken());
			 sum += guitarVideo[i];
			 max = Math.max(guitarVideo[i], max);
		 }
		 
		 bluRaySize(guitarVideo, M, sum, max);
	}

	private static void bluRaySize(int[] guitarVideo, int M, int sum, int max) {
		int start = max;
		int end = sum;
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;	
			int check = isPossible(guitarVideo, mid);
			
			if(check <= M) {
				result = mid;
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(result);
	}

	private static int isPossible(int[] guitarVideo, int mid) {
		int count = 1;
		int sum = 0;
		
		for(int i=0; i<guitarVideo.length; i++) {
			if(sum + guitarVideo[i] > mid) {
				count++;
				sum = guitarVideo[i];
			}else {
				sum += guitarVideo[i];
			}
		}
		return count;
	}
}