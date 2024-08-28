import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2차원 평면에서 다각형의 넓이를 구하는 가장 일반적인 방법은 신발끈 공식(Shoelace formula)을 사용하는 것
 * 이 공식은 다각형의 꼭짓점 좌표를 이용해 넓이를 계산할 수 있다.
 * 1. 다각형의 꼭짓점은 순서대로 나열
 * 2. A = X(i) * Y(i+1), B = Y(i) * X(i+1)
 * 3. A - B
 * 4. |A - B| / 2
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int X[] = new int[N];
        int Y[] = new int[N];
        
        // 1. 나열된 걸 X좌표, Y좌표에 따로 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        
        // 꼭지점의 좌표가 큰 값일 경우 int를 벗어나기에 long으로 선언
        long sumX = 0;
        long sumY = 0;
        
        // 2. 각각의 값을 sumX, sumY에 저장
        for (int i = 0; i < N - 1; i++) {
            sumX += (long) X[i] * Y[i + 1];
            sumY += (long) Y[i] * X[i + 1];
        }
        
        // 마지막 꼭짓점에서 처음 꼭짓점으로 돌아오는 부분 처리
        sumX += (long) X[N - 1] * Y[0];
        sumY += (long) Y[N - 1] * X[0];
        
        // 3번과 4번 과정을 합쳐서 출력까지 진행
        double area = Math.abs(sumX - sumY) / 2.0;
        System.out.printf("%.1f", area);
    }
}
