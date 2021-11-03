package com.crazybunqnq.leetcode.algorithm.easy;

import java.util.List;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。<p>
 * pop() —— 删除栈顶的元素。<p>
 * top() —— 获取栈顶元素。<p>
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]<p>
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：<p>
 * MinStack minStack = new MinStack();<p>
 * minStack.push(-2);<p>
 * minStack.push(0);<p>
 * minStack.push(-3);<p>
 * minStack.getMin();   --> 返回 -3.<p>
 * minStack.pop();<p>
 * minStack.top();      --> 返回 0.<p>
 * minStack.getMin();   --> 返回 -2.<p>
 * <p>
 * <p>
 * 你的 MinStack 对象将被实例化并被调用:<p>
 * MinStack obj = new MinStack();<p>
 * obj.push(val);<p>
 * obj.pop();<p>
 * int param_3 = obj.top();<p>
 * int param_4 = obj.getMin();<p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * Related Topics 栈 设计 👍 1063 👎 0
 *
 * TODO 只用一个栈
 * @author baojunjie
 * @date 2021/11/3
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minVals;

    public MinStack() {
        stack = new Stack<>();
        minVals = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minVals.isEmpty() || val <= minVals.peek()) {
            minVals.push(val);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top == minVals.peek()) {
            minVals.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVals.peek();
    }
}
