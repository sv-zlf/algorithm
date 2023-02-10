import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zlf
 * @data 2023/2/9
 * @apiNote LeetCode 542. 01 Matrix
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 */
public class Matrix1 {

    public static void main(String[] args) {
        int m=3;
        int n=3;
        int [][]mat=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 0;
            }
        }
        mat[1][1]=1;
        mat[2][0]=1;
        mat[2][1]=1;
        mat[2][2]=1;
        int [][]res=updateMatrix(mat);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println("");
        }
    }

    public static int[][] updateMatrix(int[][] mat) {

        int m= mat.length; //多少行
        int n=mat[0].length; //多少列
        int []dx={0,0,1,-1};
        int []dy={1,-1,0,0};
        int [][]res=mat;
        boolean [][]isFlag=new boolean[m][n];
        Queue<int[]> que=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    isFlag[i][j] = true;
                    que.add(new int[]{i,j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!que.isEmpty()) {
            int []cell= que.poll();
            int x=cell[0];
            int y=cell[1];
            for (int i = 0; i < 4; i++) {
                int mx=dx[i]+x;
                int my = dy[i] + y;
                if(mx>=0&&mx<m&&my>=0&&my<n&&mat[mx][my]==-1){
                    res[mx][my] = mat[x][y]+1;
                    que.add(new int[]{mx,my});
                }
            }
        }
        return res;
    }
}
