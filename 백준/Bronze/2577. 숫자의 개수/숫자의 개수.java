import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int sum = A * B * C;
		int count = 0;
		String snum = Integer.toString(sum);
		int num[] = new int[10];
		
		for(int j=0; j<snum.length();j++) {
			if(snum.charAt(j) == '0') {
				count++;
			}
			num[Character.getNumericValue(snum.charAt(j))]++;
		}
		System.out.println(count);
		for(int j=1; j<10; j++) {
			System.out.println(num[j]);
		}
	}

}