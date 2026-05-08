import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            
            return Integer.compare(a[2], b[2]);
        });
        
        
        int sum = 0;
        int time = 0;
        int count = 0;
        int idx = 0;
        
        while(count < jobs.length){
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new int[]{jobs[idx][0], jobs[idx][1], idx});
                idx++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();

                int startT = job[0];
                int needT = job[1];

                time += needT;
                sum += time - startT;

                count++;
            }
        }
        
        
        answer = sum / jobs.length;
        
        return answer;
    }
}