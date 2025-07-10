class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = prevLessCounts(arr);
        int[] right = nextLessCounts(arr);

        long sum = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) sum;
    }

    private int[] prevLessCounts(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) s.pop();
            left[i] = s.isEmpty() ? i + 1 : i - s.peek();
            s.push(i);
        }

        return left;
    }

    private int[] nextLessCounts(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            right[i] = s.isEmpty() ? n - i : s.peek() - i;
            s.push(i);
        }

        return right;
    }
}
