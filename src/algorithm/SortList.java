package algorithm;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
import tool.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wy
 * @date 2022/3/1 11:23
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        p = head;
        int i = 0;
        while (p != null) {
            p.val = list.get(i);
            p = p.next;
            i++;
        }
        return head;
    }

    public ListNode sortList1(ListNode head) {
        return sort(head, null);
    }

    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sort(head, mid);
        ListNode list2 = sort(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp2 = temp2.next;
            } else {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
