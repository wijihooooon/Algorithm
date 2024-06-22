import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		ArrayList<Integer> dwarf = new ArrayList<>();
		
		// 난쟁이 키 총합에 두명 키 뺴기
		// 난쟁이 총합
		for(int j=0; j<9; j++) {
			dwarf.add(Integer.parseInt(br.readLine()));
			sum += dwarf.get(j);
		}
		
		// 난쟁이 키 두명 고르기
		for(int j=0; j<9; j++) {
			for(int k=j+1; k<9; k++) {
				if(sum - (dwarf.get(j)+dwarf.get(k)) == 100) {
					dwarf.remove(j);
					// 난쟁이 한명을 뺏기 떄문에 -1해야됨 사이즈가 줄어듬
					dwarf.remove(k-1);
					break;
				}
			}
			// 난쟁이 두명을 뺴서 사이즈가 7이 되면 즉 시 탈 출
			if(dwarf.size() == 7) {
				break;
			}
		}
		// 정렬
		Collections.sort(dwarf);
		
		// 출력
		for(int j=0; j<dwarf.size(); j++) {
			System.out.println(dwarf.get(j));
		}
	}
}