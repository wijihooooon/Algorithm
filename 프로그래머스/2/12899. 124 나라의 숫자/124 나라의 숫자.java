class Solution {
    public String solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        
        while(n != 0){
            switch(n%3){
                case 0:
                    n = (n/3)-1;
                    sb.append("4");
                    break;
                case 1:
                    n = n/3;
                    sb.append("1");
                    break;
                case 2:
                    n = n/3;
                    sb.append("2");
                    break;     
            }
        }
        
        return sb.reverse().toString();
    }
}