import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

class Node {
    Character data;
    Node left;
    Node right;
    Node parent;

    Node() {
    }

    Node(Character data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("(%s %c %s)", left == null ? "#" : left.toString(), data,
                right == null ? "#" : right.toString());
    }

    public String pre() {
        return String.format("%c %s %s",
                data,
                left == null ? "" : left.pre(),
                right == null ? "" : right.pre());
    }

    public String central() {
        return String.format("%s %c %s",
                left == null ? "" : left.central(),
                data,
                right == null ? "" : right.central());
    }

    public String pos() {
        return String.format("%S %s %c",
                left == null ? "" : left.pos(),
                right == null ? "" : right.pos(),
                data);
    }

    public List<Character> breadth() { // width?
        Queue<Node> q = new LinkedList<>();
        List<Character> result = new ArrayList<>();
        q.add(this);
        while (!q.isEmpty()) {
            Node n = q.remove();
            result.add(n.data);
            if (n.left != null)
            q.add(n.left);
            if (n.right != null)
            q.add(n.right);
        }
        return result;
    }
}

public class Tree {

    public static String toString(Node n) {

        return n.toString();
    }

    /**
     * A
     * / \
     * B #
     * / \
     * # C
     * / \
     * E D
     * / \ / \
     * # F G #
     * 
     * A
     * +#
     * +B
     * +C
     * +E
     * +F
     * +#
     * +D
     * +#
     * +G
     * +#
     * 
     * ((# B ((# E (# F #)) C ((# G #) D #))) A #)
     * 
     * @param args
     */
    public static void example1() {
        System.out.println("Tree!");

        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();

        a.data = 'A';
        b.data = 'B';
        c.data = 'C';
        d.data = 'D';
        e.data = 'E';
        f.data = 'F';
        g.data = 'G';

        b.parent = a;
        c.parent = b;
        e.parent = c;
        d.parent = c;
        f.parent = e;
        g.parent = d;

        a.left = b;
        b.right = c;
        c.left = e;
        c.right = d;
        e.right = f;
        d.left = g;

        System.out.println(toString(a));
        System.out.println(a.breadth());
    }

    public static void example2() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node plus1 = new Node('+');

        plus1.left = a;
        plus1.right = b;
        a.parent = b.parent = plus1;

        System.out.println(plus1);
        System.out.println(plus1.pre());
        System.out.println(plus1.central());
        System.out.println(plus1.pos());

    }

    public static void main(String[] args) {
        example1();
    }
}