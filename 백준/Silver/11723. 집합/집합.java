import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		boolean check[] = new boolean[21];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num;
			
			switch(str) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				if(!check[num]) {
					check[num] = true;
				}
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if(check[num]) {
					check[num] = false;
				}
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(check[num]) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if(check[num]) {
					check[num] = false;
				}else {
					check[num] = true;
				}
				break;
			case "all":
				Arrays.fill(check, true);
				break;
			case "empty":
				Arrays.fill(check, false);
				break;
			}
		}
		bw.flush();
	}

}
