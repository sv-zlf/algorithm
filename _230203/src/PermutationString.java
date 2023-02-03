/**
 * @author zlf
 * @data 2023/2/3
 * @apiNote 字符串的排列
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class PermutationString {

    public static void main(String[] args) {
        String s1="ab";
        String s2="acbc";
        checkInclusion(s1,s2);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();
        if (length1 > length2) {
            return false;
        }
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        for (int i = 0; i < length1; i++) {
            char c1 = s1.charAt(i);
            counts1[c1 - 'a']++;
            char c2 = s2.charAt(i);
            counts2[c2 - 'a']++;
        }
        if (checkEqual(counts1, counts2)) {
            return true;
        }
        for (int i = length1; i < length2; i++) {
            char prev = s2.charAt(i - length1);
            counts2[prev - 'a']--;
            char curr = s2.charAt(i);
            counts2[curr - 'a']++;
            if (checkEqual(counts1, counts2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkEqual(int[] counts1, int[] counts2) {
        for (int i = 0; i < 26; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }
        return true;
    }
}
