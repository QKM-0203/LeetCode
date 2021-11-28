package hashtable;

import java.util.HashMap;

public class AdditionOfFourNumbers {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        //先统计ab数组的和以及出现的次数。然后在统计c+d数组的和，然后判断-(c+d)在map中
        //存不存在若存在直接相加出现的次数，否则意味着没有条件符合。
        for (int i : nums1) {
            for (int j : nums2) {
                int temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                int temp = i + j;
                if (map.containsKey(-temp)) {
                    res += map.get(temp);
                }
            }
        }
        return res;
    }
}
