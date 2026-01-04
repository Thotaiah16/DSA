class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;

        for (int n : nums) {
            int p = (int) Math.round(Math.cbrt(n));
            if (p * p * p == n && isPrime(p)) {
                ans += 1 + p + p * p + n;
                continue;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    int q = n / i;
                    if (i != q && isPrime(i) && isPrime(q)) {
                        ans += 1 + i + q + n;
                    }
                    break; 
                }
            }
        }
        return ans;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
