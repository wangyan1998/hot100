package algorithm;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//        实现 MinStack 类:
//        MinStack() 初始化堆栈对象。
//        void push(int val) 将元素val推入堆栈。
//        void pop() 删除堆栈顶部的元素。
//        int top() 获取堆栈顶部的元素。
//        int getMin() 获取堆栈中的最小元素。
//        -2^31<= val <= 2^31- 1
//        pop、top 和 getMin 操作总是在 非空栈 上调用
//        push,pop,top, and getMin最多被调用3 * 10^4次


import java.util.Stack;

/**
 * @author wy
 * @date 2022/3/1 16:04
 */
public class MinStack {
    Stack<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }

    public void push(int x) {
        A.push(x);
        if(B.isEmpty()||x<=B.peek()){
            B.push(x);
        }
    }

    public void pop() {
        if(A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
}
