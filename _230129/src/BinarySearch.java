/**
 * @author zlf
 * @data 2023/1/29
 * @apiNote 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums和一个目标值target
 * 写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回-1。
 */
public class BinarySearch {

    public static void main(String[] args) {
        int nums[]={-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        int right=nums.length-1;
        int left=0;
        while (left<=right){
            int mid =(right+left)/2;
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
        return -1;
    }
}

