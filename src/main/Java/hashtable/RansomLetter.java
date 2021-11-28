package hashtable;

public class RansomLetter {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letter = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            letter[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            letter[magazine.charAt(i) - 'a']--;
        }
        for (int i : letter) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
