import java.util.Stack;

/**
 * @author zlf
 * @data 2023/2/6
 * @apiNote LeetCode 733. 图像渲染
 * 有一幅以m x n的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。
 * 你也被给予三个整数sr,sc和newColor 。你应该从像素image[sr][sc]开始对图像进行上色填充 。
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，
 * 重复该过程。将所有有记录的像素点的颜色值改为newColor。
 * 最后返回 经过上色渲染后的图像。
 */
public class FloodFill {

    public static void main(String[] args) {

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int [][]res=image;
        int num=image[sr][sc];

        if (num==color){
            return image;
        }
        Stack<Integer> X=new Stack<>();
        Stack<Integer> Y=new Stack<>();
        X.push(sr);
        Y.push(sc);
        res[sr][sc]=color;

        int []dx={0,0,1,-1};
        int []dy={1,-1,0,0};
        int m=image[0].length;
        int n=image.length;
        while (!X.isEmpty()){
            int x=X.pop();
            int y=Y.pop();

            for (int i = 0; i < 4; i++) {
                int mx=x+dx[i];
                int my=y+dy[i];
                if(mx>=0&&my<n&&mx<m&&my>=0&&image[mx][my]==num){
                    X.push(mx);
                    Y.push(my);
                    res[mx][my]=color;
                }
            }
        }

        return res;
    }
}
