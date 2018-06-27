public class BstChecker {

    public static void main(String[] args) {
        new BstChecker().tree();
    }


    public void tree() {

        Node<Integer, String> n3 = new Node<>(42, "");
        Node<Integer, String> n4 = new Node<>(62, "");

        Node<Integer, String> n2 = new Node<>(52, "", n3, n4);
        Node<Integer, String> n1 = new Node<>(3, "");

        Node<Integer, String> root = new Node<>(47, "root", n1, n2);

        boolean bstCheck = bstCheck(root);
        System.out.println("isBst=" + bstCheck);

        bstCheck = bstCheck(n2);
        System.out.println("isBst=" + bstCheck);
    }

    public static boolean bstCheck(Node<Integer, String> r) {
        return bstCheck(r, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean bstCheck(Node<Integer, String> r, Integer min, Integer max) {
        if (r == null) { return true; }
        if (min > r.key || r.key >= max) { return false; }
        return bstCheck(r.lt, min, r.key) && bstCheck(r.rt, r.key, max);
    }

    private class Node<Ky,Val> {
        Ky key;
        Val value;
        Node<Ky, Val> lt;
        Node<Ky, Val> rt;
        public Node(Ky key, Val value) {
            this(key, value, null, null);
        }
        public Node(Ky key, Val value, Node<Ky, Val> lt, Node<Ky, Val> rt) {
            this.key = key;
            this.value = value;
            this.lt = lt;
            this.rt = rt;
        }
    }

}