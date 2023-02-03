import java.util.HashMap;

/**
 * @author zlf
 * @data 2023/2/3
 * @apiNote 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstring {

    public static void main(String[] args) {
        String str="au";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[]str=s.toCharArray();
        int max=0;
        int left=0;
        HashMap<Character,Integer> chur=new HashMap<Character, Integer>();
        for (int right = 0; right < str.length; right++) {
            char ch=s.charAt(right);
            if(chur.containsKey(ch)){
            left=Math.max(left,chur.get(ch)+1);
            }
            max=Math.max(max,right-left+1);
            chur.put(ch,right);
        }

        return max;
    }
}
