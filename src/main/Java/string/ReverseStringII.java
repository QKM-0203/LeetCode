package string;

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        //每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < chars.length; i += 2 * k) {
            //剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
                continue;
            }
            //剩余字符少于 k 个，则将剩余字符全部反转
            reverse(chars, i, chars.length - 1);
        }
        return new String(chars);

    }

    // 翻转函数
    public void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
