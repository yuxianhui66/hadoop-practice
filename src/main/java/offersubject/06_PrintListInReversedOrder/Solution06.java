import org.junit.Test;

import java.util.Stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Anonymous
 * @since 2019/10/28
 */
public class Solution06 {
    /**
     * 从尾到头打印链表
     * @param listNode 链表头节点
     * @return list
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        
        return res;
    }

    @Test
    public void test(){
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(10);
        listNode.next=listNode1;
        System.out.println(printListFromTailToHead(listNode));
    }
}
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}