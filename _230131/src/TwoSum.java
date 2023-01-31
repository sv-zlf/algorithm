/**
 * @author zlf
 * @data 2023/1/31
 * @apiNote 两数之和 有序数组
 */
public class TwoSum {

    public static void main(String args[]){
        int numbers[]={0,0,3,4};
        int target=0;

    }

    public static int[] twoSum(int[] numbers, int target){

        int index1=0;
        int index2=numbers.length-1;
        System.out.println(index2);
        while (index1<index2){
            int sum=numbers[index1]+numbers[index2];
            if(sum==target){
                break;
            }
            if(sum<target){
                index1++;
            }
            else {
                index2--;
            }
        }
        return new int[]{index1+1,index2+1};
    }
}
