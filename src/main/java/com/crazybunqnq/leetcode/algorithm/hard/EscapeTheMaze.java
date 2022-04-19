package com.crazybunqnq.leetcode.algorithm.hard;

import org.junit.Test;

import java.util.*;

/**
 * [1036]逃离大迷宫
 * <p>
 * 在一个 10⁶ x 10⁶ 的网格中，每个网格上方格的坐标为 (x, y) 。
 * <p>
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * <p>
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 * <p>
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * <p>
 * 无法向北或者向东移动是因为方格禁止通行。
 * <p>
 * 无法向南或者向西移动是因为不能走出网格。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= blocked.length <= 200
 * <p>
 * blocked[i].length == 2
 * <p>
 * 0 <= xi, yi < 10⁶
 * <p>
 * source.length == target.length == 2
 * <p>
 * 0 <= sx, sy, tx, ty < 10⁶
 * <p>
 * source != target
 * <p>
 * 题目数据保证 source 和 target 不在封锁列表内
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 数组 哈希表 👍 60 👎 0
 *
 * @author baojunjie
 * @date 2021/12/3
 */
public class EscapeTheMaze {
    private static int dirs[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int limit = (int) 1e6;

    public boolean isEscapePossible2(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();
        for (int block[] : blocked)
            blocks.add(block[0] + ":" + block[1]);
        return bfs(source, target, blocks) && bfs(target, source, blocks);
    }

    public boolean bfs(int[] source, int[] target, Set<String> blocks) {
        Set<String> seen = new HashSet<>();
        seen.add(source[0] + ":" + source[1]);
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(source);
        while (!bfs.isEmpty()) {
            int cur[] = bfs.poll();
            for (int dir[] : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextX < 0 || nextY < 0 || nextX >= limit || nextY >= limit)
                    continue;
                String key = nextX + ":" + nextY;
                if (seen.contains(key) || blocks.contains(key))
                    continue;
                if (nextX == target[0] && nextY == target[1])
                    return true;
                bfs.offer(new int[]{nextX, nextY});
                seen.add(key);
            }
            // 因为 blocked 的 length 是 200
            // 如果使用这 200 个 block 可以围成最大的区域是 19900
            // 也就是说，如果迭代了 20000 步还能继续走的话，那么是肯定可以到达 target 的
            if (seen.size() == 20000)
                return true;
        }
        return false;
    }

    @Test
    public void test() {
        // isEscapePossible2()
    }
}
