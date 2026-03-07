class Solution {
    public int[] solution(String s) {
        int deleteCnt = 0;
        int count = 0;
        
        while(!s.equals("1")){
            int beforeL = s.length();
            s = s.replace("0", "");
            
            int afterL = s.length();
            deleteCnt += beforeL - afterL;
            
            s = Integer.toBinaryString(afterL);          
            count++;
            
            
        }
        return new int[]{count, deleteCnt};
    }
}