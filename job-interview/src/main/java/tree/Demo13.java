package tree;

import com.fww.entity.Node;

/**
 * Created by fengweiwei on 2017/4/6.
 * 判断二叉树是否为平衡二叉树
 */
public class Demo13 {
    public static boolean isBalance(Node head) {
        if (head == null) {
            return true;
        }

        if (isBalance(head.left) && isBalance(head.right)) {
            //compute high
            int ret = getHeight(head.left) - getHeight(head.right);
            return ret == 1 || ret == 0 || ret == -1;
        }
        return false;
    }

    //todo
    public static boolean isBalance_(Node head) {
        return false;
    }

    private static int getHeight(Node head) {
        if (head == null) {
            return 0;
        }
        return Math.max(getHeight(head.left), getHeight(head.right)) + 1;
    }

    public static void main(String[] args) {
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

        System.out.println(isBalance(head));
    }
}
