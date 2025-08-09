class Solution {
    private static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; 
        long oddCount = n / 2;        
        long part1 = power(5, evenCount);
        long part2 = power(4, oddCount);

        return (int)((part1 * part2) % MOD);
    }

    private long power(long base, long exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        half = (half * half) % MOD;
        if (exp % 2 == 1) {
            return (half * base) % MOD;
        } else {
            return half;
        }
    }
}
