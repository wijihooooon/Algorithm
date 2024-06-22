import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		ArrayList<Character> list1 = new ArrayList<>();
		ArrayList<Character> list2 = new ArrayList<>();
		
		for(int j=0; j<s1.length(); j++) {
			list1.add(s1.charAt(j));
		}
		
		for(int j=0; j<s2.length(); j++) {
			list2.add(s2.charAt(j));
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		int count = 0;

		while(!list1.isEmpty() && !list2.isEmpty()) {
			if(list1.get(0) < list2.get(0)) {
				list1.remove(0);
			}else if(list1.get(0) > list2.get(0)) {
				list2.remove(0);
			}else if(list1.get(0) == list2.get(0)) {
				count += 2;
				list1.remove(0);
				list2.remove(0);
			}
		}					
		System.out.println(s1.length() + s2.length() - count);	
	}

}