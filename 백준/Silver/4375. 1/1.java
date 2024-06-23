import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count;
		int n;
		int num;
		String str = null;
		while( (str = br.readLine()) != null ) {
			n = Integer.parseInt(str);
			num = 1;
			count = 1;
			while(true) {
				if(num % n == 0) {
					break;
				}
				count++;
				num = ((num * 10) + 1) % n;
			}
			System.out.println(count);
		}
	}
}