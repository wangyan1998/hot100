package algorithm;

import tool.ListNode;

import java.util.List;
//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//        请你将两个数相加，并以相同形式返回一个表示和的链表。
//        你可以假设除了数字 0 之外，这两个数都不会以 0开头。


/**
 * @author wy
 * @version 1.0
 * @date 2021/5/4 19:58
 */
public class AddTwoNumbers {
    /**
     * 自写代码
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode h1=l1;
        ListNode h2=l2;
        ListNode head=new ListNode();
        ListNode h3=head;
        int next=0;
        int s=0;
        while(h1!=null||h2!=null){
            if(h1==null){
                s=h2.val+next;
            }else if(h2==null){
                s=h1.val+next;
            }else{
                s=h1.val+h2.val+next;
            }
            ListNode node=new ListNode(s%10);
            next=s/10;
            h3.next=node;
            h3=node;
            if(h1!=null){
                h1=h1.next;
            }
            if(h2!=null){
                h2=h2.next;
            }
        }
        if(next!=0){
            h3.next=new ListNode(next);
        }
        return head.next;
    }

    /**
     * 题解答案，思路相同，但是代码更加优雅简洁
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1,ListNode l2){
        ListNode head=null,tail=null;
        int carry=0;
        while(l1!=null||l2!=null){
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            int sum=n1+n2+carry;
            if(head==null){
                head=tail=new ListNode(sum%10);
            }else {
                tail.next=new ListNode(sum%10);
                tail=tail.next;
            }
            carry=sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            tail.next=new ListNode(carry);
        }
        return head;
    }
}
