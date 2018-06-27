import java.util.Arrays;


public class BalancedBinaryTree 
{

    public static void main(String[] args)
    {
        new BalancedBinaryTree().tree();
    }

    public void tree() 
    {

        Node n9 = new Node(null, null);
        Node n10 = new Node(null, null);

        Node n7 = new Node(null, null);
        Node n8 = new Node(n9, n10);

        Node n3 = new Node(null, null);
        Node n4 = new Node(null, null);
        Node n5 = new Node(null, null);
        Node n6 = new Node(n7, n8);

        Node n1 = new Node(n3, n4);
        Node n2 = new Node(n5, n6);

        Node root = new Node(n1, n2);
        System.out.println("isBalanced()=" + isBalanced(root));
        System.out.println("isBalanced()=" + isBalanced(n2));
    }

    private boolean isBalanced(Node r) 
    {
        if (r == null) 
        { 
            return true; 
        }

        int[] heights = new int[2];
        Arrays.fill(heights, -1);
        boolean isBalanced = isBalanced(r, 0, heights);
        System.out.println("heights=" + Arrays.toString(heights));
        return isBalanced;
    }

    private boolean isBalanced(Node r, int ht, int[] heights) 
    {
        if (r == null) 
        { 
            return true; 
        }

        if (r.lt == null && r.rt == null) 
        {
            boolean isBalancedht = false;
            int empSlot = -1;
            for (int i = 0; i < heights.length; i++) 
            {
                if (heights[i] == ht) 
                { 
                    isBalancedht = true; 
                }

                if (heights[i] == -1) 
                { 
                    empSlot = i; 
                }
            }
            if (!isBalancedht) 
            {
                if (empSlot == -1) 
                {
                    return false;
                } 
                else 
                {
                    heights[empSlot] = ht;
                    for (int i : heights) 
                    {
                        if (i != -1 && ht - i > 1) 
                        { 
                            return false; 
                        }
                    }
                }
            }
        }
        return isBalanced(r.lt, ht + 1, heights) && isBalanced(r.rt, ht + 1, heights);
    }

    private class Node<Ky, Val> 
    {
        Node lt;
        Node rt;
        Ky key;
        Val value;
        public Node(Node lt, Node rt) 
        {
            this.lt = lt;
            this.rt = rt;
        }
    }

}