package columbus.week3.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 트리순회 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Node> nodeMap = new HashMap<>();
        sc.nextLine();
        while (N-- > 0) {
            String[] i = sc.nextLine().split(" ");

            Node node = nodeMap.getOrDefault(i[0], new Node(i[0]));
            if (!i[1].equals(".")) {
                Node left = nodeMap.getOrDefault(i[1], new Node(i[1]));
                node.setLeft(left);
                nodeMap.put(i[1], left);
            }
            if (!i[2].equals(".")) {
                Node right = nodeMap.getOrDefault(i[2], new Node(i[2]));
                node.setRight(right);
                nodeMap.put(i[2], right);
            }
            nodeMap.put(i[0], node);
        }


        Node root = nodeMap.get("A");
        root.preorder();
        System.out.println();
        root.inorder();
        System.out.println();
        root.postorder();

    }

    static class Node {
        String alphabet;
        Node left;
        Node right;

        Node(String alphabet) {
            this.alphabet = alphabet;
        }

        void setLeft(Node node) {
            left = node;
        }

        void setRight(Node node) {
            right = node;
        }

        void preorder() {
            System.out.print(alphabet);
            if (left != null)
                left.preorder();
            if (right != null)
                right.preorder();
        }


        void inorder() {
            if (left != null)
                left.inorder();
            System.out.print(alphabet);
            if (right != null)
                right.inorder();
        }

        void postorder() {
            if (left != null)
                left.postorder();
            if (right != null)
                right.postorder();
            System.out.print(alphabet);
        }


    }
}
