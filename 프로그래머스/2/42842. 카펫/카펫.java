class Solution {
    public int[] solution(int brown, int yellow) {
        int col = 0;
        int row = 0;
        
        for(int i=1; i<=yellow; i++){
            if(yellow%i != 0) continue;
            col = i;
            row = yellow/i;
            
            if(((col*2) + (row*2) + 4) == brown){
                col += 2;
                row += 2;
                break;
            } 
        }
        return new int[] {row, col};
    }
}