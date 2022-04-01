 /**
 * @author Anonymous
 * @since 2019/12/8
 */


public class Solution52 {
     //  Definition for singly-linked list.
     class ListNode52 {
         int val;
         ListNode52 next;
         ListNode52(int x) {
             val = x;
             next = null;
         }
     }
    /**
     * 求两链表第一个公共节点
     * 
     * @param headA 链表A
     * @param headB 链表B
     * @return 第一个公共节点
     */
    public ListNode52 findFirstCommonNode(ListNode52 headA, ListNode52 headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int n1 = len(headA), n2 = len(headB);
        ListNode52 p1 = headA, p2 = headB;
        if (n1 > n2) {
            for (int i = 0; i < n1 - n2; ++i) {
                p1 = p1.next;
            }
        } else if (n1 < n2) {
            for (int i = 0; i < n2 - n1; ++i) {
                p2 = p2.next;
            }
        }
        while (p1 != p2 && p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return (p1 == null || p2 == null) ? null : p1;
    }

    private int len(ListNode52 head) {
        int n = 0;
        ListNode52 cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        return n;
    }
}