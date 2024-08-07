import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 1, 2, 3을 가지고 N을 만드는데 만들 수 있는 수의 조합을 사전순으로 나열 했을때 K번째 를 출력
 * */
public class Main {

	public static int N, K;
	public static ArrayList<String> list = new ArrayList<>();
	
	public static int arr[] = {1, 2, 3};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 만들어야 하는 수
		K = Integer.parseInt(st.nextToken()); // 사전 기준 K 번째
		
		OneTwoThreePlus(0, "");
		Collections.sort(list);
		
		if(K > list.size()) {
			System.out.println(-1);
			return;
		}
		
		String ans = list.get(K-1);
		for(int i=0; i<ans.length(); i++) {
			System.out.print(ans.charAt(i));
			if(i == ans.length()-1) continue;
			System.out.print("+");
		}
	}
    // 1, 2, 3으로 만들 수 있는 모든 경우의 수를 만들고 더햇을때 합이 N이면 list에 추가
	private static void OneTwoThreePlus(int sum, String str) {
		if(sum == N) {
			list.add(str);
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(sum + arr[i]<=N) {
				sum += arr[i];
				str += Integer.toString(arr[i]);
				OneTwoThreePlus(sum, str);
				sum -= arr[i];
				str = str.substring(0,str.length()-1);
			}else {
				return;
			}
		}
	}

}
