package algorithm;
//给你一个链表数组，每个链表都已经按升序排列。
//        请你将所有链表合并到一个升序链表中，返回合并后的链表。
import tool.ListNode;

/**
 * @author wy
 * @date 2022/2/14 14:49
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode list = null;
        for (int i = 0; i < lists.length; i++) {
            list = mergeTwoLists(list, lists[i]);
        }
        return list;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
