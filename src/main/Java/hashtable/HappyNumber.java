package hashtable;

import java.util.HashSet;

public class HappyNumber {
    public int getNextNumber(int n) {
        int num = 0;
        while (n != 0) {
            int temp = n % 10;
            num += temp * temp;
            n = n / 10;
        }
        return num;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();
        while (n != 1 && !integers.contains(n)) {
            integers.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
}
