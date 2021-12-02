package string;

public class ReplaceSpaces {
    //two points
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("  ");
            }
        }
        int left = s.length() - 1;
        int right = stringBuilder.length() - 1;
        char[] chars = stringBuilder.toString().toCharArray();
        while (left < right) {
            if (stringBuilder.charAt(left) == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
