package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfFour {
    //确定第一个数i然后之后还是利用三数求和来解决
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j;
            for (j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        arrayLists.add(List.of(nums[i], nums[left], nums[right], nums[j]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return arrayLists;
    }
}
