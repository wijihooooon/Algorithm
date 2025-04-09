import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(arr[0]);
			for(int i=1; i<N; i++) {
				if(arr[i] > list.get(list.size()-1)) {
					list.add(arr[i]);
				}else {
					int idx = Collections.binarySearch(list, arr[i]);
					if(idx < 0) idx = -idx-1;
					list.set(idx, arr[i]);
				}
			}
			sb.append("#").append(t).append(" ").append(list.size()).append("\n");
		}
		System.out.println(sb);
	}
}