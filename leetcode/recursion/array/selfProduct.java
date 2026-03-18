class Solution {
    public int[] productExceptSelf(int[] arr) {
        int product = 1;
        int zeroCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                product *= arr[i];
            } else {
                zeroCount++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (zeroCount > 1) {
                arr[i] = 0;
            } else if (zeroCount == 1) {
                arr[i] = (arr[i] == 0) ? product : 0;
            } else {
                arr[i] = product / arr[i];
            }
        }

        return arr;
    }
}
