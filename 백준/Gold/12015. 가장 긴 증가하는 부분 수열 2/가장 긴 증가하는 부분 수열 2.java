import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			LIS(list, Integer.parseInt(st.nextToken()));
		}
		System.out.println(list.size());
	}

	private static void LIS(ArrayList<Integer> list, int num) {
		int start = 0;
		int end = list.size();
		
		while(start<end) {
			int mid = (start + end) / 2;
			
			if(list.get(mid) >= num) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		
		if(start < list.size()) {
			list.set(start, num);
		} else {
			list.add(num);
		}
	}
}