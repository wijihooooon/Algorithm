class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        
        answer = new long[numbers.length];
        
        for(int i=0; i< numbers.length; i++){
            long number = numbers[i];
            
            // 이진화
            String binary = toBinary(number);
            
            // 다른비트 찾기
            // i) 0의 위치를 찾기
            int zero = -1;
            for(int j=0; j<binary.length(); j++){
                if(binary.charAt(j) == '0'){
                    zero = j;
                }
            }
            
            if(zero == -1){                         // ii) 0이 없으면 맨앞에 1을 추가하고 그 뒷자리를 0으로 변경
                binary = "10" + binary.substring(1);
            }else if(zero == binary.length() - 1){  // iii) 0이 맨뒤에 있으면 1로 변경
                binary = binary.substring(0, zero) + "1";
            }else{                                  // iii) 0이 중간에 있으면 1로 변경하고 뒷자리의 1을 0으로 변경
                binary = binary.substring(0, zero)
                        + "10"
                        + binary.substring(zero + 2);
            }            
            
            // 정수화
            long ans = toDigit(binary);
            
            answer[i] = ans;
        } 
        return answer;
    }
    
    public String toBinary(long number){
        StringBuilder sb = new StringBuilder();
        
        if(number == 0) return "0";
        
        while(number != 1){
            if(number%2 == 0){
                sb.append(0);
            }else{
                sb.append(1);
            }
            
            number /= 2;
        }
        
        if(number == 1){
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
    
    public long toDigit(String binary){
        long num = 0;
        
        for (int i = 0; i < binary.length(); i++) {
            num = num * 2 + (binary.charAt(i) - '0');
        }
        
        return num;
    }
}