import java.util.Stack;

/**
 * @author zlf
 * @data 2023/2/6
 * @apiNote LeetCode 695.岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int [][]grid=new int[13][8];
        grid[0][2]=1;
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int m = grid.length;    //多少列
        int n = grid[0].length; //多少行

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    int temp=1;
                    Stack<Integer> X=new Stack<>();
                    Stack<Integer> Y=new Stack<>();
                    X.push(i);
                    Y.push(j);
                    grid[i][j]=0;
                    while (!X.isEmpty()){
                        int x=X.pop();
                        int y=Y.pop();
                        for (int k = 0; k < 4; k++) {
                            int mx=x+dx[k];
                            int my=y+dy[k];
                            if(mx>=0&&my<n&&mx<m&&my>=0&&grid[mx][my]==1){
                                X.push(mx);
                                Y.push(my);
                                grid[mx][my]=0;
                                temp++;
                            }
                        }
                    }
                    max=Math.max(max,temp);
                }
            }
        }

        return max;
    }
}