class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        Arrays.sort(arr);

        int longest = 1;
        int curr = 1;
        int ls = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] == ls) {
                continue;
            } else if (arr[i] == ls + 1) {
                curr += 1;
            } else {
                curr = 1;
            }
            ls = arr[i];
            longest = Math.max(longest, curr);
        }

        return longest;
    }
}
