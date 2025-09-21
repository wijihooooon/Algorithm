class Solution {
    public int[] solution(long n) {
        String num =  Long.toString(n);
        int[] answer = new int[num.length()];

        for(int i=answer.length-1; i>=0; i--){
            answer[num.length()-i-1] = num.charAt(i)-'0';
        }

        return answer;
    }
}