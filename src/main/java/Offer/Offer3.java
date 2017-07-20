package Offer;

import java.util.ArrayList;

/**
 * Created by huchao on 2017/7/20.
 * 题目描述:
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class Offer3 {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return list;
        }
        printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
