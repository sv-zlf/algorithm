/**
 * @author zlf
 * @data 2023/1/29
 * @apiNote 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用boolisBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 */
public class FirstBadVersion {

    private static int bad=2126753389; //失败的版本
    private static int n=   2126753390;
    public static void main(String args[]){
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int left=1;
        int right=n;
        while (left<=right){
            int mid=(right-left)/2+left;

            if(!isBadVersion(mid)&&isBadVersion(mid+1))
                return mid+1;
            if(!isBadVersion(mid)&&!isBadVersion(mid+1)){
                left=mid+1;
            }

            if(isBadVersion(mid)&&!isBadVersion(mid-1)){
                return mid;
            }
            if(isBadVersion(mid)&&isBadVersion(mid-1)){
                right=mid-1;
            }

        }
        return -1;
    }

    public static boolean isBadVersion(int version){
        if (version>=bad) return true;
        else return false;
    }
}
