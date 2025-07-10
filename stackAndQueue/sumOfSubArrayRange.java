class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = prevLessCounts(arr);
        int[] right = nextLessCounts(arr);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }

        return (int) sum;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] left = prevGreaterCounts(arr);
        int[] right = nextGreaterCounts(arr);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }

        return sum;
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

    private int[] prevGreaterCounts(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) s.pop();
            left[i] = s.isEmpty() ? i + 1 : i - s.peek();
            s.push(i);
        }

        return left;
    }

    private int[] nextGreaterCounts(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) s.pop();
            right[i] = s.isEmpty() ? n - i : s.peek() - i;
            s.push(i);
        }

        return right;
    }
}
