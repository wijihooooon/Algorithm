import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 나보다 작은 상어중 큰애를 잡아먹기
 * */
public class Main {

	public static int N, K, T;
	public static long size;
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 존재하는 상어 수
		K = Integer.parseInt(st.nextToken()); // 잡아 먹을 수 있는 상어의 수
		T = Integer.parseInt(st.nextToken()); // 내 상어 크기
		
		// 상어를 ArrayList에 넣어 먹을떄마다 삭제
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);

		// 최종 사이즈
		size = T;

		for(int i=0; i<K; i++) {
			size += lunchTime();
		}
		System.out.println(size);
	}
// 이분탐색을 활용해서 현재 사이즈 바로 아래 상어를 탐색
	private static int lunchTime() {
		// 만약 첫번째 먹이용 상어가 더 크거나 상어가 없으면 0 반환하고 종료
		if(list.size() == 0 || list.get(0) >= size) {
			return 0;
		}

		int start = 0;
		int end = list.size()-1;
		
		while(start<=end) {
			int mid = (start + end) / 2;

			if(list.get(mid) < size) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return list.remove(end);
	}

}
