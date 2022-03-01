package algorithm;
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
// 如果两个链表不存在相交节点，返回 null 。
import tool.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2022/3/1 16:54
 */
public class GetIntersectionNode {
    /**
     * 使用set
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int n1 = 0, n2 = 0;
        ListNode temp1 = headA, temp2 = headB;
        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        if (n1 > n2) {
            for (int i = 0; i < n1 - n2; i++) {
                temp1 = temp1.next;
            }
            while (temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

        } else {
            for (int i = 0; i < n2 - n1; i++) {
                temp2 = temp2.next;
            }
            while (temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return temp1;
    }
}
