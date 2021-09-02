package string;

public class InvertsTheElementsOfAString {
    public static String reverseWords(String s) {
        String trim = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        int key = 0;
        for (int i = trim.length() - 1; i >= 0; i--) {
            if (trim.charAt(i) == ' ' && trim.charAt(i - 1) != ' ') {
                stringBuilder.append(" ");
                key = stringBuilder.length();
            } else if (trim.charAt(i) != ' ') {
                stringBuilder.insert(key, trim.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String DoubleReverseWords(String s) {
        String trim = s.trim();
        char[] chars = trim.toCharArray();
        int slow = 0;
        int fast = 0;
        for (; fast < trim.length(); fast++) {
            if (trim.charAt(fast) == ' ' && trim.charAt(fast + 1) != ' ') {
                chars[slow++] = ' ';
            } else if (trim.charAt(fast) != ' ') {
                chars[slow++] = trim.charAt(fast);
            }
        }
        char[] chars1 = new String(chars).substring(0, slow).toCharArray();
        ReverseStringII.reverse(chars1, 0, chars1.length - 1);
        int temp = 0;
        int index = 0;
        for (; index < chars1.length; index++) {
            if (chars1[index] == ' ') {
                ReverseStringII.reverse(chars1, temp, index - 1);
                temp = index + 1;
            }
        }
        ReverseStringII.reverse(chars1, temp, index - 1);
        return new String(chars1);
    }

    public static void main(String[] args) {
        System.out.println(DoubleReverseWords("a good   example"));
    }
}
