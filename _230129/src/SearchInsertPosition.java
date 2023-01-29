/**
 * @author zlf
 * @data 2023/1/29
 * @apiNote 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchInsertPosition {

    public static void main(String args[]){
        int nums[]={1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
        int right=nums.length-1;
        int left=0;
        int mid=0;
        while (left<=right){
            mid =(right+left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right=mid-1;
            }
            if(nums[mid]<target){
                left=mid+1;
            }
        }
        return left;
    }
}
