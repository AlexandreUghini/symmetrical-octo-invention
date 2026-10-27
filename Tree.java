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
        if(left == null && right ==null)
            return String.format("%c",
                data);

        if (parent == null)
        return String.format("%s %c %s",
                left == null ? "" : left.central(),
                data,
                right == null ? "" : right.central());

        return String.format("(%s %c %s)",
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
        Node plus2 = new Node ('+');
        Node sub2 = new Node ('-');
        Node mult1 = new Node ('*');
        Node c = new Node ('C');
        Node d = new Node('D');
        Node e = new Node ('E');
        Node sub1 = new Node ('-');
        Node f = new Node ('F');
        Node g = new Node ('G');
        Node div1 = new Node ('/');

        sub2.left = plus1;
        sub2.right = plus2;
        plus1.parent = plus2.parent = sub2;
        
        plus1.left = a;
        plus1.right = b;
        a.parent = b.parent = plus1;

        plus2.left = mult1;
        plus2.right = div1;
        mult1.parent = div1.parent = plus2;

        sub1.left = d;
        sub1.right = e;
        d.parent = e.parent = sub1;

        mult1.left = c;
        mult1.right = sub1;
        c.parent = sub1.parent = mult1;

        div1.left = f;
        div1.right = g;
        f.parent = g.parent = div1;

        System.out.println(sub2);
        System.out.println(sub2.pre());
        System.out.println(sub2.central());
        System.out.println(sub2.pos());
    }

    public static void main(String[] args) {
        example2();
    }
}