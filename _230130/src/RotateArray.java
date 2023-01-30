/**
 * @author zlf
 * @data 2023/1/30
 * @apiNote 轮转数组
 * 给你一个数组，将数组中的元素向右轮转k个位置，其中k是非负数。
 */
public class RotateArray {

    public static void main(String args[]){
        int nums[]={1,2,3,4,5,6,7};
        int k=3;
        rotate(nums,k);
    }

    public static void rotate(int[] nums, int k) {
        int n=nums.length;
        int reNums[]=new int[n];
        for (int i=0;i<n;i++){
            reNums[(i+k)%n]=nums[i];
        }
        nums=reNums;
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
