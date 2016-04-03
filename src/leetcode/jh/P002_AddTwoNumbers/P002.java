package leetcode.jh.P002_AddTwoNumbers;

import java.util.List;

/**
 * Created by jh on 16-4-3.
 */
public class P002 {
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int val=(l1.val+l2.val)%10;
            int carry=(l1.val+l2.val)/10;
            ListNode startNode=new ListNode(val);
            ListNode prev=startNode;
            l1=l1.next;
            l2=l2.next;
            while (l1!=null || l2!=null || carry!=0){
                int val1=0,val2=0;
                if (l1!=null){
                    val1=l1.val;
                    l1=l1.next;
                }
                if (l2!=null){
                    val2=l2.val;
                    l2=l2.next;
                }
                val=(val1+val2+carry)%10;
                carry=(val1+val2+carry)/10;
                prev.next=new ListNode(val);
                prev=prev.next;
            }
            return startNode;
        }
    }

    public ListNode listNodes(int [] digits){
        ListNode startNode=new ListNode(digits[0]);
        ListNode prev=startNode;
        for (int i=1;i<digits.length;++i){
            prev.next=new ListNode(digits[i]);
            prev=prev.next;
        }
        return startNode;
    }

    public void output(ListNode node){
        System.out.print("list: ");
        System.out.print(node.val);
        while (node.next!=null){
            node=node.next;
            System.out.print(" -> "+node.val);
        }
        System.out.print('\n');
    }


    public void test(){
        int [] num1=new int[]{2,4,5};
        int [] num2=new int[]{5,6,4,9};
        ListNode node1=listNodes(num1);
        ListNode node2=listNodes(num2);
        output(node1);
        output(node2);
        Solution solution=new Solution();
        ListNode ans=solution.addTwoNumbers(node1,node2);
        output(ans);
    }
}
