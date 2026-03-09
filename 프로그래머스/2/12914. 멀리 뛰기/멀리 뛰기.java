import java.util.*;

class Solution {
    public long solution(int n) {
            int mod = 1234567;

        if (n == 1) return 1;
        if (n == 2) return 2;

        long a = 1;
        long b = 2;

        for (int i = 3; i <= n; i++) {
            long c = (a + b) % mod;
            a = b;
            b = c;
        }

        return b;
    }
}