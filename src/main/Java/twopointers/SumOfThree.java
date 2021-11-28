package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果第一个数字大于0,则直接返回
            if (nums[i] > 0) {
                return arrayLists;
            }
            //先去重下标为i的值(应该是前一个和当前比较是否相等，不能是当前和后一个比较
            //因为会丢失类似于 -1, -1, 2这种情况)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    arrayLists.add(List.of(nums[i], nums[left], nums[right]));
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
        return arrayLists;
    }
}
