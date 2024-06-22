import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int j=0; j<3; j++) {
			st = new StringTokenizer(br.readLine());
			int count = 0;
			
			for(int k=0; k<4; k++) {
				if(Integer.parseInt(st.nextToken()) == 0) {
					count++;
				}
			}
			switch(count) {
			case 0:
				System.out.println("E");
				break;
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("C");
				break;
			case 4:
				System.out.println("D");
				break;
			}
		}
	}

}