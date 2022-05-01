package org.maxwell.algorithm.easy;

/**
 * @description: 463. 岛屿的周长
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/23 12:30
 */
public class Solution_463 {

    // todo 理解完这个两个数组就通透了
    // x轴方向相邻坐标
    static int[] dx = {0, 1, 0, -1};
    // y轴方向相邻坐标
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (1 == grid[i][j]) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        // 判断相邻的格子是否超出边界长度超出则为边界+1并判断是否为水域是则+1周长
                        if (tx >= n || tx < 0 || ty >= m || ty < 0 || grid[tx][ty] == 0)
                            cnt+=1;
                    }
                  ans+=cnt;
                }
            }
        }
        return ans;
    }


}
