package base.bitoperation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 7991uxug@gmail.com
 * @date 12/5/22 11:44 PM
 */
public class Demo {
    List<Integer> stack;
    List<Integer> minStack;

    public Demo() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || minStack.get(minStack.size() - 1) >= val) {
            minStack.add(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if ((int)stack.get(stack.size() - 1) == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
            System.out.println(minStack);
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }

    public static void main(String[] args) {
//        Demo demo = new Demo();
//        demo.push(512);
//        demo.push(-1024);
//        demo.push(-1024);
//        demo.push(512);
//        demo.pop();
//        demo.pop();
//        demo.pop();
//        System.out.println(demo.getMin());
        long[] a = {1,2,3,4};
        long[] b = {100,200,300,400,500};
        b = a;
        System.out.println(b.length);
        System.out.println(b[0]);
    }
}
