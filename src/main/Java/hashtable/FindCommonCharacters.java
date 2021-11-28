package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        int [] hash = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }
        int[] letter = new int[26];
        for (int i = 1; i < words.length; i++) {
            Arrays.fill(letter, 0);
            for (int j = 0; j < words[i].length(); j++) {
                letter[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k],letter[k]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) {
                result.add(String.valueOf((char)('a' + i)));
                hash[i]--;
            }
        }
        return  result;
    }
}
