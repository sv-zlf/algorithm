import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zlf
 * @data 2023/2/10
 * @apiNote LeetCode 994. 腐烂的橘子
 * 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 */
public class RottingOranges {

    public static void main(String[] args) {
        int m=3;
        int n=3;
        int [][]grid=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }
        //grid[0][0]=0;
        //grid[0][1]=2;
        grid[0][0]=2;
        grid[1][2]=0;
        grid[2][0]=0;
        System.out.println(orangesRotting(grid));

    }
    public static int orangesRotting(int[][] grid) {
        int times=0;
        int m=grid.length;
        int n=grid[0].length;
        int []dx={0,0,1,-1};
        int []dy={1,-1,0,0};
        Queue<int[]>que=new LinkedList<>();
        boolean [][]seen=new boolean[m][n];
        //预判面
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j]==2){
                    seen[i][j]=true;
                    que.add(new int[]{i,j});
                }
            }
        }

        if (count==0){
            return 0;
        }

        while (!que.isEmpty()){
            int size=que.size();
            System.out.println("size"+size);
            for (int i=0;i < size; i++){
                int cell[]=que.poll();
                int x=cell[0];
                int y=cell[1];

                for (int d=0;d<4;d++){
                    int mx=x+dx[d];
                    int my=y+dy[d];
                    if(mx>=0&&my>=0&&mx<m&&my<n&&!seen[mx][my]){
                        if(grid[mx][my]==1){
                            que.add(new int[]{mx,my});
                            seen[mx][my]=true;
                            grid[mx][my]=2;
                            count--;
                        }
                    }
                }
            }
            times++;
        }
        if (count > 0) {
            return -1;
        }
        return times-1;
    }
}
