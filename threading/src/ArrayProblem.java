import java.util.*;

public class ArrayProblem {
    public static int[] sumOfTwoInArray(int[] numberList, Integer target) {
        Map<Integer, Integer> prevScan = new HashMap<>();
        int balance = 0;

        // [5, 3, 1, 8] , 11
        for (int i=0; i < numberList.length; i++) {
            if (prevScan.containsKey(target - numberList[i])) {
                return new int[]{prevScan.get(target - numberList[i]), i};
            }
            prevScan.put(numberList[i], i);
        }
        return new int[]{};
    }

    /**
     * return true if there is duplication in array
     * time complexity - O(n)
     * space complexity - O(n)
     * @param arr Array
     * @return true or false
     */
    public static boolean duplicateInArray(int[] arr) {
        Set<Integer> scannedCopy = new HashSet<>();
        for (int i=0; i < arr.length; i++) { // O(n)
            if (!scannedCopy.add(arr[i])) { // O(n)
                return true;
            }
        }
        return false;
    }

    /**
     * Given an int array, return an array of all product except itself in its respective position
     * @param arr
     * @return
     */
    public static int[] productExceptItself(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);

        int prefix = 1;
        for (int i=0; i < arr.length; i++) {
            result[i] = prefix;
            prefix *= arr[i]; // {1, 1, 2, 6}
        }

        int postfix = 1;
        return new int[]{};
    }


    /**
     * Given a array of integer, find the contiguous subarray which has the highest sum
     * and return the sum, try O(n) complexity
     * Kadane's Algorithm formula, currentSum = max(nums[i], currentSum+nums[i])
     * @param nums
     * @return
     */
    public static int maximumSubArray(int[] nums) {

        int maxSub = nums[0]; // O(1)
        int currentSum = 0; // O(1)

        for (int i=0; i < nums.length; i++) { // {1, -1, 6, -2, 7} O(n)
            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += nums[i]; // 1, 0, 6, 4, 11
            maxSub = Math.max(maxSub, currentSum); // 1, 1, 6, 6, 11
        }
        return maxSub;
    }
}
