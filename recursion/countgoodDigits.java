class Solution {
    private static final int MOD = 1_000_000_007;

    // Recursive power function: (base^exp) % MOD
    private long power(long base, long exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenPart = power(5, evenPositions);
        long oddPart = power(4, oddPositions);

        return (int)((evenPart * oddPart) % MOD);
    }
}
