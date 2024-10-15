import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
        
        long start = 0;
        long end = N;
        long ans = 0;
        while(start<=end) {
        	long mid = (start + end) / 2;
        	
        	double num = Math.pow(mid, 2);
        	if (N <= Math.pow(mid, 2)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
	}

}
