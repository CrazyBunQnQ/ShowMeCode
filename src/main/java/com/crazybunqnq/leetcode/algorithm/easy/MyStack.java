package com.crazybunqnq.leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * <p>
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * <p>
 * [[], [1], [2], [], [], []]
 * 输出：
 * <p>
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * <p>
 * MyStack myStack = new MyStack();
 * <p>
 * myStack.push(1);
 * <p>
 * myStack.push(2);
 * <p>
 * myStack.top(); // 返回 2
 * <p>
 * myStack.pop(); // 返回 2
 * <p>
 * myStack.empty(); // 返回 False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * <p>
 * 最多调用100 次 push、pop、top 和 empty
 * <p>
 * 每次调用 pop 和 top 都保证栈不为空
 * <p>
 * <p>
 * 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的时间。你可以使用两个以上的队列。
 * <p>
 * Related Topics 栈 设计 队列 👍 393 👎 0
 * <p>
 * 你的 MyStack 对象将被实例化并被调用:
 * <p>
 * MyStack obj = new MyStack();
 * <p>
 * obj.push(x);
 * <p>
 * int param_2 = obj.pop();
 * <p>
 * int param_3 = obj.top();
 * <p>
 * boolean param_4 = obj.empty();
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户
 * <p>
 * TODO 内存消耗:36.5 MB,击败了5.08% 的Java用户
 * @author baojunjie
 * @date 2021/11/3
 */
public class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        int len = q1.size();
        while (len != 1) {
            len--;
            q2.add(q1.poll());
        }
        int result = q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return result;
    }

    public int top() {
        int len = q1.size();
        while (len != 1) {
            len--;
            q2.add(q1.poll());
        }
        int result = q1.poll();
        q2.add(result);
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return result;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
