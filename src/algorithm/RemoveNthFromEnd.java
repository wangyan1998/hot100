package algorithm;

import tool.ListNode;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。


/**
 * @author wy
 * @date 2022/2/13 15:04
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head,int n){
        int l=0;
        ListNode p=head;
        while(p!=null){
            l++;
            p=p.next;
        }
        ListNode start=new ListNode(0);
        start.next=head;
        p=start;
        for(int i=0;i<l-n;i++){
            p=p.next;
        }
        p.next=p.next.next;
        return start.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 双指针法
        ListNode prior = head;
        ListNode pre = new ListNode(0,head); //新建一个头节点
        while(n-->0){
            prior = prior.next;
        }
        while(prior!=null){
            prior = prior.next;
            pre = pre.next;
        }

        if(pre.next == head){
            head = head.next;
        }else{
            pre.next = pre.next.next;
        }

        return head;
    }
}
