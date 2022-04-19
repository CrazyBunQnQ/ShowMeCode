package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * <p>
 * int pop() 从队列的开头移除并返回元素
 * <p>
 * int peek() 返回队列开头的元素
 * <p>
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * <p>
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * <p>
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * <p>
 * myQueue.push(1); // queue is: [1]
 * <p>
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * <p>
 * myQueue.peek(); // return 1
 * <p>
 * myQueue.pop(); // return 1, queue is [2]
 * <p>
 * myQueue.empty(); // return false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * <p>
 * 最多调用 100 次 push、pop、peek 和 empty
 * <p>
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * <p>
 * Related Topics 栈 设计 队列 👍 497 👎 0
 * <p>
 * MyQueue 对象将被实例化并被调用:
 * <p>
 * MyQueue obj = new MyQueue();
 * <p>
 * obj.push(x);
 * <p>
 * int param_2 = obj.pop();
 * <p>
 * int param_3 = obj.peek();
 * <p>
 * boolean param_4 = obj.empty();
 *
 * @author baojunjie
 * @date 2021/11/3
 */
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int len = stack1.size();
        while (len != 1) {
            len--;
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public int peek() {
        int len = stack1.size();
        while (len != 1) {
            len--;
            stack2.push(stack1.pop());
        }
        int result = stack1.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public boolean empty() {
        return stack1.empty();
    }



    @Test
    public void myQueueTest() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.peek();
        queue.pop();
        queue.empty();
    }
}
