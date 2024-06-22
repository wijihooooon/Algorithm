import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1[] = new int[9];
		int num2[] = new int[9];
		for(int i=0; i<9; i++) {
			num1[i] = Integer.parseInt(br.readLine());
			num2[i] = num1[i];
		}
		Arrays.sort(num1);
		
		System.out.println(num1[num1.length-1]);
		for(int i=0; i<num1.length; i++) {
			if(num1[num1.length-1] == num2[i]) {
				System.out.println(i+1);
				break;
			}
		}
	}

}