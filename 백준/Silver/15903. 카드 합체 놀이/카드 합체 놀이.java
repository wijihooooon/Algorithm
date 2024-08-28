import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<Long> card = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card.add(Long.parseLong(st.nextToken()));
        }
        
        // 초기 정렬
        Collections.sort(card);
        
        for (int i = 0; i < m; i++) {
            // 가장 작은 두 개의 카드 합치기
            long smallest = card.get(0);
            long secondSmallest = card.get(1);
            long newCard = smallest + secondSmallest;
            
            // 두 카드를 합친 결과로 리스트를 업데이트
            card.set(0, newCard);  // 첫 번째 카드 업데이트
            card.set(1, newCard);  // 두 번째 카드 업데이트
            
            // 합친 후 다시 정렬
            Collections.sort(card);
        }
        
        // 모든 카드의 합 계산
        long sum = 0;
        for (long value : card) {
            sum += value;
        }
        
        System.out.println(sum);
    }
}
