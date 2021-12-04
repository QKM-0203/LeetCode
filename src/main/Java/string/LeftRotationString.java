package string;

public class LeftRotationString {
    public static String reverseLeftWords(String s, int n) {
        char[] chars = (s + " ".repeat(Math.max(0, n))).toCharArray();
        int end = chars.length;
        System.out.println(end);
        for (int i = n - 1; i >= 0; i--) {
            chars[end - 1] = chars[i];
            end--;
        }
        return new String(chars, n, end);
    }
}
