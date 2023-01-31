/**
 * @author zlf
 * @data 2023/1/31
 * @apiNote 移动零
 * 给定一个数组 nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeroes {

    public static void main(String args[]){
        int nums[]={1,0,0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int n=nums.length;
        int first=0;
        int second=0;
        while (second<n-1&&first<n-1){
            if(nums[first]==0){
                first++;
            }

            if(nums[first]!=0&&nums[second]==0&&first>second){
                int temp=nums[second];
                nums[second]=nums[first];
                nums[first]=temp;
            }
            if(nums[first]!=0&&nums[second]==0&&first<=second){
                second++;
            }
            if (nums[second]!=0){
                second++;
            }
        }
        for (int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
    }
}
