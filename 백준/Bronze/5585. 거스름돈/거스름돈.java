import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		// 잔돈 500, 100, 50, 10, 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = 1000 - Integer.parseInt(br.readLine());
		int [] coin = {500, 100, 50, 10, 5, 1};
		int count = 0;
		
		for(int i=0; i<6; i++) {
			if(money>=coin[i]) {
				count += money / coin[i];
				money %= coin[i];
			}		
		}
		
		System.out.println(count);
	}

}