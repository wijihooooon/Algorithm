import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String num = Integer.toString(N);
		
		int Nset[] = new int[9];	// 0~9 담는 배열
		int Nset2[] = new int[9];	// 정렬용 배열
		
		// 9는 6에 추가함
		for(int j=0; j<num.length(); j++) {
			if(num.charAt(j) == '9') {
				Nset[6]++;
			}else {
				Nset[num.charAt(j)-'0']++;
			}
		}
		// 6과9는 공용이므로 2개가 1개가되도록 함
		Nset[6] = Nset[6]/2 + Nset[6]%2;
		
		// 배열 복사 및 오름차순으로 정렬
		Nset2 = Arrays.copyOf(Nset, Nset.length);
		Arrays.sort(Nset2);
		
		// 최대값 구하기
		int max = Nset2[Nset2.length-1];
				
		// 최대값과 같은 배열 찾아서 몇개 필요한지 출력
		for(int j=0; j<Nset.length; j++) {
			if(Nset[j] == max) {
				System.out.println(Nset[j]);
				break;
			}
		}
	}

}