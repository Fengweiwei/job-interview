package tree;

import com.fww.entity.Node;

/**
 * Created by fengweiwei on 2017/4/6.
 * 判断t1树是否包含t2树全部的拓扑结构
 */
public class Demo11 {
    public static boolean contains(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null) {
            return false;
        } else if (t2 == null) {
            return true;
        }

        if (t1.val == t2.val) {
            return contains(t1.left, t2.left) && contains(t1.right, t2.right);
        } else {
//            boolean flag = contains(t1.left, t2);
//            if (!flag) {
//                flag = contains(t1.right, t2);
//            }
//            return flag;
            return contains(t1.left, t2) || contains(t1.right, t2);
        }
    }

    public static void main(String[] args) {
        //create t1
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        head.left.right.left = new Node(10);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        //create t2
        Node head2 = new Node(2);
        head2.left = new Node(4);
        head2.right = new Node(5);
        head2.left.left = new Node(8);

        System.out.println(contains(head, head2));
    }
}
