package algorithm;

import tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2022/3/4 15:41
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        StringBuffer s = new StringBuffer();
        while (p != null) {
            s.append(p.val);
            p = p.next;
        }
        if (s.toString().equals(s.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome1(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
