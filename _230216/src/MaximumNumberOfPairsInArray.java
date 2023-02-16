/**
 * @author zlf
 * @data 2023/2/16
 * @apiNote LeetCode 2341. 数组能形成多少数对
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 */
public class MaximumNumberOfPairsInArray {

    public static void main(String[] args) {
        int []nums={1,3,2,1,3,2,2};
        int n[]=numberOfPairs(nums);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }

    public static int[] numberOfPairs(int[] nums) {
        int answer[]=new int[2];
        int n=nums.length;
        int resNum1=0;
        int resNum2=0;
        boolean isFlag[]=new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!isFlag[i]){
                for (int j = i+1; j < n; j++) {
                    if (!isFlag[j]&&nums[i] == nums[j]){
                        resNum1++;
                        isFlag[j] = true;
                        isFlag[i] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!isFlag[i]) {
                resNum2++;
            }
        }
        answer[0]=resNum1;
        answer[1]=resNum2;
        return answer;
    }

}
