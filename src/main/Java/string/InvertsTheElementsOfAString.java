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

    /**
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * 思路：去除多余的的空格，然后将字符串整体反转，最后每个单词在反转就可以
     * 时间复杂度：去重多余的空格(中间的空格)是o(n){@link array.RemoveNumber})，然后reverse就行是on(n/2)
     * 最终时间复杂度是o(n)
     * 空间复杂度：没有新开辟空间所以是o(1)
     * */
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
}
