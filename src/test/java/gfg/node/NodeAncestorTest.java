package gfg.node;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NodeAncestorTest {

    private NodeAncestor nodeAncestor;

    @Before
    public void setUp() {
        nodeAncestor = new NodeAncestor();
    }

    @Test
    public void testFindKthAncestor() {
        TreeNode thirdLevelFirstNodeLeft = new TreeNode(4);
        TreeNode thirdLevelFirstNodeRight = new TreeNode(5);

        TreeNode secondLevelFirstNodeLeft = new TreeNode(2, thirdLevelFirstNodeLeft, thirdLevelFirstNodeRight);
        TreeNode secondLevelFirstNodeRight = new TreeNode(3);

        TreeNode head = new TreeNode(1, secondLevelFirstNodeLeft, secondLevelFirstNodeRight);
        assertThat(nodeAncestor.kthAncestor(head,2,4), is(1));
    }

    /*
    Tree for the following test case as follows:
             1
           /   \
          2     3
           \     \
            5    10
           / \   / \
          8   9 11  12
               /
              13
     */
    @Test
    public void testFindKthAncestorMoreNodes() {
        TreeNode fifthLevelFirstNodeLeft = new TreeNode(13);

        TreeNode fourthLevelSecondNodeLeft = new TreeNode(11, fifthLevelFirstNodeLeft, null);
        TreeNode fourthLevelSecondNodeRight = new TreeNode(12);

        TreeNode fourthLevelFirstNodeLeft = new TreeNode(8);
        TreeNode fourthLevelFirstNodeRight = new TreeNode(9);

        TreeNode thirdLevelFirstNodeRight = new TreeNode(5, fourthLevelFirstNodeLeft, fourthLevelFirstNodeRight);
        TreeNode thirdLevelSecondNodeRight = new TreeNode(10, fourthLevelSecondNodeLeft, fourthLevelSecondNodeRight);

        TreeNode secondLevelFirstNodeLeft = new TreeNode(2, null, thirdLevelFirstNodeRight);
        TreeNode secondLevelFirstNodeRight = new TreeNode(3, null, thirdLevelSecondNodeRight);

        TreeNode head = new TreeNode(1, secondLevelFirstNodeLeft, secondLevelFirstNodeRight);
        assertThat(nodeAncestor.kthAncestor(head,3,13), is(3));
        assertThat(nodeAncestor.kthAncestor(head,4,13), is(1));
        assertThat(nodeAncestor.kthAncestor(head,5,13), is(-1));

        assertThat(nodeAncestor.kthAncestor(head,2,9), is(2));
        assertThat(nodeAncestor.kthAncestor(head,3,8), is(1));
        assertThat(nodeAncestor.kthAncestor(head,4,8), is(-1));
    }

    @Test
    public void testFindKthAncestorWhenRootDoesNotExists() {
        TreeNode thirdLevelFirstNodeLeft = new TreeNode(4);
        TreeNode thirdLevelFirstNodeRight = new TreeNode(5);

        TreeNode secondLevelFirstNodeLeft = new TreeNode(2, thirdLevelFirstNodeLeft, thirdLevelFirstNodeRight);
        TreeNode secondLevelFirstNodeRight = new TreeNode(3);

        TreeNode head = new TreeNode(1, secondLevelFirstNodeLeft, secondLevelFirstNodeRight);
        assertThat(nodeAncestor.kthAncestor(head,3,4), is(-1));
    }

    @Test
    public void testFindKthAncestorRootOnly() {
        TreeNode head = new TreeNode(1);
        assertThat(nodeAncestor.kthAncestor(head,1,1), is(-1));
    }
}
