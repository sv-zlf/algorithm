/**
 * @author zlf
 * @data 2023/1/30
 * @apiNote
 * 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class SquaresOfASortedArray {

    public static void main(String args[]){
        int nums[]={-4,-1,0,3,10};
        System.out.println(sortedSquares(nums));
    }

    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int []reNums = new int[length];
        int left = 0;
        int right = length-1;
        int flag=right;
        while (left<right){
            int leftNum=nums[left]*nums[left];
            int rightNum=nums[right]*nums[right];
            System.out.println(leftNum);
            if(leftNum<rightNum){
                reNums[flag]=rightNum;
                right--;
            }
            if(leftNum>rightNum){
                reNums[flag]=leftNum;
                left++;
            }
            if(leftNum==rightNum){
                reNums[flag]=rightNum;
                flag--;
                reNums[flag]=leftNum;
                right--;
                left++;
            }
            flag--;
        }
        reNums[0]=nums[left]*nums[left];
        return reNums;
    }
}
