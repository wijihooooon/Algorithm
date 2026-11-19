import java.util.*;

class Solution {
    
    public int N;
    public ArrayDeque<Integer> dq;
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        dq = new ArrayDeque<>();
        
        collatz(k);
        N = dq.size()-1;
        
        double[] prefixSum = calPrefixSum();
        
        for(int i=0; i<ranges.length; i++){
            int x1 = ranges[i][0];
            int x2 = N + ranges[i][1];
            
            if (x1 > x2) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefixSum[x2] - prefixSum[x1];
            }
        }
        
        return answer;
    }
    
    public double[] calPrefixSum(){        
        double[] sum = new double[N+1];
        
        for(int i=1; i<=N; i++){
            int y1 = dq.poll();
            int y2 = dq.peek();
            
            double area = (y1 + y2) / 2.0;
            sum[i] = sum[i - 1] + area;
        }
        
        return sum;
    }
    
    public void collatz(int n){
        dq.add(n);
        
        if(n == 1) return;
        
        if(n%2==0){
            collatz(n/2);
        }else{
            collatz((n*3)+1);
        }
    }
}
