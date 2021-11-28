package hashtable;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        set2.retainAll(set1);
        int i = 0;
        int[] result = new int[set2.size()];
        for (Integer integer : set2) {
            result[i++] = integer;
        }
        return result;
    }
}
