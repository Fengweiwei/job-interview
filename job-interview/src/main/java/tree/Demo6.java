package tree;

import com.fww.entity.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fengweiwei on 2017/4/5.
 * 在二叉树中找到累加和为指定值的最长路径长度
 */
public class Demo6 {
    public static List<Node> maxLengthPath(Node head, int sum) {
        List<Node> path = new LinkedList<>();
        return null;
    }

    //找到所有符合的path
    private static List<List<Node>> traversal_max(Node head, int sum, List<Node> path, List<List<Node>> list) {
        if (head == null) {
            return list;
        }
        if (sum >= 0) {
            path.add(head);

            if (head.left == null && head.right == null && sum == head.val) {
                list.add(new LinkedList<>(path));
            }

            traversal_max(head.left, sum - head.val, path, list);
            traversal_max(head.right, sum - head.val, path, list);
            path.remove(head);
        }
        return list;
    }

    //找到所有path
    private static List<List<Node>> traversal(Node head, List<Node> path, List<List<Node>> list) {
        if (head == null) {
            return list;
        }

        path.add(head);

        if (head.left == null && head.right == null) {
            list.add(new LinkedList<>(path));
        }

        traversal(head.left, path, list);
        traversal(head.right, path, list);
        path.remove(head);
        return list;
    }

    public static void main(String[] args) {
        Node head = new Node(-3);
        head.left = new Node(3);
        head.right = new Node(-9);
        head.left.left = new Node(1);
        head.left.right = new Node(0);
        head.left.right.left = new Node(1);
        head.left.right.right = new Node(6);
        head.right.left = new Node(2);
        head.right.right = new Node(1);

        List<List<Node>> list = new ArrayList<>();
        List<Node>       path = new LinkedList<>();
        traversal_max(head, 1, path, list);
        list.forEach(l -> {
            System.out.print("[");
            l.forEach(n -> {
                System.out.print(n.val + ",");
            });
            System.out.println("]");
        });
        System.console();
    }
}
