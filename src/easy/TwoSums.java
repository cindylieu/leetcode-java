package easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSums {

    public static void main(String[] args) {
        int[] nums = {3, 2, 11, 7, 15};
        twoSum(nums, 9);
        twoSumImproved(nums, 9);;
        System.out.println(Arrays.toString(twoSumP2(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        HashMap<Integer, Integer> options = new HashMap<>();

        int index = 0;

        for (int i : nums) {
            indexMap.put(index, i);

            if (options.containsKey(i)) {
                int[] a = {options.get(i), index};
                return a;
            } else {
                int secondPair = target - nums[index];
                options.put(secondPair, index);
                index++;
            }
        }
        return null;
    }

    public static int[] twoSumImproved(int[] nums, int target) {

        HashMap<Integer, Integer> indexMap = new HashMap<>();

        int index = 0;

        for (int i : nums) {
            if (indexMap.containsKey(i)) {
                int[] a = {indexMap.get(i), index};
                return a;
            } else {
                int secondPair = target - nums[index];
                indexMap.put(secondPair, index);
                index++;
            }
        }
        return null;
    }

    //practiced again
    public static int[] twoSumP2(int[] nums, int target) {

        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        for (int i = 0; i < indexMap.size(); i++) {
            if (indexMap.containsKey(target-nums[i])) {
                int[] r = {indexMap.get(nums[i]), indexMap.get(target-nums[i])};
                return r;
            }
        }

        return null;
    }
}