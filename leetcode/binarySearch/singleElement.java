package binarySearch;

public class singleElement {
    public static int findSingleElement(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XORing all elements
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 5, 3, 4}; // Example array
        System.out.println("The single element is: " + findSingleElement(nums));
    }
}
