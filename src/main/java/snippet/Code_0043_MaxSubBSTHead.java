package snippet;

import java.util.ArrayList;

/**
 * 给定一棵二叉树的头节点head， 返回这颗二叉树中最大的二叉搜索子树的头节点
 */
public class Code_0043_MaxSubBSTHead {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static Node maxSubBSTHead1(Node head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        Node leftAns = maxSubBSTHead1(head.left);
        Node rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }

    public static Node maxSubBSTHead2(Node head) {
        if (head == null) {
            return null;
        }
        return p(head).maxSubBSTHead;
    }

    public static Info p(Node head) {
        if (head == null) {
            return null;
        }
        Info left = p(head.left);
        Info right = p(head.right);
        if (right == null && left == null) {
            return new Info(head, head.value, head.value, 1);
        }
        Node maxSubBSTHead = left.size > right.size ? left.maxSubBSTHead : right.maxSubBSTHead;
        int size = maxSubBSTHead == left.maxSubBSTHead?left.size:right.size;
        int max = maxSubBSTHead == left.maxSubBSTHead?left.max:right.max;
        int min = maxSubBSTHead == left.maxSubBSTHead?left.min:right.min;
        if(head.value >= right.min && head.value <= left.max){
            return new Info(maxSubBSTHead,max,min,size);
        }
        // TODO
        return null;
    }

    public static class Info {

        public Info(Node maxSubBSTHead, int max, int min, int size) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.max = max;
            this.min = min;
            this.size = size;
        }

        private Node maxSubBSTHead;
        private int max;
        private int min;
        private int size;// 最大搜索子树的大小

    }
//    public static Node maxSubBSTHead2(Node head) {
//        if (head == null) {
//            return null;
//        }
//        return process(head).maxSubBSTHead;
//    }
//
//    // 每一棵子树
//    public static class Info {
//        public Node maxSubBSTHead;
//        public int maxSubBSTSize;
//        public int min;
//        public int max;
//
//        public Info(Node h, int size, int mi, int ma) {
//            maxSubBSTHead = h;
//            maxSubBSTSize = size;
//            min = mi;
//            max = ma;
//        }
//    }
//
//    public static Info process(Node X) {
//        if (X == null) {
//            return null;
//        }
//        Info leftInfo = process(X.left);
//        Info rightInfo = process(X.right);
//        int min = X.value;
//        int max = X.value;
//        Node maxSubBSTHead = null;
//        int maxSubBSTSize = 0;
//        if (leftInfo != null) {
//            min = Math.min(min, leftInfo.min);
//            max = Math.max(max, leftInfo.max);
//            maxSubBSTHead = leftInfo.maxSubBSTHead;
//            maxSubBSTSize = leftInfo.maxSubBSTSize;
//        }
//        if (rightInfo != null) {
//            min = Math.min(min, rightInfo.min);
//            max = Math.max(max, rightInfo.max);
//            if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
//                maxSubBSTHead = rightInfo.maxSubBSTHead;
//                maxSubBSTSize = rightInfo.maxSubBSTSize;
//            }
//        }
//        if ((leftInfo == null || (leftInfo.maxSubBSTHead == X.left && leftInfo.max < X.value))
//                && (rightInfo == null || (rightInfo.maxSubBSTHead == X.right && rightInfo.min > X.value))) {
//            maxSubBSTHead = X;
//            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
//                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
//        }
//        return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
//    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != maxSubBSTHead2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
