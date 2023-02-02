/**
 * @author zlf
 * @data 2023/2/1
 * @apiNote 反转字符串中的单词 III
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s="God Ding";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
       String[]strs=s.split(" ");
       for (int i = 0; i < strs.length; i++){
           String str=strs[i];
           str=reverseString(str);
           strs[i]=str;
       }
       return String.join(" ",strs);
    }

    public static String reverseString(String str) {
        char[] s = str.toCharArray();
        int left=0;
        int right=s.length - 1;
        while (left < right) {
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(s);
    }
}
