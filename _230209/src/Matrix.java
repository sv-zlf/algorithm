import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zlf
 * @data 2023/2/9
 * @apiNote LeetCode 542. 01 Matrix
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 */
public class Matrix {

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
        int [][]res=mat;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    res[i][j] = searchLength(mat,i,j);
                }
            }
        }
        return res;
    }

    public static int searchLength(int [][]mat,int x,int y){
        System.out.println("X:"+x+"Y:"+y);
        int length=100;
        int m= mat.length; //多少行
        int n=mat[0].length; //多少列
        int []dx={0,0,1,-1};
        int []dy={1,-1,0,0};
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{x,y});

        while (!que.isEmpty()){
            int []cell=que.poll();
            for (int i = 0; i < 4; i++) {
                int temp=1;
                int mx=cell[0]+dx[i];
                int my=cell[1]+dy[i];
                if(mx>=0&&mx<m&&my>=0&&my<n){
                    if(mat[mx][my]==0) break;
                    else {
                        que.add(new int[] {mx,my});
                        temp++;
                    }
                }
                length=Math.min(length,temp);
            }

        }
        return length;
    }
}
