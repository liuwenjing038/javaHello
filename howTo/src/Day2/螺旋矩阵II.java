package Day2;

public class 螺旋矩阵II {
    /*
给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
示例:
输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
#

    * */

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int offset = 1; //这里的offset代表每一圈的偏移量
        int startX = 0,startY = 0;  //startX,startY代表从每一圈的起点
        int count = 1;  //这里的count是填充的数字
        int loop = 1;   //这里的loop代表循环的圈数  比如3循环1圈  4 循环2圈
        int i,j;  //j代表列  i代表行
        while (loop <= n/2){
            //先写上面的边  需要注意每条边的处理都是左闭右开
            for (j = startY;j<n-offset;j++){
                res[startX][j] = count++;  //这里需要注意使用startX  因为i还没有初始化
            }
//            再写右边的边 需要注意每条边的处理都是左闭右开
            for (i = startX;i<n-offset;i++){
                res[i][j] = count++;
            }
            //接着是下面的边  需要注意每条边的处理都是左闭右开
            for (j = n-offset;j>startY;j--){
                res[i][j] = count++;
            }
            //最后是左边的边  需要注意每条边的处理都是左闭右开
            for (i = n-offset;i>startX;i--){
                res[i][j] = count++;
            }
            offset++;
            loop++;
            startX++;
            startY++;
        }
        if(n%2==1){
            res[startX][startY] = count;
        }
        return res;
    }
}
