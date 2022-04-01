package CSNotes;

import java.util.Stack;

/**
 * @author: xianhui.yu
 * @create: 2022-01-21 10:20
 **/

/**
 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
 *
 * ## 解题思路
 *
 * 使用一个额外的 minStack，栈顶元素为当前栈中最小的值。在对栈进行 push 入栈和 pop 出栈操作时，同样需要对 minStack 进行入栈出栈操作，从而使 minStack 栈顶元素一直为当前栈中最小的值。在进行 push 操作时，需要比较入栈元素和当前栈中最小值，将值较小的元素 push 到 minStack 中。
 */
public class MinStack {
    private Stack<Integer> stack  = new Stack();
    private Stack<Integer> minStack  = new Stack();

    private void push(Integer num){
        stack.push(num);
        if(minStack.isEmpty()){
            minStack.push(num);
        }else{
            if(minStack.peek()>num){
                minStack.pop();
                minStack.push(num);
            }
        }
    }
    private void pop(){
        stack.pop();
        minStack.pop();
    }
    private int top(){
        return stack.peek();
    }
    private int min(){
        return minStack.peek();
    }

}
