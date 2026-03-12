class Solution {
    public static int answer = -1;
    public static boolean[] visited;
    public int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        cal(k, 0);
        return answer;
    }
    
    public void cal(int Tiredness, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            int needScore = dungeons[i][0];
            int useScore = dungeons[i][1];
            
            if(!visited[i] && Tiredness >= needScore){
                visited[i] = true;
                cal(Tiredness-useScore, cnt+1);
                visited[i] = false;
            }
        }
    }
}