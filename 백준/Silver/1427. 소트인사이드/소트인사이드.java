import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		int arr[] = new int[s.length()];
		
		for(int i=0; i<s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
		}
		
		for(int i=0; i<arr.length-1; i++) {
			int max = i;
			
			for(int j = i+1; j<arr.length; j++) {
				if(arr[j] > arr[max]) {
					max = j;
				}
			}
			
			int change = arr[i];
			arr[i] = arr[max];
			arr[max] = change;
			
			sb.append(arr[i]);
		}
		sb.append(arr[arr.length-1]);
		System.out.println(sb);
	}
}
