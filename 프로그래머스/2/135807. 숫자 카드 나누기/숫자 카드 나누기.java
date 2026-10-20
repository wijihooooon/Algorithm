import java.util.*;

// 유클리드 호제법으로 풀기
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 각 배열 전체의 최대공약수 계산
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int answer = 0;

        // A의 최대공약수로 B를 나눌 수 없는지 확인
        if (check(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }

        // B의 최대공약수로 A를 나눌 수 없는지 확인
        if (check(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    // 유클리드 호제법
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 배열의 모든 원소가 num으로 나누어떨어지지 않아야 함
    public boolean check(int[] arr, int num) {
        for (int n : arr) {
            if (n % num == 0) {
                return false;
            }
        }
        return true;
    }
}