import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		int arr[] = new int[5];
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		//선택 정렬
		for(int i=0; i<4; i++) {
			int index = i;
			
			for(int j=i+1; j<5; j++) {
				if(arr[j] < arr[index]) {
					index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
			
		}
		
		sb.append(sum/5).append("\n").append(arr[2]);
		System.out.println(sb);
	}

}
