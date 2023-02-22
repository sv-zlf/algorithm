
/**
 * @author zlf
 * @data 2023/2/17
 * @apiNote LeetCode 1139. 最大的以 1 为边界的正方形
 * 给你一个由若干 0 和 1 组成的二维网格grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 */
public class Largest1BorderedSquare {

    public static void main(String[] args) {
        int m=3;int n=3;
        int grid[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }
        grid[2][2]=0;


    }

    public static int largest1BorderedSquare(int[][] grid) {
        int num=0;
        return num;
    }
}

