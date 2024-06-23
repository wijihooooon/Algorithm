import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
// 여학생 = 0, 남학생 = 1
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 남,여 1~6 각 학년에 ++;
		double female[] = new double[7]; 
		double male[] = new double[7];
		
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			//여학생
			if(Integer.parseInt(st.nextToken()) == 0) {
				female[Integer.parseInt(st.nextToken())]++;
			}else { //남학생
				male[Integer.parseInt(st.nextToken())]++;
			}
		}
		
		//방 갯수 세기
		int count = 0;
		
		for(int j=1; j<=6; j++) {
			count += Math.ceil(male[j]/K);
			count += Math.ceil(female[j]/K);
		}
		
		
		System.out.println(count);
		
	}

}