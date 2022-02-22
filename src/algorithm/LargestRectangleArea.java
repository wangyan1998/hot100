package algorithm;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//        求在该柱状图中，能够勾勒出来的矩形的最大面积。
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wy
 * @date 2022/2/22 16:07
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                // while (!stack.isEmpty() && heights[i] == heights[stack.peekLast()]) {
                //     stack.pollLast();
                // }
                int curWidth = 0;
                if (!stack.isEmpty()) {
                    curWidth = i - stack.peek() - 1;
                } else {
                    curWidth = i;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pop()];
            // while (!stack.isEmpty() && curHeight == heights[stack.peekLast()]) {
            //     stack.pollLast();
            // }
            int curWidth = 0;
            if (!stack.isEmpty()) {
                curWidth = len - stack.peek() - 1;
            } else {
                curWidth = len;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }
}
