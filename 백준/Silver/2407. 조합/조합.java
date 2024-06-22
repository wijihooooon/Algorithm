import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger ans = BigInteger.ONE;
		BigInteger div = BigInteger.ONE;
		
		for(int j=n; j>n-m; j--) {
			ans = ans.multiply(BigInteger.valueOf(j));
		}
		for(int j=m; j>0; j--) {
			div = div.multiply(BigInteger.valueOf(j));
		}
		
		System.out.println(ans.divide(div));
	}
}