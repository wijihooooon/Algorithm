import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
// 1. 점화식 구하기
// 2. 초기값 지정하기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[12];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int j=4; j<=11; j++) {
			arr[j] = arr[j-3] + arr[j-2] + arr[j-1];
		}
		
		for(int j=0; j<T; j++) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}
	}

}