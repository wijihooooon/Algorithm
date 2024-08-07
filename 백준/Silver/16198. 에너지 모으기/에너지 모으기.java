import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 에너지 구슬이 다음과 같이 있을 경우(첫 번째와 마지막 구슬은 고를 수 없음)
 * 1 2 3 4 -> 3을 제거하면 2*4의 에너지를 얻고 1 2 4가된다.
 * 이후 2를 제거하면 1*4 의 에너지를 얻게 되고 1 2가 되므로 종료
 * 총 얻을 수 있는 에너지는 12
 * */
public class Main {

	public static int N, max;
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N 값
		N = Integer.parseInt(br.readLine());
		
		// 값 삽입
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Energy(0);
		
		System.out.println(max);
	}

	private static void Energy(int sum) {
		// list에 첫번째 값과 마지막 값만 남았을때 최대값 계산
		if(list.size() == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		// list를 0과 list.size()-1을 제외하고 돌며 값을 더함
		for(int i=1; i<list.size()-1; i++) {
			sum += list.get(i-1) * list.get(i+1);
			int temp = list.remove(i);
			Energy(sum);
			list.add(i, temp);
			sum -= list.get(i-1) * list.get(i+1);
		
		}
	}
}
