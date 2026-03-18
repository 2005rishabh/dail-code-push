class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int maxA = 0;

        for (int i = 0; i <= arr.length; i++) {
            int curr = (i == arr.length) ? 0 : arr[i];

            while (!s.isEmpty() && curr < arr[s.peek()]) {
                int index = s.pop();
                int height = arr[index];
                int nse = i;
                int pse = s.isEmpty() ? -1 : s.peek();
                int width = nse - pse - 1;
                maxA = Math.max(maxA, height * width);
            }

            s.push(i);
        }

        return maxA;
    }
}
