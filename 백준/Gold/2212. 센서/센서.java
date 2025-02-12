import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 센서 개수
        int K = Integer.parseInt(br.readLine()); // 집중국 개수

        if(N <= K){
            System.out.println(0);
            return;
        }
        
        int[] sensor = new int[N];
        int[] distance = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        int result = 0;

        for(int i=0; i<sensor.length-1; i++){
            distance[i] = sensor[i+1] - sensor[i];
            result += distance[i];
        }

        Arrays.sort(distance);

        for(int i=0; i<K-1; i++){
            result -= distance[N-2-i];
        }

        System.out.println(result);
    }
}
