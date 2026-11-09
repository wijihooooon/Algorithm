import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder binary = toBinary(numbers[i]);

            // 가장 오른쪽에 있는 0 찾기
            int zero = -1;
            for (int j = binary.length() - 1; j >= 0; j--) {
                if (binary.charAt(j) == '0') {
                    zero = j;
                    break;
                }
            }

            if (zero == -1) {
                // 0이 없는 경우: 111 → 1011
                binary.insert(0, '1');
                binary.setCharAt(1, '0');
            } else if (zero == binary.length() - 1) {
                // 마지막 자리가 0인 경우: 110 → 111
                binary.setCharAt(zero, '1');
            } else {
                // 중간에 0이 있는 경우: 1011 → 1101
                binary.setCharAt(zero, '1');
                binary.setCharAt(zero + 1, '0');
            }

            answer[i] = toDecimal(binary);
        }

        return answer;
    }

    // 정수를 이진수로 변환
    public StringBuilder toBinary(long number) {
        if (number == 0) {
            return new StringBuilder("0");
        }

        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            sb.append(number % 2);
            number /= 2;
        }

        return sb.reverse();
    }

    // 이진수를 정수로 변환
    public long toDecimal(StringBuilder binary) {
        long num = 0;

        for (int i = 0; i < binary.length(); i++) {
            num = num * 2 + (binary.charAt(i) - '0');
        }

        return num;
    }
}